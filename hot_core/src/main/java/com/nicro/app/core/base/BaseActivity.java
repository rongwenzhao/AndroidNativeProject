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
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @ClassName: BaseActivity
 * @Description: Activity的基类，一些公共操作会在这里 
 * @Author: rongwenzhao
 * @Date: 2019/7/5 16:46
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
