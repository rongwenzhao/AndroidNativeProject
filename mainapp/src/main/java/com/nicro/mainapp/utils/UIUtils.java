/**
 * Copyright (C), nicro有限公司
 * FileName: UIUtils
 * Author: rongwenzhao
 * Date: 2019/7/8 17:42
 * Description: UI相关的工具类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.utils;

import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;

/**
 * @ClassName: UIUtils
 * @Description: UI相关的工具类
 * @Author: rongwenzhao
 * @Date: 2019/7/8 17:42
 */
public class UIUtils {
    private static long lastClickTime;

    public static boolean isDoubleClick(int interval) {
        long currentClickTime = System.currentTimeMillis();
        if ((currentClickTime - lastClickTime) > interval) {
            lastClickTime = currentClickTime;
            return false;
        }
        return true;
    }

    public static boolean mKeyboardUp;
    private static ViewTreeObserver.OnGlobalLayoutListener mListener;

    /**
     * https://blog.csdn.net/xiaole0313/article/details/51537809
     * Android监听软键盘的显示与隐藏
     */
    public static void setListenerToRootView(final View rootView) {
        //final View rootView = getWindow().getDecorView().findViewById(android.R.id.content);
        //inputMethodManager.isActive(View view)//是否是当前view获得焦点
        if (mListener == null) {
            mListener = new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    final int softKeyboardHeight = 100;
                    Rect r = new Rect();
                    rootView.getWindowVisibleDisplayFrame(r);
                    DisplayMetrics dm = rootView.getResources().getDisplayMetrics();
                    int heightDiff = rootView.getBottom() - r.bottom;
                    if (heightDiff > softKeyboardHeight * dm.density) {
                        mKeyboardUp = true;
                    } else {
                        mKeyboardUp = false;
                    }
                }
            };
        }
        rootView.getViewTreeObserver().addOnGlobalLayoutListener(mListener);
    }

    private void removeListenerToRootView(View view) {
        if (mListener != null) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(mListener);
            mListener = null;
        }
    }
}