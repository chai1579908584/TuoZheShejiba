package com.example.tz.tuozhe.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tz.tuozhe.Common.BaseFragment;
import com.example.tz.tuozhe.R;


/**
 *主页面的第三个碎片布局
 */

public class StylistFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stylist, null);
        return view;
    }
}
