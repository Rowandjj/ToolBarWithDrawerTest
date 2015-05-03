package com.taobao.toolbarwithdrawertest;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.taobao.toolbarwithdrawertest.utils.ScreenUtils;


public class BaseActivity extends ActionBarActivity
{
    protected void setStatusBarColor(Toolbar mToolbar)
    {
        ColorDrawable colorDrawable = (ColorDrawable) mToolbar.getBackground();
        Window w = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            w.setStatusBarColor(colorDrawable.getColor());
        }
        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT)
        {
            w.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int statusBarHeight = ScreenUtils.getStatusBarHeight(this);
            mToolbar.setPadding(0, statusBarHeight, 0, 0);
        }
    }

}
