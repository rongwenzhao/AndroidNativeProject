/**
 * Copyright (C), nicro有限公司
 * FileName: BaseResultEntity
 * Author: rongwenzhao
 * Date: 2019/7/9 16:37
 * Description: BaseResultEntity
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.models;

/**
 * @ClassName: BaseResultEntity
 * @Description: 回调信息统一封装类
 * @Author: rongwenzhao
 * @Date: 2019/7/9 16:37
 */
public class BaseResultEntity<T> {
    //  判断标示
    private int ret;
    //    提示信息
    private String msg;
    //显示数据（用户需要关心的数据）
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }
}