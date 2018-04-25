package com.example.tz.tuozhe.Login;


import android.content.Context;
import android.widget.Toast;

import com.example.tz.tuozhe.Utils.Consts;
import com.example.tz.tuozhe.Utils.MyApplication;
import com.tencent.mm.sdk.modelmsg.SendAuth;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;


public class WeiXinAuthApi {

    private  IWXAPI mWXAPI;
    private Context context;
    public WeiXinAuthApi(Context content){
        this.context=content;
    }

    private  void registerToWeiXin() {
        mWXAPI = WXAPIFactory.createWXAPI(context, Consts.WEIXINAPPID, true);
        mWXAPI.registerApp(Consts.WEIXINAPPID);
    }

    public  IWXAPI getWXAPI() {
        if (mWXAPI == null) {
            registerToWeiXin();
        }
        return mWXAPI;
    }

    public  boolean isWXAPPInstalled() {
        if (getWXAPI() == null) {
            Toast.makeText(context, "微信登陆失败，请重启App再试！", Toast.LENGTH_SHORT).show();
            return false;
        }
        return getWXAPI().isWXAppInstalled();
    }

    public  void auth() {
        login();
    }


    public  void login() {

        if (!isWXAPPInstalled()) {
            Toast.makeText(context, "您的手机未安装微信，安装后才能登陆！", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!mWXAPI.isWXAppSupportAPI()) {
            Toast.makeText(context, "您的手机微信版本太低，建议安装最新版微信！", Toast.LENGTH_SHORT).show();
            return;
        }
        //登录的第一步：请求链接code，请求成功后发送广播通知
        final SendAuth.Req req = new SendAuth.Req();
        req.scope = Consts.WEIXIN_SCOPE;
        req.state = "tuozhe";
        mWXAPI.sendReq(req);
    }

}
