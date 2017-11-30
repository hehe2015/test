package com.newyulong.materialdesignstu.behavior;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/8.
 */

public class MyBehavior extends CoordinatorLayout.Behavior<TextView> {

    public MyBehavior(Context context, AttributeSet attrs) {//必不可少
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX());//此处的denpendency就是btn1
        child.setY(dependency.getY()+200);
        return true;
    }
}
