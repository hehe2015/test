package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/15.
 */

public class ViewAndAppbarLayout extends AppCompatActivity {

    private List<String> data = new ArrayList<String>();

    private String[] content = {"AAA","BBB","CCC"};
    private List<View> views;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewandappbarlayout);

        getData();

        ViewPager vp = findViewById(R.id.vp);
        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(vp);


        View view1 = View.inflate(this, R.layout.layout1, null);
        ListView recyclerview = view1.findViewById(R.id.recyclerview);

        recyclerview.setAdapter(new MyListViewAdapter(data));
//        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        recyclerview.setAdapter(new MyRecycAdapter(data));


        View view2 = View.inflate(this, R.layout.layout2, null);
        View view3 = View.inflate(this, R.layout.layout3, null);
        views = new ArrayList<>();
        views.add(view1);
        views.add(view2);
        views.add(view3);

        vp.setAdapter(new MyAdapter());

    }

    private class MyListViewAdapter extends BaseAdapter{
        private List<String> data;
        public MyListViewAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = View.inflate(ViewAndAppbarLayout.this, R.layout.item_recyclerview, null);
            TextView viewById = inflate.findViewById(R.id.tv_item);
            viewById.setText(data.get(position));

            return inflate;
        }
    }

    private class MyRecycAdapter extends RecyclerView.Adapter<MyRecycAdapter.MyHolder>{

        private List<String> data;
        public MyRecycAdapter(List<String> data) {
            this.data = data;
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(View.inflate(ViewAndAppbarLayout.this,R.layout.item_recyclerview,null));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        public class MyHolder extends RecyclerView.ViewHolder{

            TextView tv;
            public MyHolder(View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.tv_item);
            }
        }

    }

    private class MyAdapter extends PagerAdapter{

        @Override
        public CharSequence getPageTitle(int position) {
            return content[position];
        }

        @Override
        public int getCount() {
            return content.length;
        }
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

    private void getData() {
        for (int i=0;i<20;i++){
            data.add("item "+i);
        }
    }

}
