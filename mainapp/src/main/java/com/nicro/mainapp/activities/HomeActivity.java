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
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.github.moduth.blockcanary.BlockCanary;
import com.nicro.app.core.base.BaseMvpActivity;
import com.nicro.app.core.block.AppBlockCanaryContext;
import com.nicro.mainapp.MainApplication;
import com.nicro.mainapp.R;
import com.nicro.mainapp.adapter.TextHolderAdatpter;
import com.nicro.mainapp.models.TextBean;
import com.nicro.mainapp.presenters.HomePresenter;
import com.nicro.mainapp.utils.UIUtils;

import java.util.List;

/**
 * @ClassName: HomeActivity
 * @Description: Home Activity
 * @Author: rongwenzhao
 * @Date: 2019/7/5 16:51
 */
public class HomeActivity extends BaseMvpActivity<HomePresenter.HomeActivityView, HomePresenter>
        implements HomePresenter.HomeActivityView {

    private RecyclerView mRecyclerView;
    private TextHolderAdatpter mTextAdapter;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public void initViews() {
        mFragmentManager = getSupportFragmentManager();
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    @Override
    public void initToolbar(com.nicro.app.core.base.DefaultToolbar toolbar) {
        toolbar.setmTvTitle(R.string.title_main);
        toolbar.hideBackIcon();
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initData() {
        presenter.initData();
    }

    @Override
    protected HomePresenter initPresenter() {
        return new HomePresenter();
    }

    @Override
    public void showDataListView(List<TextBean> list) {
        mTextAdapter = new TextHolderAdatpter(this, R.layout.text_holder);

        mTextAdapter.setTextHolderClickListener(new TextHolderAdatpter.TextHolderClickListener() {
            @Override
            public void onTextClick(int position) {
                presenter.onItemClick(position);
            }
        });
        mTextAdapter.setData(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mTextAdapter);
    }

    @Override
    public void showIntentedFragment(Fragment fragment) {
        mFragmentManager.beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

    @Override
    public void onBackPressed() {
        if (!UIUtils.isDoubleClick(2000)) {
            Toast.makeText(this,"双击退出",Toast.LENGTH_SHORT).show();
            //ToastUtil.showInfo("双击退出");
            return;
        }
        super.onBackPressed();
    }
}
