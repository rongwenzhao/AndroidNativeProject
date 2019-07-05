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

import com.nicro.app.core.mvp.base.presenter.BaseMvpPresenter;
import com.nicro.app.core.mvp.base.view.BaseMvpView;
import com.nicro.mainapp.activities.HomeActivity;
import com.nicro.mainapp.models.HomeModel;

/**
 * @ClassName: HomePresenter
 * @Description: Home Presenter 
 * @Author: rongwenzhao
 * @Date: 2019/7/5 17:04
 */
public class HomePresenter extends BaseMvpPresenter<HomePresenter.HomeActivityView, HomeModel> {

    public void initData(){

    }

    public interface HomeActivityView extends BaseMvpView{
        void showDataListView();
    }
}
