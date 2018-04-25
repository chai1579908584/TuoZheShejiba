package com.example.tz.tuozhe.Activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Bean.Loginout;
import com.example.tz.tuozhe.Login.LoginActivity;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.UserManager;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;

public class SetActivity extends AppCompatActivity implements View.OnClickListener {


    private Button logout;
    private ImageView return_;
    private SharedPreferences data;
    private  View view;
    private static final int LOGINOUT=1;
    private static final int LOGINOUT_LOSE=2;

    private String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
         view=View.inflate(this,R.layout.type_dialog,null);
        initview();

    }

    private void initview() {
        data=getSharedPreferences("DATA",Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        logout= (Button) findViewById(R.id.logout);
        return_= (ImageView) findViewById(R.id.return_);

        logout.setOnClickListener(this);
        return_.setOnClickListener(this);
    }

    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case LOGINOUT:
                    Gson g=new Gson();
                    Loginout loginout = g.fromJson(msg.obj.toString(), Loginout.class);
                    String code = loginout.getCode();
                    if (code.equals("1"))
                    {
                        UserManager user=new UserManager(getApplicationContext());
                        user.setData("10002","1","1","1","1","1","1","0","1","1","0","0","0");
                        Toast.makeText(SetActivity.this, loginout.getMessage(), Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(SetActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(SetActivity.this,loginout.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                    break;
                case LOGINOUT_LOSE:
                    Toast.makeText(SetActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

public void Loginout(){
    token= data.getString("token", "");
    if (token.equals(""))
    {
        return;
    }
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    StringRequest stringRequest=new StringRequest(UrlUtils.LOGINOUT + "?token=" + token + "&version=" + Version.PackageName(this), new Response.Listener<String>() {
        @Override
        public void onResponse(String s) {
            Message message=new Message();
            message.obj=s;
            message.what=LOGINOUT;
            mHandler.sendMessage(message);

        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError volleyError) {
          mHandler.sendEmptyMessage(LOGINOUT_LOSE);
        }
    });
    requestQueue.add(stringRequest);
}

    public void Dialog(){
        LayoutInflater layout=LayoutInflater.from(this);
        View inflate = layout.inflate(R.layout.type_dialog, null);
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setView(inflate);
        final AlertDialog alertDialog = dialog.create();
        alertDialog.show();
        inflate.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        inflate.findViewById(R.id.sure).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                Loginout();
            }
        });
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.logout:
                Dialog();
                break;
            case R.id.return_:
                finish();
                break;

        }


    }

}
