/**
 * Copyright (C), nicro有限公司
 * FileName: NetworkFragment
 * Author: rongwenzhao
 * Date: 2019/7/5 14:13
 * Description: 网络请求的Fragment
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nicro.app.core.R;
import com.nicro.app.core.mvp.base.fragments.BaseMvpFragment;
import com.nicro.app.core.presenters.NetworkFragmentPresenter;

/**
 * @ClassName: NetworkFragment
 * @Description: 网络请求的Fragment
 * @Author: rongwenzhao
 * @Date: 2019/7/5 14:13
 */
public class NetworkFragment extends BaseMvpFragment<NetworkFragmentPresenter.NetworkFragmentView, NetworkFragmentPresenter>
        implements NetworkFragmentPresenter.NetworkFragmentView, View.OnClickListener {

    TextView mTextView;
    Button mClickButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_network, container, false);
        mClickButton = rootView.findViewById(R.id.fragment_network_get_btn);
        mClickButton.setOnClickListener(this);
        mTextView = rootView.findViewById(R.id.fragment_network_result_tv);
        return rootView;
    }

    @Override
    public NetworkFragmentPresenter initPresenter() {
        return new NetworkFragmentPresenter();
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.fragment_network_get_btn){
            presenter.requestNet("");
        }
    }

    @Override
    public void requestSuccess(Object obj) {

    }

    @Override
    public void requestFailed(String msg) {

    }
}
