package com.example.tz.tuozhe.Bean;

import java.io.Serializable;

/**
 * Created by Tz on 2018/4/13.
 */
public class ModificationBean implements Serializable{

    /**
     * code : 1
     * data : {"uid":"100146","account":"0","sex":"1","sign":"0","tags":"","intro":"","latitude":"","longitude":"","avatar":"https://www.zhuomazaima.net/static/images/avatar/avatar1.png","hot_address":"","address":"","school_id":"0","login_name":"17600027632","nick_name":"","age":"0","share_links":"http://tz.tuozhe8.com/api.php/api8/share/user/uid/100146/token/0607632b4071cc64aacaa0dbc3250a58.html","follower_count":"0","follow_count":"0","friends_count":"0"}
     * message : 修改成功
     */

    private String code;
    private DataBean data;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean implements Serializable{
        /**
         * uid : 100146
         * account : 0
         * sex : 1
         * sign : 0
         * tags :
         * intro :
         * latitude :
         * longitude :
         * avatar : https://www.zhuomazaima.net/static/images/avatar/avatar1.png
         * hot_address :
         * address :
         * school_id : 0
         * login_name : 17600027632
         * nick_name :
         * age : 0
         * share_links : http://tz.tuozhe8.com/api.php/api8/share/user/uid/100146/token/0607632b4071cc64aacaa0dbc3250a58.html
         * follower_count : 0
         * follow_count : 0
         * friends_count : 0
         */

        private String uid;
        private String account;
        private String sex;
        private String sign;
        private String tags;
        private String intro;
        private String latitude;
        private String longitude;
        private String avatar;
        private String hot_address;
        private String address;
        private String school_id;
        private String login_name;
        private String nick_name;
        private String age;
        private String share_links;
        private String follower_count;
        private String follow_count;
        private String friends_count;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getHot_address() {
            return hot_address;
        }

        public void setHot_address(String hot_address) {
            this.hot_address = hot_address;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSchool_id() {
            return school_id;
        }

        public void setSchool_id(String school_id) {
            this.school_id = school_id;
        }

        public String getLogin_name() {
            return login_name;
        }

        public void setLogin_name(String login_name) {
            this.login_name = login_name;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getShare_links() {
            return share_links;
        }

        public void setShare_links(String share_links) {
            this.share_links = share_links;
        }

        public String getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(String follower_count) {
            this.follower_count = follower_count;
        }

        public String getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(String follow_count) {
            this.follow_count = follow_count;
        }

        public String getFriends_count() {
            return friends_count;
        }

        public void setFriends_count(String friends_count) {
            this.friends_count = friends_count;
        }
    }
}

