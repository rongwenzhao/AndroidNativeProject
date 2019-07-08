/**
 * Copyright (C), nicro有限公司
 * FileName: TextBean
 * Author: rongwenzhao
 * Date: 2019/7/8 13:51
 * Description: 主界面的測試bean
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.models;

/**
 * @ClassName: TextBean
 * @Description: 主界面的測試bean
 * @Author: rongwenzhao
 * @Date: 2019/7/8 13:51
 */
public class TextBean {
    private String title;
    private String subTitle;
    private int lable;

    public TextBean() {

    }

    public TextBean(String title, String subTitle, int lable) {
        this.title = title;
        this.subTitle = subTitle;
        this.lable = lable;
    }

    public int getLable() {
        return lable;
    }

    public void setLable(int lable) {
        this.lable = lable;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}