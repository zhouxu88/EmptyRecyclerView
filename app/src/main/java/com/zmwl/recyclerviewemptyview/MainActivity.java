package com.zmwl.recyclerviewemptyview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EmptyRecyclerView mRecyclerView;
    private MyRecycleViewAdapter mAdapter;
    private View mEmptyView;
    private List<ItemData> mList; //数据源

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
        initRv();
    }

    private void initView() {
        mRecyclerView = (EmptyRecyclerView) findViewById(R.id.emptyRecyclerView);
        mEmptyView = findViewById(R.id.empty_iv);
        findViewById(R.id.deleteAll_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //删除所有数据
                mList.clear();
                mAdapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.insert_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //添加10条数据
                for (int i = 0; i < 10; i++) {
                    ItemData itemData = new ItemData("列表" + i);
                    mList.add(itemData);
                }
                mAdapter.notifyDataSetChanged();
            }
        });
    }

    //插入数据
    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ItemData itemData = new ItemData("列表" + i);
            mList.add(itemData);
        }
    }

    private void initRv() {
        mAdapter = new MyRecycleViewAdapter(this, mList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setEmptyView(mEmptyView); //设置空布局
    }
}
