/**
 * Copyright (C), nicro有限公司
 * FileName: BaseActivity
 * Author: rongwenzhao
 * Date: 2019/7/5 16:46
 * Description: Activity的基类，一些公共操作会在这里
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 * @ClassName: BaseActivity
 * @Description: Activity的基类，一些公共操作会在这里
 * @Author: rongwenzhao
 * @Date: 2019/7/5 16:46
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(getLayoutId());
        initViews();
        DefaultToolbar toolbar = new DefaultToolbar(this);
        initToolbar(toolbar);
        initData();
        initListeners();
    }

    public abstract @LayoutRes
    int getLayoutId();

    public abstract void initViews();

    public abstract void initToolbar(DefaultToolbar toolbar);

    public abstract void initListeners();

    public abstract void initData();

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
