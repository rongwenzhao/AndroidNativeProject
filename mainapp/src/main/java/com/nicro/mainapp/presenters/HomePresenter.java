/**
 * Copyright (C), nicro有限公司
 * FileName: HomePresenter
 * Author: rongwenzhao
 * Date: 2019/7/5 17:04
 * Description: Home Presenter
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.presenters;


import android.support.v4.app.Fragment;

import com.nicro.app.core.fragments.NetworkFragment;
import com.nicro.app.core.mvp.base.presenter.BaseMvpPresenter;
import com.nicro.app.core.mvp.base.view.BaseMvpView;
import com.nicro.mainapp.AppConstants;
import com.nicro.mainapp.models.HomeModel;
import com.nicro.mainapp.models.TextBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: HomePresenter
 * @Description: Home Presenter
 * @Author: rongwenzhao
 * @Date: 2019/7/5 17:04
 */
public class HomePresenter extends BaseMvpPresenter<HomePresenter.HomeActivityView, HomeModel> {
    private List<TextBean> mBeanList = new ArrayList<>();

    public void initData() {
        mBeanList.add(new TextBean("第一个", "第一个Demo", AppConstants.FIRST_LABLE));
        mBeanList.add(new TextBean("网络相关", "网络相关 Demo", AppConstants.NET_LABLE));
        view.showDataListView(mBeanList);
    }

    public void onItemClick(int postion) {
        view.showIntentedFragment(NetworkFragment.newInstance("args_args"));
    }

    public interface HomeActivityView extends BaseMvpView {
        void showDataListView(List<TextBean> list);

        void showIntentedFragment(Fragment fragment);
    }
}
