package com.example.tz.tuozhe.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tz.tuozhe.Bean.UserInfoModel;


public class UserManager {

    private Context context;
    public UserManager(Context context){
        this.context=context;
    }

    public UserManager setData(String token, String login_name, String nick_name, String sex, String uid, String user_type, String avatar,String state,String address,String intro,String account,String follow,String follower){
        SharedPreferences sharedPreferences=context.getSharedPreferences("DATA",Context.MODE_ENABLE_WRITE_AHEAD_LOGGING|Context.MODE_WORLD_WRITEABLE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("token",token);
        edit.putString("mobile_name",login_name);
        edit.putString("nick_name",nick_name);
        edit.putString("sex",sex);
        edit.putString("uid",uid);
        edit.putString("user_type",user_type);
        edit.putString("avatar",avatar);
        edit.putString("state",state);
        edit.putString("address",address);
        edit.putString("intro",intro);
        edit.putString("account",account);
        edit.putString("follow",follow);
        edit.putString("follower",follower);
        edit.commit();
        return null;
    }

}
