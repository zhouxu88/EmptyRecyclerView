package com.zmwl.recyclerviewemptyview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 周旭 on 2017/3/13.
 */

public class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.ViewHolder> {

    public static final String TAG = "MyRecycleViewAdapter";
    private LayoutInflater inflate;
    private List<ItemData> mList;


    public MyRecycleViewAdapter(Context context, List<ItemData> mList) {
        inflate = LayoutInflater.from(context);
        this.mList = mList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflate.inflate(R.layout.item_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //设置相关数据
        holder.mTextView.setText(mList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mList.size() == 0 ? 0 : mList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.text_tv);
        }
    }
}

