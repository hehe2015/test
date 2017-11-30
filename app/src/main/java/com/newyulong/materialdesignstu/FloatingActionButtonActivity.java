package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/7.
 */

public class FloatingActionButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floatingactionbutton);
        final TextView tv = findViewById(R.id.tv);
        final FloatingActionButton fab = findViewById(R.id.fab);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (fab.isShown()){
//                    fab.setVisibility(View.GONE);
//                } else
//                    fab.setVisibility(View.VISIBLE);
                Snackbar.make(tv,"hello",Snackbar.LENGTH_LONG).show();
            }
        });

    }
}
