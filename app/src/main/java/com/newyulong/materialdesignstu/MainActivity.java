package com.newyulong.materialdesignstu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        TextView tv_textinputlayout = findViewById(R.id.tv_textinputlayout);
        TextView tv_drawerlayout = findViewById(R.id.tv_drawerlayout);
        TextView tv_toolbar = findViewById(R.id.tv_toolbar);
        TextView tv_snackbar = findViewById(R.id.tv_snackbar);
        TextView tv_fab = findViewById(R.id.tv_fab);
        TextView tv_tablayout = findViewById(R.id.tv_tablayout);
        TextView tv_coordinatorlayout = findViewById(R.id.tv_coordinatorlayout);
        TextView tv_appbarlayout = findViewById(R.id.tv_appbarlayout);
        TextView tv_collapsingtoolbarlayout = findViewById(R.id.tv_collapsingtoolbarlayout);
        TextView tv_recyclerview = findViewById(R.id.tv_recyclerview);
        TextView tv_viewandappbarlayout = findViewById(R.id.tv_viewandappbarlayout);
        TextView tv_picasso = findViewById(R.id.tv_picasso);
        TextView tv_rxjava = findViewById(R.id.tv_rxjava);
        TextView tv_retrofit = findViewById(R.id.tv_retrofit);

        tv_textinputlayout.setOnClickListener(this);
        tv_drawerlayout.setOnClickListener(this);
        tv_toolbar.setOnClickListener(this);
        tv_snackbar.setOnClickListener(this);
        tv_fab.setOnClickListener(this);
        tv_tablayout.setOnClickListener(this);
        tv_coordinatorlayout.setOnClickListener(this);
        tv_appbarlayout.setOnClickListener(this);
        tv_collapsingtoolbarlayout.setOnClickListener(this);
        tv_recyclerview.setOnClickListener(this);
        tv_viewandappbarlayout.setOnClickListener(this);
        tv_picasso.setOnClickListener(this);
        tv_rxjava.setOnClickListener(this);
        tv_retrofit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_textinputlayout:
                startActivity(new Intent(MainActivity.this,TextInputLayoutActivity.class));
                break;
            case R.id.tv_drawerlayout:
                startActivity(new Intent(MainActivity.this,DrawerLayoutActivity.class));
                break;
            case R.id.tv_toolbar:
                startActivity(new Intent(MainActivity.this,ToolBarActivity.class));
                break;
            case R.id.tv_snackbar:
                startActivity(new Intent(MainActivity.this,SnackbarActivity.class));
                break;
            case R.id.tv_fab:
                startActivity(new Intent(MainActivity.this,FloatingActionButtonActivity.class));
                break;
            case R.id.tv_tablayout:
                startActivity(new Intent(MainActivity.this,TabLayoutActivity.class));
                break;
            case R.id.tv_coordinatorlayout:
                startActivity(new Intent(MainActivity.this,CoordinatorLayoutActivity.class));
                break;
            case R.id.tv_appbarlayout:
                startActivity(new Intent(MainActivity.this,AppBarLayoutActivity.class));
                break;
            case R.id.tv_collapsingtoolbarlayout:
                startActivity(new Intent(MainActivity.this,CollapsingToolbarLayoutActivity.class));
                break;
            case R.id.tv_recyclerview:
                startActivity(new Intent(MainActivity.this,RecyclerViewActivity.class));
                break;
            case R.id.tv_viewandappbarlayout:
                startActivity(new Intent(MainActivity.this,ViewAndAppbarLayout.class));
                break;
            case R.id.tv_picasso:
                startActivity(new Intent(MainActivity.this,PicassoActivity.class));
                break;
            case R.id.tv_rxjava:
                startActivity(new Intent(MainActivity.this,RxJavaActivity.class));
                break;
            case R.id.tv_retrofit:
                startActivity(new Intent(MainActivity.this,RetrofitActivity.class));
                break;
        }
    }
}
