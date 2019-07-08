/**
 * Copyright (C), nicro有限公司
 * FileName: DefaultToolbar
 * Author: rongwenzhao
 * Date: 2019/7/8 10:38
 * Description: 公共工具欄描述類
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.app.core.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nicro.app.core.R;

/**
 * @ClassName: DefaultToolbar
 * @Description: 公共工具欄描述類
 * @Author: rongwenzhao
 * @Date: 2019/7/8 10:38
 */
public class DefaultToolbar implements View.OnClickListener {

    private BaseActivity mActivity;
    private TextView mTvTitle;
    private ImageView mIvBack;
    private TextView mTvRightText;
    private ImageView mIvRightIcon;

    public DefaultToolbar(BaseActivity activity) {
        mActivity = activity;
        mTvTitle = activity.findViewById(R.id.default_toolbar_title);
        mIvBack = activity.findViewById(R.id.default_toolbar_back);
        mTvRightText = activity.findViewById(R.id.default_toolbar_right_text);
        mIvRightIcon = activity.findViewById(R.id.default_toolbar_right_icon);

        mIvBack.setOnClickListener(this);
    }

    public void setmTvTitle(CharSequence mTvTitle) {
        this.mTvTitle.setText(mTvTitle);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  R.id.default_toolbar_back){
            mActivity.onBackPressed();
        }
    }

    public void hideBackIcon() {
        mIvBack.setVisibility(View.GONE);
    }

    public void showRightIcon(View.OnClickListener listener) {
        mIvRightIcon.setOnClickListener(listener);
        mIvRightIcon.setVisibility(View.VISIBLE);
        mTvRightText.setVisibility(View.GONE);
    }

    public void showRightText(String text, View.OnClickListener listener) {
        mIvRightIcon.setVisibility(View.GONE);
        mTvRightText.setText(text);
        mTvRightText.setOnClickListener(listener);
        mTvRightText.setVisibility(View.VISIBLE);
    }
}