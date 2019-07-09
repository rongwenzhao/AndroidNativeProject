/**
 * Copyright (C), nicro有限公司
 * FileName: NetworkService
 * Author: rongwenzhao
 * Date: 2019/7/9 15:35
 * Description: 网络请求的Service
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.net.retrofitlib;

import com.nicro.app.core.CoreApplication;
import com.nicro.app.core.net.retrofitlib.demoentity.BaseResultEntity;
import com.nicro.app.core.net.retrofitlib.demoentity.RetrofitEntity;
import com.nicro.app.core.net.retrofitlib.demoentity.SubjectResult;
import com.orhanobut.logger.Logger;

import java.io.File;
import java.io.IOException;
import java.util.List;
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
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @ClassName: NetworkService
 * @Description: 网络请求的Service
 * @Author: rongwenzhao
 * @Date: 2019/7/9 15:35
 */
public interface NetworkService {
    String CACHE_PATH = "okhttp_cache";
    /*基础url*/
    String BASE_VIDEO_URL = "https://www.izaodao.com/Api/";

    class Factory {
        public static final NetworkService create(String baseUrl) {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(logInterceptor)//日志拦截器
                    .addNetworkInterceptor(new CacheInterceptor())
                    .connectTimeout(15, TimeUnit.SECONDS)//设置连接超时
                    .retryOnConnectionFailure(true)
                    .cache(new Cache(new File(CoreApplication.getApplication().getCacheDir(), CACHE_PATH), 1024 * 1024 * 10))
                    .build();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())//json数据转换
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//将Callable接口转换成Observable接口
                    .client(client)//网络请求客户端为okhttp
                    .build();
            return retrofit.create(NetworkService.class);
        }
    }

    class CacheInterceptor implements Interceptor {

        @Override
        public Response intercept(Chain chain) throws IOException {
            //可以进行网络重连接等操作
            //@link 这篇博客写的很详细:http://www.jianshu.com/p/faa46bbe8a2e
            Logger.d("Thread info");
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

    @POST("AppFiftyToneGraph/videoLink")
    Observable<RetrofitEntity> getAllVedioBy(@Body boolean once_no);

    @FormUrlEncoded
    @POST("AppFiftyToneGraph/videoLink")
    Observable<BaseResultEntity<List<SubjectResult>>> getAllVedioBys(@Field("once") boolean once_no);
}