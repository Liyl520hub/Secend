package com.bwei.day_test.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwei.day_test.R;
import com.bwei.day_test.moudl.Main_bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：李亚雷
 * 时间：2017/5/19
 * 类用途：
 * 思路：
 */

public class MyRecycleviewAdapter extends RecyclerView.Adapter<MyRecycleviewAdapter.MyHoloder> {


    private ArrayList<Main_bean.ResultBean.DataBean> datas = new ArrayList<>();
    private Context mcontext;
    private MyHoloder myHoloder;


    public MyRecycleviewAdapter(Context mcontext) {
        this.mcontext = mcontext;
    }
    public void setData(List<Main_bean.ResultBean.DataBean> data) {


        if (data != null) {
            datas.addAll(data);
        }

    }

    @Override
    public MyHoloder onCreateViewHolder(ViewGroup parent, int viewType) {

        View inflate1 = LayoutInflater.from(mcontext).inflate(R.layout.recycleview_item, null);
       // View inflate = View.inflate(mcontext, R.layout.recycleview_item, null);

        myHoloder = new MyHoloder(inflate1);

        return myHoloder;
    }

    @Override
    public void onBindViewHolder(MyHoloder holder, int position) {
        holder.textview_my.setText(datas.get(position).getTitle());
    }

    @Override
    public int getItemCount() {

        return datas.size();
    }



    class MyHoloder extends RecyclerView.ViewHolder {


        private final ImageView imagview_my;
        private final TextView textview_my;

        public MyHoloder(View itemView) {
            super(itemView);
            imagview_my = (ImageView) itemView.findViewById(R.id.my_imagview);
            textview_my = (TextView) itemView.findViewById(R.id.my_text);


        }


    }

}