package com.example.tz.tuozhe.View.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.tz.tuozhe.Activity.Dynamic.VeryHot;
import com.example.tz.tuozhe.Activity.Dynamic.VeryNew;
import com.example.tz.tuozhe.Activity.Publish.PublishActivity;
import com.example.tz.tuozhe.Common.BaseFragment;
import com.example.tz.tuozhe.R;
import com.ruffian.library.RVPIndicator;

import java.util.ArrayList;
import java.util.List;


/**
 *主页面的第二个碎片布局
 */

public class DynamicFragment extends BaseFragment implements View.OnClickListener {

    private RVPIndicator my_rvpindicator;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private ViewPager my_viewpager;
    private ImageView release_;
    private List<String> title=new ArrayList<>();
    private List<Fragment> fragments=new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic, null);

        initview(view);
        return view;
    }

    private void initview(View view) {
        my_rvpindicator=view.findViewById(R.id.my_rvpindicator);
        my_viewpager=view.findViewById(R.id.my_viewpager);
        release_=view.findViewById(R.id.release_);

        release_.setOnClickListener(this);

        setview();
    }

    private void setview() {
        title.add("最新");
        title.add("最热");
        my_rvpindicator.setTitleList(title);
        fragments.add(new VeryNew());
        fragments.add(new VeryHot());
        fragmentPagerAdapter=new FragmentPagerAdapter(getFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };
        my_viewpager.setAdapter(fragmentPagerAdapter);
        my_viewpager.setOffscreenPageLimit(1);
        my_rvpindicator.setViewPager(my_viewpager,0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.release_:
                Intent intent=new Intent(getActivity(), PublishActivity.class);
                startActivity(intent);
//                getActivity().overridePendingTransition(R.anim.in_from_right,R.anim.in_from_left);
                break;
        }
    }
}
