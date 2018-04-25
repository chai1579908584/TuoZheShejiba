package com.example.tz.tuozhe.View.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.tz.tuozhe.Common.BaseFragment;
import com.example.tz.tuozhe.Login.LoginActivity;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.OtherUtils;
import com.example.tz.tuozhe.Utils.SharedUtils;
import com.example.tz.tuozhe.View.HomeActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * 引导页的 Fragment 布局
 * 通过构造方法传递一个 int 类型的值
 * 根据该 int 值展示相应的图片
 * 当 int 值等于图片数组的长度减一时，添加代码逻辑跳转到 HomeActivity
 */

@SuppressLint("ValidFragment")
public class GuideFragment extends BaseFragment implements View.OnClickListener {

    ImageView ivGuide;
    private int i;
    private ArrayList<String> pics;

    public GuideFragment(ArrayList<String> pics, int i) {
        this.pics = pics;
        this.i = i;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, null);
        ivGuide= (ImageView) view.findViewById(R.id.ivGuide);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (pics == null) {//设置本地图片
            ivGuide.setImageResource(OtherUtils.GUIDE_PICS[i]);
            if (i == OtherUtils.GUIDE_PICS.length - 1) {
                ivGuide.setOnClickListener(this);
            }
        } else {//设置网络图片
            Picasso.with(getActivity()).load(pics.get(i)).into(ivGuide);
            if (i == pics.size() - 1) {
                ivGuide.setOnClickListener(this);
            }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    //点击方法  点击最后一张图片跳转到主页面并销毁当前的Activity
    @Override
    public void onClick(View v) {
        SharedUtils.setAppNumbaer(getActivity(), 1);//设置 APP 的打开次数为1 避免再次打开 APP 时，加载页再次跳转到引导页面
        getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }
}
