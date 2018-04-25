package com.example.tz.tuozhe.Login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
import com.example.tz.tuozhe.Bean.UserInfoModel;
import com.example.tz.tuozhe.R;
import com.example.tz.tuozhe.Register.RegisterActivity_Select;
import com.example.tz.tuozhe.Utils.Consts;
import com.example.tz.tuozhe.Utils.TextUtils;
import com.example.tz.tuozhe.Utils.ToastUtils;
import com.example.tz.tuozhe.Utils.UrlUtils;
import com.example.tz.tuozhe.Utils.UserManager;
import com.example.tz.tuozhe.Utils.Version;
import com.example.tz.tuozhe.View.HomeActivity;
import com.google.gson.Gson;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.auth.sso.SsoHandler;
import com.sina.weibo.sdk.exception.WeiboException;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sure;
    private EditText user_box,password_box;
    private TextView register;
    private ImageView iv_login_qq,iv_login_weibo,iv_login_weixin;
    public static final int LOGIN_SUCCEED=1;
    public static final int LOGIN_LOSE=2;
    public static final int OTHER_SUCCESS=3;
    public static final int OTHER_LOSE=4;
    //QQ授权
    private Tencent mTencent;
    //微博授权
    private SsoHandler mSsohandler;
    private AuthInfo mAuthInfo;
    private Oauth2AccessToken mToken;
    private ImageView return_;
    private  Gson g=new Gson();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initview();

    }

    private Handler mHandler=new Handler(){
        @SuppressLint("LongLogTag")
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what)
            {
                case LOGIN_SUCCEED:
                    ToastUtils.showToast(LoginActivity.this,"登陆成功!");
                        UserInfoModel userInfoModel = g.fromJson(msg.obj.toString(), UserInfoModel.class);
                        UserInfoModel.DataBean data1 = userInfoModel.getData();
                        UserManager user=new UserManager(getApplicationContext());
                        user.setData(data1.getToken(),data1.getLogin_name(),data1.getNick_name(),data1.getSex(),data1.getUid(),data1.getUser_type(),data1.getAvatar(),"1",data1.getAddress(),data1.getIntro(),data1.getAccount(),data1.getFollow_count(),data1.getFollower_count());
                    Intent intent=new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case LOGIN_LOSE:
                    ToastUtils.showToast(LoginActivity.this,msg.obj.toString());
                    break;
                case OTHER_SUCCESS:
                    ToastUtils.showToast(LoginActivity.this,"登录成功");
                    UserInfoModel other_login = g.fromJson(msg.obj.toString(), UserInfoModel.class);
                    UserInfoModel.DataBean data = other_login.getData();
                    UserManager userManager=new UserManager(getApplicationContext());
                    userManager.setData(data.getToken(),data.getLogin_name(), data.getNick_name(),data.getSex(),data.getUid(), data.getUser_type(), data.getAvatar(),"1",data.getAddress(),data.getIntro(),data.getAccount(),data.getFollow_count(),data.getFollower_count());
                    Intent intent_qq=new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent_qq);
                    finish();
                    break;
                case OTHER_LOSE:
                    ToastUtils.showToast(LoginActivity.this,"网络有误");
                    break;
            }

        }
    };

    private void initview() {
        sure= (Button) findViewById(R.id.sure);
        user_box= (EditText) findViewById(R.id.user_box);
        password_box= (EditText) findViewById(R.id.password_box);
        register= (TextView) findViewById(R.id.register);
        iv_login_qq= (ImageView) findViewById(R.id.iv_login_qq);
        iv_login_weibo= (ImageView) findViewById(R.id.iv_login_weibo);
        iv_login_weixin= (ImageView) findViewById(R.id.iv_login_weixin);
        return_= (ImageView) findViewById(R.id.return_);

        sure.setOnClickListener(this);
        register.setOnClickListener(this);
        iv_login_qq.setOnClickListener(this);
        iv_login_weibo.setOnClickListener(this);
        iv_login_weixin.setOnClickListener(this);

        return_.setOnClickListener(this);


    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.sure:
                loging();
                break;
            case R.id.register:
                Intent in=new Intent(LoginActivity.this, RegisterActivity_Select.class);
                startActivity(in);
                break;
            //QQ登录
            case R.id.iv_login_qq:
                authQQ();
                break;
            //微博登录
            case R.id.iv_login_weibo:
                autoWeiBo();
                break;
            //微信登录
            case R.id.iv_login_weixin:
                WeiXinAuthApi weiXinAuthApi=new WeiXinAuthApi(this);
                weiXinAuthApi.auth();
                break;
            case R.id.return_:
                finish();
                break;
        }
    }

    private void autoWeiBo() {
          mAuthInfo=new AuthInfo(this,Consts.SINAWEIBO_APPKEY,Consts.SINAWEIBO_REDIRECT_URI,Consts.SSINAWEIBO_COPE);
          mSsohandler=new SsoHandler(this,mAuthInfo);
          mSsohandler.authorizeClientSso(new SelfWbAuthListener());
    }

    /***手机登陆*/
    @SuppressLint("LongLogTag")
    private void loging() {
        final String user = user_box.getText().toString();
        String password=password_box.getText().toString();
        if (user.isEmpty())
        {
            ToastUtils.showToast(this,"请输入手机号！");
            return;
        }
        if (password.isEmpty())
        {
            ToastUtils.showToast(this,"请输入密码！");
            return;
        }
        String telRegex = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        boolean matches = user.matches(telRegex);
        if (!matches)
        {
            Toast.makeText(LoginActivity.this,"请输入正确的手机号！", Toast.LENGTH_SHORT).show();
            return;
        }
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringrequest=new StringRequest(Request.Method.POST, UrlUtils.LOGIN + "?version=" + Version.PackageName(this) + "&mobile=" + user + "&password="+password, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    org.json.JSONObject json=new org.json.JSONObject(s);
                    String code = json.getString("code");
                    if (code.equals("1"))
                    {
                        Gson g=new Gson();
                        Message message=new Message();
                        message.what=LOGIN_SUCCEED;
                        message.obj=s;
                        mHandler.sendMessage(message);
                    }else {
                        Message message=new Message();
                        message.what=LOGIN_LOSE;
                        message.obj=json.getString("message");
                        mHandler.sendMessage(message);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Login login = g.fromJson(volleyError.toString(), Login.class);
                String state = login.getMessage();
                Message message=new Message();
                message.what=LOGIN_LOSE;
                message.obj=state;
                mHandler.sendMessage(message);
            }
        });
        requestQueue.add(stringrequest);
    }


    /***QQ登陆*/
    private void authQQ() {
        if (!isQQInstalled())
        {
            Toast.makeText(LoginActivity.this,"您的手机未安装QQ，安装后才能登陆！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (getTencent()!=null)
        {
            getTencent().logout(this);
            getTencent().login(this, Consts.QQ_SCOPE, new IUiListener() {
                @Override
                public void onComplete(Object o) {
                    JSONObject obj= (JSONObject) o;
                    String access_token=obj.optString("openid");
                    if (!TextUtils.isEmpty(access_token))
                    {
                        String version=Version.PackageName(LoginActivity.this);
                        doThreeLogin("qq",version,access_token);
                    }
                }

                @Override
                public void onError(UiError uiError) {
                    Toast.makeText(LoginActivity.this, "授权失败！", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onCancel() {

                }
            });
        }
          mTencent=Tencent.createInstance(Consts.QQ_APPID,this.getApplicationContext());

    }

    private void doThreeLogin(String type, String version, String access_token) {
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(UrlUtils.OTHER_LOGIN + "?version=" + version + "&type=" + type + "&access_token=" + access_token, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Message message=new Message();
                message.what=OTHER_SUCCESS;
                message.obj=s;
                mHandler.sendMessage(message);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
               mHandler.sendEmptyMessage(OTHER_LOSE);
            }
        });
        requestQueue.add(stringRequest);

    }


    private boolean isQQInstalled(){
        boolean result=false;
        PackageManager packageManager= getPackageManager();
        if (packageManager!=null)
        {
            try {
                ApplicationInfo info=packageManager.getApplicationInfo("com.tencent.mobileqq",PackageManager.GET_META_DATA);
                if (info!=null)
                {
                    result=true;
                }
            } catch (PackageManager.NameNotFoundException e) {
              result=false;
            }
        }
        return result;
    }
    private Tencent getTencent(){
        if (mTencent==null)
        {
            mTencent=Tencent.createInstance(Consts.QQ_APPID , LoginActivity.this);
        }
        return mTencent;
    }

    private class SelfWbAuthListener implements WeiboAuthListener{

        @Override
        public void onComplete(Bundle bundle) {
           mToken=Oauth2AccessToken.parseAccessToken(bundle);
            if (mToken.isSessionValid())
            {
                String version=Version.PackageName(LoginActivity.this);
                doThreeLogin("wb",version,mToken.getToken());
            }
        }

        @Override
        public void onWeiboException(WeiboException e) {

        }

        @Override
        public void onCancel() {

        }
    }

}
