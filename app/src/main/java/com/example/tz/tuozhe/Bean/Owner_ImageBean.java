package com.example.tz.tuozhe.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tz on 2018/4/16.
 */
public class Owner_ImageBean implements Serializable {

    /**
     * code : 1
     * data : [{"attaches":["http://tz.tuozhe8.com//uploads/images/20180409/05779bd555b446ed03588e21471b6e68.jpeg"]},{"attaches":["http://tz.tuozhe8.com/uploads/images/20170925/d80b0a550b260f37aa168c1f381f3930.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/466370129476ad4d9ff75bdf32b99d6b.jpeg","http://tz.tuozhe8.com/uploads/images/20170925/16ce80ab28b5a3e6f11743d7543a89ce.jpeg"]}]
     * message : Success
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
        private List<String> attaches;

        public List<String> getAttaches() {
            return attaches;
        }

        public void setAttaches(List<String> attaches) {
            this.attaches = attaches;
        }
    }
}

