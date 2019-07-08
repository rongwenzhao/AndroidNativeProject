/**
 * Copyright (C), nicro有限公司
 * FileName: BaseRecyclerHolder
 * Author: rongwenzhao
 * Date: 2019/7/8 15:32
 * Description: BaseRecyclerViewHolder类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.holder;

import android.support.annotation.IdRes;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @ClassName: BaseRecyclerHolder
 * @Description: BaseRecyclerViewHolder类
 * @Author: rongwenzhao
 * @Date: 2019/7/8 15:32
 */
public class BaseRecyclerHolder extends RecyclerView.ViewHolder {
    private SparseArrayCompat<View> mViews;
    public BaseRecyclerHolder(View itemView) {
        super(itemView);
        mViews = new SparseArrayCompat<>();
    }
    public <V extends View> V getView(@IdRes int res){
        View v = mViews.get(res);
        if (v == null){
            v = itemView.findViewById(res);
            mViews.put(res,v);
        }
        return (V)v;
    }
}