package com.example.tz.tuozhe.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/*
*  SharedPreferences 工具类
*  用 SharedPreferences 存储一些 APP 和用户所需的一些信息作为全局变量
*  方便在各个类里拿到信息直接使用
* */

public class SharedUtils {

    // 设置APP打开次数 （1，上下文，2，名字）
    public static void setAppNumbaer(Context context, int appNumber) {
        //获取共享偏好
        SharedPreferences settings = context.getSharedPreferences("User", 0);
        //写入数据
        Editor editor = settings.edit();
        editor.putInt("appNumber", appNumber);
        editor.commit();
    }

    // 获取APP打开次数（上下文）
    public static int getAppNumbaer(Context context) {
        //获取共享
        SharedPreferences settings = context.getSharedPreferences("User", 0);
        //获取数据
        return settings.getInt("appNumber", 0);
    }

    // 设置屏幕的宽度 （1，上下文，2，名字）
    public static void setDeviceWidth(Context context, int DeviceWidth) {
        //获取共享偏好
        SharedPreferences settings = context.getSharedPreferences("User", 0);
        //写入数据
        Editor editor = settings.edit();
        editor.putInt("DeviceWidth", DeviceWidth);
        editor.commit();
    }

    // 获取屏幕的宽度（上下文）
    public static int getDeviceWidth(Context context) {
        //获取共享
        SharedPreferences settings = context.getSharedPreferences("User", 0);
        //获取数据
        return settings.getInt("DeviceWidth", 0);
    }

    // 设置屏幕的高度 （1，上下文，2，名字）
    public static void setDeviceHeight(Context context, int DeviceHeight) {
        //获取共享偏好
        SharedPreferences settings = context.getSharedPreferences("User", 0);
        //写入数据
        Editor editor = settings.edit();
        editor.putInt("DeviceHeight", DeviceHeight);
        editor.commit();
    }

    // 获取屏幕的高度（上下文）
    public static int getDeviceHeight(Context context) {
        //获取共享
        SharedPreferences settings = context.getSharedPreferences("User", 0);
        //获取数据
        return settings.getInt("DeviceHeight", 0);
    }

}
