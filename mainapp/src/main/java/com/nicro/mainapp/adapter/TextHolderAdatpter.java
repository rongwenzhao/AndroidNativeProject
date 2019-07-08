/**
 * Copyright (C), nicro有限公司
 * FileName: TextHolderAdatpter
 * Author: rongwenzhao
 * Date: 2019/7/8 15:53
 * Description: 首页RecyclerView的TextBean对应的Adapter
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.nicro.mainapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nicro.mainapp.R;
import com.nicro.mainapp.holder.BaseRecyclerHolder;
import com.nicro.mainapp.models.TextBean;

/**
 * @ClassName: TextHolderAdatpter
 * @Description: 首页RecyclerView的TextBean对应的Adapter
 * @Author: rongwenzhao
 * @Date: 2019/7/8 15:53
 */
public class TextHolderAdatpter extends BaseRecyclerAdapter<TextBean> {

    private TextHolderClickListener mListener;

    public TextHolderAdatpter(Context context, int layoutRes) {
        super(context, layoutRes);
    }

    @Override
    public void convert(BaseRecyclerHolder holder, int position) {
        String pos_str = position + 1 < 10 ? "0" + (position + 1) : "" + (position + 1);
        ((TextView) holder.getView(R.id.text_holder_num_tv)).setText(pos_str);
        ((TextView) holder.getView(R.id.text_holder_title_tv)).setText(getItem(position).getTitle());
        ((TextView) holder.getView(R.id.text_holder_subtitle_tv)).setText(getItem(position).getSubTitle());

        if (position + 1 == getItemCount()) {
            holder.getView(R.id.text_holder_line).setVisibility(View.GONE);
        } else {
            holder.getView(R.id.text_holder_line).setVisibility(View.VISIBLE);
        }

        ((ViewGroup) holder.getView(R.id.text_holder_num_tv).getParent()).setOnClickListener(new OnTextClick(position));
    }

    private class OnTextClick implements View.OnClickListener {

        private int position;

        public OnTextClick(int position) {
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                mListener.onTextClick(position);
            }
        }
    }

    public void setTextHolderClickListener(TextHolderClickListener listener) {
        this.mListener = listener;
    }

    public interface TextHolderClickListener {
        void onTextClick(int position);
    }
}