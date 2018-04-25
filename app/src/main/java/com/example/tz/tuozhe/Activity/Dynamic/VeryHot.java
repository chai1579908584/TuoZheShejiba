package com.example.tz.tuozhe.Activity.Dynamic;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tz.tuozhe.R;

/**
 * Created by Tz on 2018/4/19.
 */
public class VeryHot extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_owner_dynamic,null);
        return view;
    }
}

