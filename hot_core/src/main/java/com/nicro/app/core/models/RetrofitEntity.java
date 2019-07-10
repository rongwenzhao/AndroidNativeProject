/**
 * Copyright (C), nicro有限公司
 * FileName: RetrofitEntity
 * Author: rongwenzhao
 * Date: 2019/7/9 16:34
 * Description: 直接请求返回数据格式
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.models;

import java.util.List;

/**
 * @ClassName: RetrofitEntity
 * @Description: 直接请求返回数据格式
 * @Author: rongwenzhao
 * @Date: 2019/7/9 16:34
 */
public class RetrofitEntity {
    private int ret;
    private String msg;
    private List<SubjectResult> data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<SubjectResult> getData() {
        return data;
    }

    public void setData(List<SubjectResult> data) {
        this.data = data;
    }
}