package com.example.tz.tuozhe.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tz on 2018/4/14.
 */
public class Owner_DanamicBean implements Serializable {


    /**
     * code : 1
     * data : {"uid":"100149","account":"0","sex":"0","sign":"0","intro":"","latitude":"","longitude":"","avatar":"http://tz.tuozhe8.com/static/images/avatar/avatar0.png","address":"","login_name":"17600027632","nick_name":"柴","age":"0","share_links":"http://tz.tuozhe8.com/api.php/api8/share/user/uid/100149/token/76c5ef78e4cd8ae2db12cc51077311f4.html","follower_count":"0","follow_count":"0","friends_count":"0","follow":"2","my_posts":[{"posts_id":"15","circle_id":"25","type":"1","title":"测试","content":"测试","like_count":"0","comment_count":"0","view_count":"0","status":"1","is_top":"2","is_del":"0","address":"0","created_uid":"100046","created_at":"1506332746","update_at":"","attaches":["http://tz.tuozhe8.com/uploads/images/20170925/d80b0a550b260f37aa168c1f381f3930.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/466370129476ad4d9ff75bdf32b99d6b.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/16ce80ab28b5a3e6f11743d7543a89ce.jpeg"],"collect":"0","is_like":"0"}]}
     * message : Success
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
         * uid : 100149
         * account : 0
         * sex : 0
         * sign : 0
         * intro :
         * latitude :
         * longitude :
         * avatar : http://tz.tuozhe8.com/static/images/avatar/avatar0.png
         * address :
         * login_name : 17600027632
         * nick_name : 柴
         * age : 0
         * share_links : http://tz.tuozhe8.com/api.php/api8/share/user/uid/100149/token/76c5ef78e4cd8ae2db12cc51077311f4.html
         * follower_count : 0
         * follow_count : 0
         * friends_count : 0
         * follow : 2
         * my_posts : [{"posts_id":"15","circle_id":"25","type":"1","title":"测试","content":"测试","like_count":"0","comment_count":"0","view_count":"0","status":"1","is_top":"2","is_del":"0","address":"0","created_uid":"100046","created_at":"1506332746","update_at":"","attaches":["http://tz.tuozhe8.com/uploads/images/20170925/d80b0a550b260f37aa168c1f381f3930.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/466370129476ad4d9ff75bdf32b99d6b.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/16ce80ab28b5a3e6f11743d7543a89ce.jpeg"],"collect":"0","is_like":"0"}]
         */

        private String uid;
        private String account;
        private String sex;
        private String sign;
        private String intro;
        private String latitude;
        private String longitude;
        private String avatar;
        private String address;
        private String login_name;
        private String nick_name;
        private String age;
        private String share_links;
        private String follower_count;
        private String follow_count;
        private String friends_count;
        private String follow;
        private List<MyPostsBean> my_posts;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
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

        public String getFollow() {
            return follow;
        }

        public void setFollow(String follow) {
            this.follow = follow;
        }

        public List<MyPostsBean> getMy_posts() {
            return my_posts;
        }

        public void setMy_posts(List<MyPostsBean> my_posts) {
            this.my_posts = my_posts;
        }

        public static class MyPostsBean implements Serializable{
            /**
             * posts_id : 15
             * circle_id : 25
             * type : 1
             * title : 测试
             * content : 测试
             * like_count : 0
             * comment_count : 0
             * view_count : 0
             * status : 1
             * is_top : 2
             * is_del : 0
             * address : 0
             * created_uid : 100046
             * created_at : 1506332746
             * update_at :
             * attaches : ["http://tz.tuozhe8.com/uploads/images/20170925/d80b0a550b260f37aa168c1f381f3930.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/466370129476ad4d9ff75bdf32b99d6b.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/16ce80ab28b5a3e6f11743d7543a89ce.jpeg"]
             * collect : 0
             * is_like : 0
             */

            private String posts_id;
            private String circle_id;
            private String type;
            private String title;
            private String content;
            private String like_count;
            private String comment_count;
            private String view_count;
            private String status;
            private String is_top;
            private String is_del;
            private String address;
            private String created_uid;
            private String created_at;
            private String update_at;
            private String collect;
            private String is_like;
            private List<String> attaches;

            public String getPosts_id() {
                return posts_id;
            }

            public void setPosts_id(String posts_id) {
                this.posts_id = posts_id;
            }

            public String getCircle_id() {
                return circle_id;
            }

            public void setCircle_id(String circle_id) {
                this.circle_id = circle_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getLike_count() {
                return like_count;
            }

            public void setLike_count(String like_count) {
                this.like_count = like_count;
            }

            public String getComment_count() {
                return comment_count;
            }

            public void setComment_count(String comment_count) {
                this.comment_count = comment_count;
            }

            public String getView_count() {
                return view_count;
            }

            public void setView_count(String view_count) {
                this.view_count = view_count;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getIs_top() {
                return is_top;
            }

            public void setIs_top(String is_top) {
                this.is_top = is_top;
            }

            public String getIs_del() {
                return is_del;
            }

            public void setIs_del(String is_del) {
                this.is_del = is_del;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCreated_uid() {
                return created_uid;
            }

            public void setCreated_uid(String created_uid) {
                this.created_uid = created_uid;
            }

            public String getCreated_at() {
                return created_at;
            }

            public void setCreated_at(String created_at) {
                this.created_at = created_at;
            }

            public String getUpdate_at() {
                return update_at;
            }

            public void setUpdate_at(String update_at) {
                this.update_at = update_at;
            }

            public String getCollect() {
                return collect;
            }

            public void setCollect(String collect) {
                this.collect = collect;
            }

            public String getIs_like() {
                return is_like;
            }

            public void setIs_like(String is_like) {
                this.is_like = is_like;
            }

            public List<String> getAttaches() {
                return attaches;
            }

            public void setAttaches(List<String> attaches) {
                this.attaches = attaches;
            }
        }
    }
}

