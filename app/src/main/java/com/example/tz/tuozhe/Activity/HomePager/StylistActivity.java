package com.example.tz.tuozhe.Activity.HomePager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class StylistActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView return_,head_image;
    private TextView title_text,introduce,price,make_an_appointment_number,written_permission_number,evaluate_number;
    private SharedPreferences data;
    private static final int STYLISTMESSAGE=1;
    private static final int STYLISTMESSAGE_LOSE=2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylist);

        initview();
        getData();
    }
    private void initview() {
        data=getSharedPreferences("DATA", Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        return_= (ImageView) findViewById(R.id.return_);
        head_image= (ImageView) findViewById(R.id.head_image);
        title_text= (TextView) findViewById(R.id.title_text);
        introduce= (TextView) findViewById(R.id.introduce);
        price= (TextView) findViewById(R.id.price);
        make_an_appointment_number= (TextView) findViewById(R.id.make_an_appointment_number);
        written_permission_number= (TextView) findViewById(R.id.written_permission_number);
        evaluate_number= (TextView) findViewById(R.id.evaluate_number);
        return_.setOnClickListener(this);

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
                    StylistHomeBean.DataBean data = stylistHomeBean.getData();
                    StylistHomeBean.DataBean.DisplayBean display = data.getDisplay();
                    GlideUtil.displayRoundImage(getApplicationContext(),display.getAvatar(),head_image,80);
                    title_text.setText(display.getNick_name());
                    introduce.setText(display.getAddress());
                    price.setText("设计收费："+display.getCharge());
                    make_an_appointment_number.setText(display.getOrdered());
                    written_permission_number.setText(display.getBill());
                    evaluate_number.setText(display.getEvaluate());
                    break;
                case STYLISTMESSAGE_LOSE:
                    Toast.makeText(StylistActivity.this, "网络有误", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

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
