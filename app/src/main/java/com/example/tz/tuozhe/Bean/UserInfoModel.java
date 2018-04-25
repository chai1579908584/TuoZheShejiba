package com.example.tz.tuozhe.Bean;

import java.io.Serializable;

/**
 * Created by Tz on 2018/3/19.
 */
public class UserInfoModel implements Serializable{


    /**
     * code : 1
     * data : {"uid":"100146","login_name":"17600027632","nick_name":"柴","token":"cdc28f389a259593e2e38f3905306ee0","user_type":"1","sex":"1","avatar":"http://tz.tuozhe8.com/uploads/avatar/4cd3e5e36cb17a08030f3842a6679287100146.jpeg","account":"0","intro":"柴柴","address":"北京市北京市昌平区","follow_count":"0","follower_count":"0"}
     * message : 登录成功
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
         * login_name : 17600027632
         * nick_name : 柴
         * token : cdc28f389a259593e2e38f3905306ee0
         * user_type : 1
         * sex : 1
         * avatar : http://tz.tuozhe8.com/uploads/avatar/4cd3e5e36cb17a08030f3842a6679287100146.jpeg
         * account : 0
         * intro : 柴柴
         * address : 北京市北京市昌平区
         * follow_count : 0
         * follower_count : 0
         */

        private String uid;
        private String login_name;
        private String nick_name;
        private String token;
        private String user_type;
        private String sex;
        private String avatar;
        private String account;
        private String intro;
        private String address;
        private String follow_count;
        private String follower_count;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
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

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUser_type() {
            return user_type;
        }

        public void setUser_type(String user_type) {
            this.user_type = user_type;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAccount() {
            return account;
        }

        public void setAccount(String account) {
            this.account = account;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFollow_count() {
            return follow_count;
        }

        public void setFollow_count(String follow_count) {
            this.follow_count = follow_count;
        }

        public String getFollower_count() {
            return follower_count;
        }

        public void setFollower_count(String follower_count) {
            this.follower_count = follower_count;
        }
    }
}

