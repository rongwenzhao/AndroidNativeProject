/**
 * Copyright (C), nicro有限公司
 * FileName: HomeActivity
 * Author: rongwenzhao
 * Date: 2019/7/5 16:51
 * Description: Home Activity
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nicro.app.core.base.BaseMvpActivity;
import com.nicro.app.core.mvp.base.presenter.BaseMvpPresenter;
import com.nicro.mainapp.R;
import com.nicro.mainapp.presenters.HomePresenter;

/**
 * @ClassName: HomeActivity
 * @Description: Home Activity 
 * @Author: rongwenzhao
 * @Date: 2019/7/5 16:51
 */
public class HomeActivity extends BaseMvpActivity implements HomePresenter.HomeActivityView {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    protected BaseMvpPresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showDataListView() {

    }
}
