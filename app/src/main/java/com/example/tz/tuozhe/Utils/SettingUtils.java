package com.example.tz.tuozhe.Utils;

/**
 * 设置工具类
 * 控制一些页面或者类的状态
 */

public class SettingUtils {
    /*
    * 设置引导页是本地图片还是网络获取  true为网络  false为本地
    * 本地的话换掉 mipmap 和 OtherUtils 工具类里的图片即可
    * 网络需要换掉 UrlUtils 工具类里的引导页图片的网址、 GuideBean 实体类和 GuidePresenterImpl 里的Gson解析代码块
    * */
    public static final boolean GUIDE_PIC = false;

    /*
    * 设置引导页下方的圆点是否显示  true为显示  false为隐藏
    * 主要是根据UI提供的图片决定，图片有指示点设置 false ，图片没有指示点设置 true
    * */
    public static final boolean GUIDE_POINT = true;

    /*
    * 设置主页面的ViewPager是否可以滑动   true为可以  false为不可以
    *主要是根据项目需求文档决定，后期更改 APP 页面切换也方便
    * */
    public static final boolean ISCANSCROLL = true;

}
