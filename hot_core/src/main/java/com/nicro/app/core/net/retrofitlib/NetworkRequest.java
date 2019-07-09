/**
 * Copyright (C), nicro有限公司
 * FileName: NetworkRequest
 * Author: rongwenzhao
 * Date: 2019/7/9 17:17
 * Description: NetworkRequest
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.net.retrofitlib;

import com.nicro.app.core.net.retrofitlib.demo.RetrofitEntity;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * @ClassName: NetworkRequest
 * @Description: NetworkRequest
 * @Author: rongwenzhao
 * @Date: 2019/7/9 17:17
 */
public class NetworkRequest {
    public static final NetworkRequest getInstance() {
        return SingletonHolder.instance;
    }

    private static final NetworkService getVideoService() {
        return SingletonHolder.video_service;
    }

    public void getVideoTranslation(Subscriber subscriber) {
        getVideoService().getAllVedioBy(true).compose(new ComposeThread<RetrofitEntity>()).subscribe(subscriber);
    }

    private static class SingletonHolder {
        private static final NetworkRequest instance = new NetworkRequest();
        private static final NetworkService video_service = NetworkService.Factory.create(NetworkService.BASE_VIDEO_URL);
    }

    private class ComposeThread<T> implements Observable.Transformer<T, T> {
        @Override
        public Observable<T> call(Observable<T> observable) {
            return observable
                    .subscribeOn(Schedulers.io())
                    .unsubscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }
    }


}