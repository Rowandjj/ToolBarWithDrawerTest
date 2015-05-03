package com.taobao.toolbarwithdrawertest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.astuetz.PagerSlidingTabStrip;
import com.taobao.toolbarwithdrawertest.fragments.Fragment1;
import com.taobao.toolbarwithdrawertest.fragments.Fragment2;
import com.taobao.toolbarwithdrawertest.fragments.Fragment3;

import java.util.ArrayList;
import java.util.List;

import static com.taobao.toolbarwithdrawertest.R.id.app_bar;


public class MainActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener
{
    private Toolbar mToolBar;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private ViewPager mViewPager;
    private PagerSlidingTabStrip mTabs;

    private List<Fragment> fragments = new ArrayList<>();
    private static final String[] TITLE = {"卡片1","卡片2","卡片3"};
    private static final int[] BACKGROUND = {0xFF4876FF,0xffcddc39,0xffff5722};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolBar = (Toolbar) findViewById(app_bar);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
        mViewPager = (ViewPager) findViewById(R.id.vpager);
        mTabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);

        //自定义标题，会覆盖xml中定义的标题
//        mToolBar.setTitle("知乎");
        //将ToolBar当做ActionBar使用
        setSupportActionBar(mToolBar);

        //初始化toggle,注意toggle要用v7包的
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer,mToolBar,R.string.drawer_open,R.string.drawer_close)
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
                getSupportActionBar().setTitle("知乎");
            }

            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
                getSupportActionBar().setTitle("设置");
            }
        };
        mDrawerToggle.syncState();
        //设置toogle
        mDrawer.setDrawerListener(mDrawerToggle);

        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager())
        {
            @Override
            public Fragment getItem(int position)
            {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position)
            {
                return TITLE[position];
            }

            @Override
            public int getCount()
            {
                return fragments.size();
            }
        });

        mTabs.setViewPager(mViewPager);
        mTabs.setOnPageChangeListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.action_search:
                startActivity(new Intent(this,SearchActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {
    }

    @Override
    public void onPageSelected(int position)
    {
        mTabs.setBackgroundColor(BACKGROUND[position]);
        mToolBar.setBackgroundColor(BACKGROUND[position]);
    }

    @Override
    public void onPageScrollStateChanged(int state)
    {
    }
}
