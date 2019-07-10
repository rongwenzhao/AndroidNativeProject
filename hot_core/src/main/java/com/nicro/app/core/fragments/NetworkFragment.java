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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.nicro.app.core.R;
import com.nicro.app.core.mvp.base.fragments.BaseMvpFragment;
import com.nicro.app.core.presenters.NetworkFragmentPresenter;
import com.orhanobut.logger.Logger;
import com.trello.rxlifecycle.ActivityEvent;
import com.trello.rxlifecycle.FragmentEvent;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * @ClassName: NetworkFragment
 * @Description: 网络请求的Fragment
 * @Author: rongwenzhao
 * @Date: 2019/7/5 14:13
 */
public class NetworkFragment extends BaseMvpFragment<NetworkFragmentPresenter.NetworkFragmentView, NetworkFragmentPresenter>
        implements View.OnClickListener, NetworkFragmentPresenter.NetworkFragmentView {

    TextView mTextView;
    Button mClickButton;
    String mStr;

    public static NetworkFragment newInstance(String arg) {
        final Bundle args = new Bundle();
        args.putString("something", arg);
        final NetworkFragment fragment = new NetworkFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Bundle args = getArguments();
        if (args != null) {
            mStr = args.getString("something");
            Logger.d(mStr);
        }
        /*Observable.interval(1, TimeUnit.SECONDS)
                .doOnUnsubscribe(new Action0() {
                    @Override
                    public void call() {
                        Logger.d("Unsubscribing subscription from onCreate()");
                    }
                })
                //Note:手动设置在activity onDestroy的时候取消订阅
                .compose(this.<Long>bindUntilEvent(FragmentEvent.DESTROY))
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long num) {
                        Logger.d("Started in onResume(), running until in onDestroy(): " + num);
                    }
                });*/
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_network;
    }

    @Override
    public void initViews(View view) {
        mClickButton = view.findViewById(R.id.fragment_network_get_btn);
        mTextView = view.findViewById(R.id.fragment_network_result_tv);
    }

    @Override
    public void initListeners() {
        mClickButton.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public NetworkFragmentPresenter initPresenter() {
        return new NetworkFragmentPresenter();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.fragment_network_get_btn) {
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
