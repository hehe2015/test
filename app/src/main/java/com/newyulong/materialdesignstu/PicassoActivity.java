package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.newyulong.materialdesignstu.ViewUtils.BindUtils;
import com.newyulong.materialdesignstu.ViewUtils.BindView;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/11/17.
 */

public class PicassoActivity extends AppCompatActivity {

    @BindView(id = R.id.image)
    private ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        BindUtils.initBindView(this);

        String url = "http://www.taopic.com/uploads/allimg/140107/234764-14010F0310582.jpg";
        Picasso.with(this)
                .load(url)
                .into(image);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
