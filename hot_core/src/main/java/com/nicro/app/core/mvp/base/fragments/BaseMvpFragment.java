/**
 * Copyright (C), nicro有限公司
 * FileName: BaseMvpFragment
 * Author: rongwenzhao
 * Date: 2019/7/5 11:48
 * Description: Mvp中Fragment的基类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.mvp.base.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nicro.app.core.mvp.base.presenter.BaseMvpPresenter;
import com.nicro.app.core.mvp.base.view.BaseMvpView;

/**
 * @ClassName: BaseMvpFragment
 * @Description: Mvp中Fragment的基类
 * @Author: rongwenzhao
 * @Date: 2019/7/5 11:48
 */
public abstract class BaseMvpFragment<V extends BaseMvpView, P extends BaseMvpPresenter> extends BaseFragment {

    protected P presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = initPresenter();
        presenter.attachView((V) this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    public abstract P initPresenter();

}
