package com.taobao.toolbarwithdrawertest;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class SearchActivity extends BaseActivity
{

    private SearchView mSearchView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setStatusBarColor(toolbar);

        mSearchView = (SearchView) findViewById(R.id.search);
        //让searchview默认展开
        mSearchView.onActionViewExpanded();
        mSearchView.setFocusableInTouchMode(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SearchActivity.this.finish();
            }
        });
    }
}
