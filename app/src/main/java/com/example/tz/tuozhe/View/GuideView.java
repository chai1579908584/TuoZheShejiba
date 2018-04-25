package com.example.tz.tuozhe.View;

import android.app.Activity;

import java.util.ArrayList;

/**
 * 引导页 V 层接口
 */

public interface GuideView {
    //图片下载完成后  参数: 1.是否成功  2.错误信息  3.图片网址集合
    void afterPics(boolean isSuccess, String error, ArrayList<String> pics);
    //传递上下文 P 层逻辑里 Volley 网络框架会用到上下文
    Activity getContent();
}
