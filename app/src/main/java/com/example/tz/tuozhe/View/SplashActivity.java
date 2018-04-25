package com.example.tz.tuozhe.View;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Bean.Banner_shouye;
import com.example.tz.tuozhe.Bean.Login;
import com.example.tz.tuozhe.Common.BaseActivity;
import com.example.tz.tuozhe.Login.LoginActivity;
import com.example.tz.tuozhe.Model.BannerData;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.OtherUtils;
import com.example.tz.tuozhe.Utils.SharedUtils;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;



/*
* 加载页面，APP 执行的第一个页面
* 加载一些 APP 所需的资源文件
* 判断是否为第一次打开，第一次执行 APP 跳转引导页（GuideActivity），不是第一次跳转到主页面（HomeActivity）
* */

public class SplashActivity extends BaseActivity {

    //ImageView ivSplash;

    private SharedPreferences data;
    private String token;
    private int i = OtherUtils.SPLASH_TIME;//加载页显示的时间 单位s
    private String  state;
    private String lose="10002";

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (i == 0) {
                //判断第几次执行 APP 跳转相应的Activity
               // int appNumbaer = SharedUtils.getAppNumbaer(SplashActivity.this);
                if (state.equals("0")) {
                    //startActivity(GuideActivity.class, true);
                    startActivity(LoginActivity.class, true);
                } else {
                    startActivity(HomeActivity.class, true);
                }
            } else {
                handler.sendMessageDelayed(Message.obtain(), 2000);
            }
            i--;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        data=getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        state=data.getString("state","0");
        //ivSplash= (ImageView) findViewById(R.id.ivSplash);
        //ivSplash.setImageResource(OtherUtils.SPLASH_PIC);//设置加载页的加载图片
        setWidthAndHeight();//方法  SharedPreferences 存储屏幕的宽度和高度
       //开启 Handler 控制跳转时间
        handler.sendMessageDelayed(Message.obtain(), 0);
    }

    //方法  SharedPreferences 存储屏幕的宽度和高度
    private void setWidthAndHeight() {
        SharedUtils.setDeviceWidth(this, getWindowManager().getDefaultDisplay().getWidth());
        SharedUtils.setDeviceHeight(this, getWindowManager().getDefaultDisplay().getHeight());
    }

    //屏蔽返回键
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {//当keyCode值等于返回键（KEYCODE_BACK）值时
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler = null;
    }



}
