package com.example.tz.tuozhe.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tz on 2018/4/4.
 */
public class MyAdapter extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> title;
    public MyAdapter(FragmentManager fm,List<Fragment> fragment,List<String> title) {
        super(fm);
        list=fragment;
        this.title=title;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }
}

