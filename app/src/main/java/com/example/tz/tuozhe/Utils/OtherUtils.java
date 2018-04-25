package com.example.tz.tuozhe.Utils;


import com.example.tz.tuozhe.R;

/**
 * 工具类
 * 图片和一些琐碎的全局变量
 */

public class OtherUtils {

    //加载页背景图片
    public static final int SPLASH_PIC = R.mipmap.phone_bg_02;
    //加载页展示的时间 单位: 秒
    public static final int SPLASH_TIME = 2;

    //引导页面 ViewPager 图片
    public static final int[] GUIDE_PICS = {R.mipmap.phone_bg_01, R.mipmap.phone_bg_02, R.mipmap.phone_bg_03, R.mipmap.phone_bg_04};
    //引导页 ViewPager 的指示点图片  显示选中的  后是未选中的
    public static final int[] GUIDE_POINTS = {R.mipmap.red_point, R.mipmap.green_point};
}
