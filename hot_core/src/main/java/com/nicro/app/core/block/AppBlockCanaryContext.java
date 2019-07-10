/**
 * Copyright (C), nicro有限公司
 * FileName: AppBlockCanaryContext
 * Author: rongwenzhao
 * Date: 2019/7/10 15:42
 * Description: BlockCanary 参数设置
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.block;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.github.moduth.blockcanary.BlockCanaryContext;
import com.nicro.app.core.BuildConfig;
import com.nicro.app.core.CoreApplication;

/**
 * @ClassName: AppBlockCanaryContext
 * @Description: BlockCanary 参数设置
 * @Author: rongwenzhao
 * @Date: 2019/7/10 15:42
 */
public class AppBlockCanaryContext extends BlockCanaryContext {
    private static final String TAG = "AppBlockCanaryContext";

    /***
     *
     * provideQualifier: 获取应用版本信息
     *
     * provideUid: 获取用户uid
     *
     * provideNetworkType: 获取网络类型
     *
     * provideMonitorDuration: 设置监控时长,eg:100000ms
     *
     * provideBlockThreshold: 设置监控卡顿阀值,eg:1000ms
     *
     * providePath: 设置log保存地址, eg:BlockTest
     *
     * displayNotification: 设置是否在桌面展示,eg: true or false
     * */


    @Override
    public String provideQualifier() {
        String qualifier = "";
        try {
            PackageInfo info = CoreApplication.getInstance().getPackageManager()
                    .getPackageInfo(CoreApplication.getInstance().getPackageName(), 0);
            qualifier += info.versionCode + "_" + info.versionName + "_YYB";
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "provideQualifier exception", e);
        }
        return qualifier;
    }

    @Override
    public String providePath() {
        return "BlockLogFolder";
    }

    @Override
    public int provideBlockThreshold() {
        return 500;
    }

    @Override
    public boolean displayNotification() {
        return BuildConfig.DEBUG;
    }

    @Override
    public boolean stopWhenDebugging() {
        return false;
    }
}