package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.newyulong.materialdesignstu.DividerItemDecoration.DividerGridItemDecoration;
import com.newyulong.materialdesignstu.DividerItemDecoration.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Administrator on 2017/11/9.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    private List<String> data = new ArrayList<String>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.ctl);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.white));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.white));

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecyclerViewActivity.this.finish();
            }
        });


        getData();

//        MyAdapter myAdapter = new MyAdapter();

        RecyclerView recyclerview = findViewById(R.id.recyclerview);
//        recyclerview.setAdapter(myAdapter);

        HomeAdapter homeAdapter = new HomeAdapter(R.layout.item_recyclerview, data);
        recyclerview.setAdapter(homeAdapter);

//        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        recyclerview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));

        recyclerview.setLayoutManager(new GridLayoutManager(this,3));
        recyclerview.addItemDecoration(new DividerGridItemDecoration(this));

        recyclerview.setItemAnimator(new DefaultItemAnimator());


    }

    public class HomeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
        public HomeAdapter(int layoutResId, List data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tv_item, item);
        }
    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(View.inflate(RecyclerViewActivity.this,R.layout.item_recyclerview,null));
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.textView.setText(data.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position % 2 == 0){
                        data.add(position+1,"add");
                    } else{
                        data.remove(position);
                    }
                    notifyDataSetChanged();
                }
            });
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder{

            TextView textView;

            public MyViewHolder(View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_item);
            }
        }

    }

    private void getData() {
        for (int i=0;i<39;i++){
            data.add("item "+i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.recyclermenu,menu);
        return true;
    }
}


