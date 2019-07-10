/**
 * Copyright (C), nicro有限公司
 * FileName: RestClientCreator
 * Author: rongwenzhao
 * Date: 2019/7/10 9:30
 * Description: OkHttp和Retrofit的单例类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.net.retrofitlib;

import com.nicro.app.core.AppConstants;
import com.nicro.app.core.CoreApplication;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @ClassName: RestClientCreator
 * @Description: OkHttp和Retrofit的单例类
 * @Author: rongwenzhao
 * @Date: 2019/7/10 9:30
 */
public class RestClientCreator {

    public static Retrofit getRetrofitClient() {
        return RetrofitHolder.RETROFIT_CLIENT;
    }

    public static OkHttpClient getOkHttpClient() {
        return OkHttpHolder.OK_HTTP_CLIENT;
    }

    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                //日志拦截器
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                //缓存拦截器
                .addNetworkInterceptor(new RestClientCreator.CacheInterceptor())
                //设置连接超时
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(new Cache(new File(CoreApplication.getInstance().getCacheDir(), AppConstants.CACHE_PATH), 1024 * 1024 * 10))
                .build();
    }

    private static final class RetrofitHolder {
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(AppConstants.BASE_VIDEO_URL)
                .addConverterFactory(GsonConverterFactory.create())//json数据转换
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//将Callable接口转换成Observable接口
                .client(getOkHttpClient())//网络请求客户端为okhttp
                .build();
    }

    static class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            //可以进行网络重连接等操作
            //@link 这篇博客写的很详细:http://www.jianshu.com/p/faa46bbe8a2e
            Logger.d("Thread info");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Request request = chain.request();
            Response response = chain.proceed(request);
            if (NetworkUtil.isNetworkAvailable()) {
                // 有网络时 设置缓存超时时间0个小时
                response.newBuilder()
                        .header("Cache-Control", "public, max-age=" + 0)
                        .build();
            } else {
                response.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24)
                        .build();
            }
            return response;
        }
    }
}