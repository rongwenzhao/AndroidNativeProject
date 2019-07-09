/**
 * Copyright (C), nicro有限公司
 * FileName: CoreApplication
 * Author: rongwenzhao
 * Date: 2019/7/9 15:39
 * Description: core lib对应的Application类，主应用初始化
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core;

import android.app.Application;

/**
 * @ClassName: CoreApplication
 * @Description: core lib对应的Application类，主应用初始化
 * @Author: rongwenzhao
 * @Date: 2019/7/9 15:39
 */
public class CoreApplication extends Application {
    private static Application application;
    private static boolean debug;


    public static void init(Application app) {
        setApplication(app);
        setDebug(true);
    }

    public static void init(Application app, boolean debug) {
        setApplication(app);
        setDebug(debug);
    }

    public static Application getApplication() {
        return application;
    }

    private static void setApplication(Application application) {
        CoreApplication.application = application;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean debug) {
        CoreApplication.debug = debug;
    }
}