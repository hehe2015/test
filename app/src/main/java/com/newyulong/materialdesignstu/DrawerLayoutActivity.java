package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/11/3.
 */

public class DrawerLayoutActivity extends AppCompatActivity {

    private final static String TAG = "DrawerLayoutActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawerlayout);

        final DrawerLayout drawerLayout = findViewById(R.id.dl);
        drawerLayout.addDrawerListener(new MyDrawerListener());

        final NavigationView navigationView = findViewById(R.id.nav);
        navigationView.setItemIconTintList(null);

        View headerView = navigationView.getHeaderView(0);
        TextView tv_name = headerView.findViewById(R.id.tv_name);
        tv_name.setText("header");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                switch (itemId) {
                    case R.id.item1:
                        Toast.makeText(DrawerLayoutActivity.this, "item1被点击", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.item2:
                        break;
                    case R.id.item3:
                        break;
                    case R.id.item4:
                        break;
                }
                drawerLayout.closeDrawer(navigationView);//点击后关闭抽屉
                return true;
            }
        });

    }

    private class MyDrawerListener implements DrawerLayout.DrawerListener {
        public void onDrawerSlide(View drawerView, float slideOffset) {
            //当抽屉被滑动时调用 滑动幅度0-1
        }

        public void onDrawerOpened(View drawerView) {
            //抽屉完全被打开
        }

        public void onDrawerClosed(View drawerView) {
            //抽屉完全被关闭
        }

        public void onDrawerStateChanged(int newState) {
            //当抽屉状态改变时候被调用
            //状态是state:0(闲置);1(拖拽);2(固定)
        }
    }

    private class MyDrawerLayoutSimpleListener extends DrawerLayout.SimpleDrawerListener {
    }

}
