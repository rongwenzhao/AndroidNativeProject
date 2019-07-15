/**
 * Copyright (C), nicro有限公司
 * FileName: NavigationFragment
 * Author: rongwenzhao
 * Date: 2019/7/8 9:29
 * Description: DrawerLayout抽屉布局左侧导航Fragment
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.fragments;

import android.view.View;
import android.widget.TextView;

import com.nicro.app.core.mvp.base.fragments.BaseFragment;
import com.nicro.mainapp.R;
import com.nicro.mainapp.test.TimeCount;

/**
 * @ClassName: NavigationFragment
 * @Description: DrawerLayout抽屉布局左侧导航Fragment
 * @Author: rongwenzhao
 * @Date: 2019/7/8 9:29
 */
public class NavigationFragment extends BaseFragment implements View.OnClickListener {

    private TextView tv_getNewVersion;
    private TextView tv_problem;
    TimeCount timeCount;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_navigation;
    }

    @Override
    public void initViews(View view) {
        tv_getNewVersion = view.findViewById(R.id.tv_get_new_version);
        tv_problem = view.findViewById(R.id.tv_problem);
    }

    @Override
    public void initListeners() {
        tv_getNewVersion.setOnClickListener(this);
        timeCount = new TimeCount(60000, 1000, tv_getNewVersion);
        tv_problem.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_get_new_version:
                timeCount.start();
                break;
            case R.id.tv_problem:
                timeCount.cancel();
                timeCount.onFinish();
                break;
        }
    }
}