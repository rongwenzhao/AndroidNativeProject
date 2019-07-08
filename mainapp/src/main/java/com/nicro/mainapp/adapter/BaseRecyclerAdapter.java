/**
 * Copyright (C), nicro有限公司
 * FileName: BaseRecyclerAdapter
 * Author: rongwenzhao
 * Date: 2019/7/8 15:35
 * Description: BaseRecyclerViewAdapter类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nicro.mainapp.holder.BaseRecyclerHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: BaseRecyclerAdapter
 * @Description: BaseRecyclerViewAdapter类
 * @Author: rongwenzhao
 * @Date: 2019/7/8 15:35
 */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<BaseRecyclerHolder> {
    public Context context;
    public int layoutRes;
    public List<T> items;

    public BaseRecyclerAdapter(Context context, @LayoutRes int layoutRes) {
        this.context = context;
        this.layoutRes = layoutRes;
        items = new ArrayList<T>();
    }

    public BaseRecyclerAdapter(Context context, @LayoutRes int layoutResId, @Nullable List<T> data) {
        this.context = context;
        this.items = data == null ? new ArrayList<T>() : data;
        if (layoutResId != 0) {
            this.layoutRes = layoutResId;
        }
    }

    @Override
    public BaseRecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new BaseRecyclerHolder(LayoutInflater.from(context).inflate(layoutRes, null));
    }

    @Override
    public void onBindViewHolder(BaseRecyclerHolder holder, int position) {
        convert(holder, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public T getItem(int pos) {
        if (pos < 0 || pos >= items.size()) {
            return null;
        }
        return items.get(pos);
    }

    public void setData(List<T> items) {
        this.items = items == null ? new ArrayList<T>() : items;
        notifyDataSetChanged();
    }

    public void addData(@IntRange(from = 0) int position, @NonNull T data) {
        items.add(position, data);
        notifyItemInserted(position);
        compatibilityDataSizeChanged(1);
    }

    public void addData(@NonNull T data) {
        items.add(data);
        notifyItemInserted(items.size());
    }


    public void remove(int position) {
        items.remove(position);
        int internalPosition = position;
        notifyItemRemoved(internalPosition);
        notifyItemRangeChanged(internalPosition, items.size() - internalPosition);
    }

    private void compatibilityDataSizeChanged(int size) {
        final int dataSize = items == null ? 0 : items.size();
        if (dataSize == size) {
            notifyDataSetChanged();
        }
    }

    /**
     * 在onBindViewHolder调用，需要我们自定义实现的方法
     *
     * @param holder
     * @param position
     */
    public abstract void convert(BaseRecyclerHolder holder, int position);
}