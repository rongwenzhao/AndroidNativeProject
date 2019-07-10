/**
 * Copyright (C), nicro有限公司
 * FileName: CoreApplication
 * Author: rongwenzhao
 * Date: 2019/7/9 15:39
 * Description: core lib对应的Application类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

/**
 * @ClassName: CoreApplication
 * @Description: core lib对应的Application类
 * @Author: rongwenzhao
 * @Date: 2019/7/9 15:39
 */
public class CoreApplication extends Application {
    private static CoreApplication instance;
    //leak demo
    //public static List<Fragment> fragments = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        Logger.addLogAdapter(new AndroidLogAdapter());
        setupLeakCanary();
    }

    public static CoreApplication getInstance(){
        return instance;
    }

    private RefWatcher setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return RefWatcher.DISABLED;
        }
        return LeakCanary.install(this);
    }

}