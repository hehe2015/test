package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/7.
 */

public class TabLayoutActivity extends AppCompatActivity {

    private final static String TAG = "TabLayoutActivity";

    private String[] mTitleArray = {"item1", "xitem2", "xxxitem3", "xxxxitem4","xxxxxitem5"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        ViewPager vp = findViewById(R.id.vp);
        vp.setAdapter(new MyAdapter());
//		  去掉addTab(),从viewpage 的 getPageTitle()中获取
//        tabLayout.addTab(tabLayout.newTab().setText("icon").setIcon(R.mipmap.ic_launcher));
//        tabLayout.addTab(tabLayout.newTab().setText("tab1"));
//        tabLayout.addTab(tabLayout.newTab().setText("tab2"));
//        tabLayout.addTab(tabLayout.newTab().setText("tab3"));
//        tabLayout.addTab(tabLayout.newTab().setText("tab4"));
//        tabLayout.addTab(tabLayout.newTab().setText("tab5"));
//        tabLayout.addTab(tabLayout.newTab().setText("tab6"));

        tabLayout.setupWithViewPager(vp);//关联viewpager

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            public void onTabSelected(TabLayout.Tab tab) {
                //tab被选中
                Log.d(TAG,"onTabSelected: "+tab.getPosition());
            }
            public void onTabUnselected(TabLayout.Tab tab) {
                //tab取消选中
                Log.d(TAG,"onTabUnselected: "+tab.getPosition());
            }
            public void onTabReselected(TabLayout.Tab tab) {
                //tab再次被选中
                Log.d(TAG,"onTabReselected: "+tab.getPosition());
            }
        });
    }

    private class MyAdapter extends PagerAdapter {
        public int getCount() {
            return mTitleArray.length;
        }
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            TextView tv = new TextView(TabLayoutActivity.this);
            tv.setText(mTitleArray[position]);
            tv.setGravity(Gravity.CENTER);
            container.addView(tv, ViewPager.LayoutParams.MATCH_PARENT, ViewPager.LayoutParams.WRAP_CONTENT);
            return tv;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleArray[position];//title给TabLayout使用
        }
    }

}
