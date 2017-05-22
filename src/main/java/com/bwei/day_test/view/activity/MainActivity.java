package com.bwei.day_test.view.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.bwei.day_test.R;
import com.bwei.day_test.moudl.Main_bean;
import com.bwei.day_test.persenter.Main_persenter;
import com.bwei.day_test.view.adapter.MyRecycleviewAdapter;
import com.bwei.day_test.view.iview.Main_interface;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, Main_interface {

    private RecyclerView recycler_view;
    private SwipeRefreshLayout swip_my;
    private Main_persenter main_persenter;
    private List<Main_bean.ResultBean.DataBean> data;
    private MyRecycleviewAdapter myRecycleviewAdapter;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();

    }

    private void initData() {


        main_persenter = new Main_persenter();
        main_persenter.setImvpview(this);
        main_persenter.getData();


         myRecycleviewAdapter = new MyRecycleviewAdapter(MainActivity.this);
         recycler_view.setAdapter(myRecycleviewAdapter);


        final LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        recycler_view.setLayoutManager(linearLayoutManager);


        //设置下拉刷新监听
        swip_my.setOnRefreshListener(this);

        //设置加载更多监听
        recycler_view.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy>0){

                    int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                    int itemCount = linearLayoutManager.getItemCount();
                    if (lastVisibleItemPosition+1==itemCount){

                        bar.setVisibility(View.VISIBLE);

                        new Thread(){
                            @Override
                            public void run() {
                                super.run();
                                try {
                                    sleep(2000);

                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            bar.setVisibility(View.GONE);
                                        }
                                    });

                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }


                            }
                        }.start();



                    }


                }


            }
        });




    }


    private void initView() {
        recycler_view = (RecyclerView) findViewById(R.id.recycler_view);
        swip_my = (SwipeRefreshLayout) findViewById(R.id.swip_my);
        bar = (ProgressBar) findViewById(R.id.my_bar);
    }


    @Override
    public void onRefresh() {

        refresh();
        swip_my.setRefreshing(false);
    }


    @Override
    public void CallBack(Main_bean main_bean) {
        data = main_bean.getResult().getData();


    }

    private void refresh() {
        if (data != null) {
           myRecycleviewAdapter.setData(data);
            myRecycleviewAdapter.notifyDataSetChanged();
        }

    }


}
