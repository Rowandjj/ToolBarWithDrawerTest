package com.taobao.toolbarwithdrawertest.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taobao.toolbarwithdrawertest.R;

/**
 * A simple {@link android.app.Fragment} subclass.
 */
public class Fragment2 extends Fragment
{


    public Fragment2()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment2, container, false);
    }


}
