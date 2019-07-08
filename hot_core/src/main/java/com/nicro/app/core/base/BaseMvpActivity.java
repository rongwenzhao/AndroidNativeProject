/**
 * Copyright (C), nicro有限公司
 * FileName: BaseMvpActivity
 * Author: rongwenzhao
 * Date: 2019/7/5 17:48
 * Description: Mvp的Activity基类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nicro.app.core.mvp.base.presenter.BaseMvpPresenter;
import com.nicro.app.core.mvp.base.view.BaseMvpView;

/**
 * @ClassName: BaseMvpActivity
 * @Description: Mvp的Activity基类
 * @Author: rongwenzhao
 * @Date: 2019/7/5 17:48
 */
public abstract class BaseMvpActivity<V extends BaseMvpView, P extends BaseMvpPresenter> extends BaseActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        presenter = initPresenter();
        presenter.attachView((V) this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    protected abstract P initPresenter();
}
