/**
 * Copyright (C), nicro有限公司
 * FileName: BaseMvpPresenter
 * Author: rongwenzhao
 * Date: 2019/7/5 11:21
 * Description: 基础Presenter类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.mvp.base.presenter;

import com.nicro.app.core.mvp.base.view.BaseMvpView;

/**
 * @ClassName: BaseMvpPresenter
 * @Description: 基础Presenter类
 * @Author: rongwenzhao
 * @Date: 2019/7/5 11:21
 */
public abstract class BaseMvpPresenter<V extends BaseMvpView> {

    public V view;

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        view = null;
    }

}
