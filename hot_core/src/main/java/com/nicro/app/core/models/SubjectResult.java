/**
 * Copyright (C), nicro有限公司
 * FileName: SubjectResult
 * Author: rongwenzhao
 * Date: 2019/7/9 16:34
 * Description: 测试显示数据
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.models;

/**
 * @ClassName: SubjectResult
 * @Description: 测试显示数据
 * @Author: rongwenzhao
 * @Date: 2019/7/9 16:34
 */
public class SubjectResult {
    private int id;
    private String name;
    private String title;

    @Override
    public String toString() {
        return "name->" + name + "\n";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}