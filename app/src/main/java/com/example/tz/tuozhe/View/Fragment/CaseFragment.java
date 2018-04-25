package com.example.tz.tuozhe.View.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.tz.tuozhe.Common.BaseFragment;
import com.example.tz.tuozhe.R;


/**
 *主页面的第四个碎片布局
 */

public class CaseFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout rl_yi,rl_er;
    private TextView yi,er,yiyi,erer;
    private FragmentTransaction ft;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_case, null);

        initview(view);

        return view;
    }

    private void initview(View view) {
        rl_yi=view.findViewById(R.id.rl_yi);
        rl_er=view.findViewById(R.id.rl_er);
        yi=view.findViewById(R.id.yi);
        er=view.findViewById(R.id.er);
        yiyi=view.findViewById(R.id.yiyi);
        erer=view.findViewById(R.id.erer);



        yi.setTextColor(0xffffea8e);
        yiyi.setVisibility(View.VISIBLE);
        er.setTextColor(0xff333333);
        erer.setVisibility(View.INVISIBLE);
        rl_yi.setOnClickListener(this);
        rl_er.setOnClickListener(this);
        ft=getFragmentManager().beginTransaction();
        ft.add(R.id.ll_layout, new Case_Case_Fragment());
        ft.commit();
}

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.rl_yi:
                yi.setTextColor(0xffffea8e);
                yiyi.setVisibility(View.VISIBLE);
                er.setTextColor(0xff333333);
                erer.setVisibility(View.INVISIBLE);
                ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.ll_layout,new Case_Case_Fragment());
                ft.commit();
                break;
            case R.id.rl_er:
                yi.setTextColor(0xff333333);
                yiyi.setVisibility(View.INVISIBLE);
                er.setTextColor(0xffffea8e);
                erer.setVisibility(View.VISIBLE);
                ft=getFragmentManager().beginTransaction();
                ft.replace(R.id.ll_layout,new Case_Video_Fragment());
                ft.commit();
                break;
        }
    }
}
