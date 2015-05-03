package com.taobao.toolbarwithdrawertest.utils;

import android.content.Context;
import android.util.Log;

public class ScreenUtils
{
    public static int getStatusBarHeight(Context context)
    {
        Context appContext = context.getApplicationContext();
        int result = 0;
        int resourceId = appContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = appContext.getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("MAIN", result + "");
        return result;
    }
}