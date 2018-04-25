package com.example.tz.tuozhe.Register;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tz.tuozhe.Bean.Login;
import com.example.tz.tuozhe.Login.LoginActivity;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Utils.ToastUtils;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.Version;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sure;
    private EditText name_massage,mobile_number,password_number,code_number;
    private TextView get_code;
    private CheckBox hide_password;
    private ImageView return_;
    private TextView login;
    private static final int REGISTER_SUCCESS=3;
    private static final int REGISTER_LOSE=4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        initview();
    }

    private void initview() {
        sure= (Button) findViewById(R.id.sure);
        get_code= (TextView) findViewById(R.id.get_code);
        name_massage= (EditText) findViewById(R.id.name_massage);
        mobile_number= (EditText) findViewById(R.id.mobile_number);
        password_number= (EditText) findViewById(R.id.password_number);
        code_number= (EditText) findViewById(R.id.code_number);
        hide_password= (CheckBox) findViewById(R.id.hide_password);
        return_= (ImageView) findViewById(R.id.return_);
        login= (TextView) findViewById(R.id.login);

        get_code.setOnClickListener(this);
        sure.setOnClickListener(this);
        return_.setOnClickListener(this);
        login.setOnClickListener(this);
        hide_password.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
//选择状态 显示明文--设置为可见的密码
                    password_number.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                }else {
//默认状态显示密码--设置文本 要一起写才能起作用 InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD
                    password_number.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }

    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case REGISTER_SUCCESS:
                    ToastUtils.showToast(RegisterActivity.this,msg.obj.toString());
                    Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case REGISTER_LOSE:
                    ToastUtils.showToast(RegisterActivity.this,"网络错误");
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.get_code:
                getCode();
                break;
            case R.id.sure:
                getRegister();
                break;
            case R.id.return_:
                finish();
                break;
            case R.id.login:
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void getCode() {
        String name = name_massage.getText().toString();
        final String mobile =mobile_number .getText().toString();
        String password = password_number.getText().toString();
        if (name.isEmpty()||mobile.isEmpty()||password.isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "请完善信息！", Toast.LENGTH_SHORT).show();
            return;
        }
        String telRegex = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        boolean matches = mobile.matches(telRegex);
        if (!matches)
        {
            Toast.makeText(RegisterActivity.this,"请输入正确的手机号！", Toast.LENGTH_SHORT).show();
            return;
        }

        final String url=UrlUtils.SEND_CODE + "?version=" + Version.PackageName(this) + "&mobile=" + mobile ;

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, UrlUtils.SEND_CODE + "?version=" +Version.PackageName(this) + "&mobile=" + mobile, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject json=new JSONObject(s);
                    String message_data = json.getString("message");
                    Message message=new Message();
                    message.what=REGISTER_SUCCESS;
                    message.obj=message_data;
                    mHandler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                 mHandler.sendEmptyMessage(REGISTER_LOSE);
            }
        });
        requestQueue.add(stringRequest);
    }

    @SuppressLint("LongLogTag")
    private void getRegister() {
        String name = name_massage.getText().toString();
        String mobile =mobile_number .getText().toString();
        String password = password_number.getText().toString();
        String code = code_number.getText().toString();
        if (name.isEmpty()||mobile.isEmpty()||password.isEmpty()||code.isEmpty())
        {
            Toast.makeText(RegisterActivity.this, "请完善信息!", Toast.LENGTH_SHORT).show();
            return;
        }
        String telRegex = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        boolean matches = mobile.matches(telRegex);
        if (!matches)
        {
            Toast.makeText(RegisterActivity.this,"请输入正确的手机号！", Toast.LENGTH_SHORT).show();
            return;
        }
       RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        final String url=UrlUtils.REGISTER +"?version="+Version.PackageName(this)+"&type="+getIntent().getStringExtra("owner_stylist")+"&name="+name+"&mobile="+mobile+"&pwd="+password+"&code="+code+"&source=2";
              String url_=url.replace("","");
        StringRequest stringRequest=new StringRequest(Request.Method.POST,url_ , new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    JSONObject json = new JSONObject(s);
                    String message_data = json.getString("message");
                    Message message=new Message();
                    message.what=REGISTER_SUCCESS;
                    message.obj=message_data;
                    mHandler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                mHandler.sendEmptyMessage(REGISTER_LOSE);
            }
        });
        requestQueue.add(stringRequest);
    }


}
