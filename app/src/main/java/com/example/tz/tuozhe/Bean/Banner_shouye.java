package com.example.tz.tuozhe.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tz on 2018/3/17.
 */
public class Banner_shouye implements Serializable {


    /**
     * code : 1
     * data : [{"posts_id":"96","type":"3","title":"AD","logo":"http://tz.tuozhe8.com/public/uploads/images/20180316/43e527cafd55758b2dc6ff9f734ffa75.png","share_links":"http://tz.tuozhe8.com/public/api.php/api8/share/posts_detail/posts_id/96/token/ac5345fa93e9ae37be8867b81adc0723.html"},{"posts_id":"2","type":"3","title":"广告2","logo":"http://tz.tuozhe8.com/public/uploads/images/20180316/2c62ea37279aa45aa422dce6d948d139.png","share_links":"http://tz.tuozhe8.com/public/api.php/api8/share/posts_detail/posts_id/2/token/0b8d7150113f38543ebfd325332aec3c.html"},{"posts_id":"1","type":"3","title":"广告1","logo":"http://tz.tuozhe8.com/public/uploads/images/20170909/fb4d5909b651ae3acbea2b7014af7347.jpeg","share_links":"http://tz.tuozhe8.com/public/api.php/api8/share/posts_detail/posts_id/1/token/b87c65a1a95873737912f2fd814ce361.html"}]
     * message : success
     */

    private String code;
    private String message;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * posts_id : 96
         * type : 3
         * title : AD
         * logo : http://tz.tuozhe8.com/public/uploads/images/20180316/43e527cafd55758b2dc6ff9f734ffa75.png
         * share_links : http://tz.tuozhe8.com/public/api.php/api8/share/posts_detail/posts_id/96/token/ac5345fa93e9ae37be8867b81adc0723.html
         */

        private String posts_id;
        private String type;
        private String title;
        private String logo;
        private String share_links;

        public String getPosts_id() {
            return posts_id;
        }

        public void setPosts_id(String posts_id) {
            this.posts_id = posts_id;
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

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getShare_links() {
            return share_links;
        }

        public void setShare_links(String share_links) {
            this.share_links = share_links;
        }
    }
}

