/**
 * Copyright (C), nicro有限公司
 * FileName: BaseFragment
 * Author: rongwenzhao
 * Date: 2019/7/5 11:41
 * Description: 通用Fragment基类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.mvp.base.fragments;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @ClassName: BaseFragment
 * @Description: 通用Fragment基类
 * @Author: rongwenzhao
 * @Date: 2019/7/5 11:41
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayoutId(), container, false);
        initViews(rootView);
        initData();
        initListeners();
        return rootView;
    }

    public abstract @LayoutRes int getLayoutId();

    public abstract void initViews(View view);

    public abstract void initListeners();

    public abstract void initData();

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
