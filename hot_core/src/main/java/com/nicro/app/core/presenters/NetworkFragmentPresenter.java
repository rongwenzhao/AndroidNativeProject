/**
 * Copyright (C), nicro有限公司
 * FileName: NetworkFragmentPresenter
 * Author: rongwenzhao
 * Date: 2019/7/5 13:00
 * Description: Network的V，P接口所在
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.presenters;

import com.nicro.app.core.models.NetworkModel;
import com.nicro.app.core.mvp.base.presenter.BaseMvpPresenter;
import com.nicro.app.core.mvp.base.view.BaseMvpView;

/**
 * @ClassName: NetworkFragmentPresenter
 * @Description: Network的V，P接口所在
 * @Author: rongwenzhao
 * @Date: 2019/7/5 13:00
 */
public class NetworkFragmentPresenter extends BaseMvpPresenter<NetworkFragmentPresenter.NetworkFragmentView, NetworkModel> {

    public void requestNet(String param) {
        //进行网络请求耗時操作

        //结束后调用view的回调方法
        view.requestSuccess("");
    }

    public interface NetworkFragmentView extends BaseMvpView {
        void requestSuccess(Object obj);

        void requestFailed(String msg);
    }
}
