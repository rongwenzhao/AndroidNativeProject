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
}