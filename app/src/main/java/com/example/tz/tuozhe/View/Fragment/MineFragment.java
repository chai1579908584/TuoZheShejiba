package com.example.tz.tuozhe.View.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.tz.tuozhe.Activity.EditProfileActivity;
import com.example.tz.tuozhe.Activity.HomePager.OwnerActivity;
import com.example.tz.tuozhe.Activity.HomePager.StylistActivity;
import com.example.tz.tuozhe.Activity.OneselfStylistActivity;
import com.example.tz.tuozhe.Activity.SetActivity;
import com.example.tz.tuozhe.Common.BaseFragment;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.UserManager;


/**
 *主页面的第五个碎片布局
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {

    private RelativeLayout set_;
    private ImageView head_image;
    private TextView name,user_id,money;
    private SharedPreferences data;
    private TextView compile,personage;
    private String image,name_;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, null);
        initview(view);

        return view;
    }

    private void initview(View view) {
        data=getActivity().getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        image=data.getString("avatar","");
        name_=data.getString("nick_name","拓者设计吧");
        set_=view.findViewById(R.id.set_);
        head_image=view.findViewById(R.id.head_image);
        name=view.findViewById(R.id.name);
        user_id=view.findViewById(R.id.user_id);
        money=view.findViewById(R.id.money);
        compile=view.findViewById(R.id.compile);
        personage=view.findViewById(R.id.personage);

        set_.setOnClickListener(this);
        compile.setOnClickListener(this);
        personage.setOnClickListener(this);

        setData();
    }

    @SuppressLint("LongLogTag")
    private void setData() {
        GlideUtil.displayRoundImage(getActivity(),image,head_image,80);
        name.setText(name_);
        user_id.setText("ID  "+data.getString("uid","10000"));
        money.setText("金币  "+data.getString("account","0"));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.set_:
                Intent intent=new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
                break;
            case R.id.compile:
                Intent compile=new Intent(getActivity(), EditProfileActivity.class);
                startActivity(compile);
                break;
            case R.id.personage:
                if (data.getString("user_type","").equals("1"))
                {
                    Intent owner=new Intent(getActivity(), OwnerActivity.class);
                    startActivity(owner);
                }else if (data.getString("user_type","").equals("2"))
                {
                    //Intent stylist=new Intent(getActivity(), StylistActivity.class);
                    Intent stylist=new Intent(getActivity(), OneselfStylistActivity.class);
                    startActivity(stylist);
                }
                break;
        }
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onStart() {
        super.onStart();
        if (!image.equals(data.getString("avatar",""))) {
            GlideUtil.displayRoundImage(getActivity(), data.getString("avatar", ""), head_image, 80);
            image=data.getString("avatar","");
        }
        if (!name_.equals(data.getString("nick_name","拓者设计吧"))) {
            name.setText(data.getString("nick_name", "拓者设计吧"));
            name_=data.getString("nick_name","");
        }
    }
}
