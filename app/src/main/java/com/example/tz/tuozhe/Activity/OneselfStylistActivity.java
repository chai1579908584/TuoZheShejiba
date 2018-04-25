package com.example.tz.tuozhe.Activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Bean.StylistHomeBean;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.GlideUtil;
import com.example.tz.tuozhe.Utils.MyScrollView;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.example.tz.tuozhe.View.Fragment.OneselfCaseFragment;
import com.example.tz.tuozhe.View.Fragment.Owner_Dynamic_Fragment;
import com.example.tz.tuozhe.View.Fragment.Owner_Image_Fragment;
import com.google.gson.Gson;
import com.ruffian.library.RVPIndicator;

import java.util.ArrayList;
import java.util.List;

public class OneselfStylistActivity extends AppCompatActivity implements View.OnClickListener {


    private ImageView return_,head_image;
    private TextView title_text,introduce,price,attention_number,fans_number;
    private SharedPreferences data;
    private FragmentPagerAdapter fragmentPagerAdapter;
    private RVPIndicator my_rvpindicator;
    private ViewPager my_viewpager;
    private List<Fragment> fragments=new ArrayList<>();
    private List<String> title=new ArrayList<>();
    private static final int STYLISTMESSAGE=1;
    private static final int STYLISTMESSAGE_LOSE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oneself_stylist);

        initview();

    }

    private void initview() {
        data=getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        return_= (ImageView) findViewById(R.id.return_);
        head_image= (ImageView) findViewById(R.id.head_image);
        title_text= (TextView) findViewById(R.id.title_text);
        introduce= (TextView) findViewById(R.id.introduce);
        price= (TextView) findViewById(R.id.price);
        attention_number= (TextView) findViewById(R.id.attention_number);
        fans_number= (TextView) findViewById(R.id.fans_number);
        my_rvpindicator= (RVPIndicator) findViewById(R.id.my_rvpindicator);
        my_viewpager= (ViewPager) findViewById(R.id.my_viewpager);

        //scrollview.setOnScrollListener(this);
        head_image.setOnClickListener(this);
        return_.setOnClickListener(this);

        setView();
        getData();
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case STYLISTMESSAGE:
                    Gson g=new Gson();
                    StylistHomeBean stylistHomeBean = g.fromJson(msg.obj.toString(), StylistHomeBean.class);
                    StylistHomeBean.DataBean Data = stylistHomeBean.getData();
                    StylistHomeBean.DataBean.DisplayBean display = Data.getDisplay();
                    GlideUtil.displayRoundImage(getApplicationContext(),display.getAvatar(),head_image,80);
                    title_text.setText(display.getNick_name());
                    introduce.setText(display.getAddress());
                    price.setText("设计收费："+display.getCharge());
                    attention_number.setText(data.getString("follow",""));
                    fans_number.setText(data.getString("follower",""));
                    break;
                case STYLISTMESSAGE_LOSE:
                    Toast.makeText(OneselfStylistActivity.this, "网络有误", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void setView() {
        title.add("案例");
        title.add("动态更新");
        title.add("相册");
        my_rvpindicator.setTitleList(title);

        fragments.add(new OneselfCaseFragment());
        fragments.add(new Owner_Dynamic_Fragment());
        fragments.add(new Owner_Image_Fragment());
        fragmentPagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        my_rvpindicator.setViewPager(my_viewpager,0);
        my_viewpager.setOffscreenPageLimit(2);

    }

    private void getData() {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(UrlUtils.STYLIST + "?version=" + Version.PackageName(this) + "&token=" + data.getString("token", "") + "&id=" + data.getString("uid", ""), new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.obj=s;
                message.what=STYLISTMESSAGE;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(STYLISTMESSAGE_LOSE);
            }
        });
        requestQueue.add(stringRequest);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.return_:
                finish();
                break;
        }
    }
}
