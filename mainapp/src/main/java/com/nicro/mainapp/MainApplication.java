/**
 * Copyright (C), nicro有限公司
 * FileName: MainApplication
 * Author: rongwenzhao
 * Date: 2019/7/9 9:36
 * Description: 自己的Application
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * @ClassName: MainApplication
 * @Description: 自己的Application
 * @Author: rongwenzhao
 * @Date: 2019/7/9 9:36
 */
public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}