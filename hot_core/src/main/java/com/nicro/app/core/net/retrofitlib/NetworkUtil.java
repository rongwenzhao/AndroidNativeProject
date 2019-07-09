/**
 * Copyright (C), nicro有限公司
 * FileName: NetworkUtil
 * Author: rongwenzhao
 * Date: 2019/7/9 15:37
 * Description: 网络工具类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.net.retrofitlib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.nicro.app.core.CoreApplication;

/**
 * @ClassName: NetworkUtil
 * @Description: 网络工具类
 * @Author: rongwenzhao
 * @Date: 2019/7/9 15:37
 */
public class NetworkUtil {
    /**
     * 检测网络是否连接
     *
     * @return
     */
    public static boolean isNetworkAvailable() {
        boolean flag = false;
        final ConnectivityManager manager = (ConnectivityManager) CoreApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        //去进行判断网络是否连接
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }

    /**
     * 网络已经连接，然后去判断是wifi连接还是GPRS连接
     */
    public static String getNetworkType() {
        final ConnectivityManager manager = (ConnectivityManager) CoreApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo.State gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        NetworkInfo.State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if (gprs == NetworkInfo.State.CONNECTED || gprs == NetworkInfo.State.CONNECTING) {
            return "GPRS";
        }
        //判断为wifi状态下才加载广告，如果是GPRS手机网络则不加载！
        if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING) {
            return "WIFI";
        }
        return null;
    }
}