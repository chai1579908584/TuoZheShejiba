package com.example.tz.tuozhe.Utils;

/**
 * 网络接口的工具类
 */

public class UrlUtils {

    //引导页图片的网址
    public static final String GUIDE_URL = "http://atp.fulishe.com/ClientApi/category.php?api_version=1.0&act=search_category_goods_list&c_id=35&order_price=0&page_num=20&page=1&debug=true&client_id=null";


    public static final String URL="https://app.tuozhe8.com/api.php/api/";//上线
    //public static final String URL="http://tuozhe.cn/api.php/api/";//测试


    public static final String BANNER=URL+"Lists/banner_list";//轮播图
    public static final String LOGIN=URL+"Login/index";//手机号登陆
    public static final String SEND_CODE=URL+"Login/alidayu_sms";//发送验证码
    public static final String REGISTER=URL+"Login/register";//手机号注册
    public static final String LIST_MODEL=URL+"Lists/content_lists";//首页列表
    public static final String STYLIST=URL+"Lists/designer";//设计师列表
    public static final String CASE_LIST=URL+"Lists/hot_case";//案例推荐
    public static final String OTHER_LOGIN=URL+"Login/other_login";//三方登陆
    public static final String LOGINOUT=URL+"Logout/index";//退出登录
    public static final String UPLOADING=URL+"Upload/avatar";//上传头像
    public static final String MODIFICATION=URL+"Profile/update";//修改个人信息
    public static final String USERHOME=URL+"Detail/user";//用户主页
    public static final String DETAILS=URL+"Circle/details";//详情
    public static final String USERIMAGE=URL+"Detail/user_images";//用户相册
    public static final String LIKE=URL+"Circle/like_posts";//点赞
    public static final String CENCEL_LIKE=URL+"Circle/unlike_posts";//取消点赞
    public static final String COMMENT=URL+"Circle/add_posts_comments";//评论
    public static final String COMMENT_LIST=URL+"Circle/posts_comments";//评论列表
    public static final String COLLECT=URL+"Post/collection";//收藏
    public static final String CENCEL_COLLECT=URL+"Post/uncollection";//取消收藏
    public static final String DYNAMIC_LIST=URL+"Circle/posts_lists";//动态列表
    public static final String ISSUE=URL+"Circle/posts";//发布动态
    public static final String ATTENTION=URL+"Follow/dofollow";//关注
    public static final String CENCEL_ATTENTION=URL+"Follow/unfollow";//取消关注

}
