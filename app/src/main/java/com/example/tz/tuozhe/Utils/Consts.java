package com.example.tz.tuozhe.Utils;

/**
 * Created by NEU on 2017/9/18.
 */

public class Consts {

    /**推送Token*/
    public static String token = "";
    /**App版本号*/
    public static String appVersion = "";
    /**接单时间*/
    public static final String CODE_SUCCESS = "1";
    public static final String IMAGE_PATH_TAG = "@#￥%(!---UIImageView---!)@#￥%";


    //wechat
    public static final String WEIXINAPPID = "wxd9722d41e3a14d52";
    public static final String WEIXIN_SCOPE = "snsapi_userinfo";
    public static final String WEIXIN_APPSECRET = "25aa9a922fdb04f8875335f4cd8919d9";

    //sina
    public static final String SINAWEIBO_APPKEY = "1884918411";
    public static final String SINAWEIBO_REDIRECT_URI = "http://sns.whalecloud.com/sina2/callback";
    public static final String SINAWEIBO_AppSecret = "71a696208641df9ce8809b1ebce1cf02";

    public static final String SSINAWEIBO_COPE =
            "email,direct_messages_read,direct_messages_write,"
                    + "friendships_groups_read,friendships_groups_write,statuses_to_me_read,"
                    + "follow_app_official_microblog," + "invitation_write";

    //QQ
    public static final String QQ_APPID = "1106716611";
    public static final String QQ_SCOPE = "all";

    /**DynamicFragment到FragmentMostHot传值*/
    public static String circle_id_topic = "";
    /**闪聊房间创建跳转标识符*/
    public static boolean isStartChatListActivity = false;

}
