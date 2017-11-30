package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.Mac;

/**
 * Created by Administrator on 2017/11/7.
 */

public class SnackbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        final CoordinatorLayout coordinatorLayout = findViewById(R.id.cl);
        TextView tv = findViewById(R.id.tv);

        final Snackbar make = Snackbar.make(coordinatorLayout, "hello world", Snackbar.LENGTH_INDEFINITE);
        setSnackbarColor(make,getResources().getColor(R.color.black),getResources().getColor(R.color.colorAccent));
        make.setActionTextColor(getResources().getColor(R.color.blue));
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                make.setAction("你好", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(SnackbarActivity.this,"Snackbar Action被点击了",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
            }
        });
    }

    public void setSnackbarColor(Snackbar snackbar, int messageColor, int backgroundColor) {
        View view = snackbar.getView();//获取Snackbar的view
        if(view!=null){
            view.setBackgroundColor(backgroundColor);//修改view的背景色
            ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(messageColor);//获取Snackbar的message控件，修改字体颜色
        }
    }

}
