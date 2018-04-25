package com.example.tz.tuozhe.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tz on 2018/3/23.
 */
public class StylistBean implements Serializable{


    /**
     * code : 1
     * data : {"display":[{"uid":"100103","ordered":"50","bill":"10","evaluate":"0","nick_name":"设计师","avatar":"http://tz.tuozhe8.com//uploads/images/20180321/25945f25d9a30a9c450c2dd22885097a.jpeg","address":"北京","charge":"收费面议"},{"uid":"100131","ordered":"10","bill":"20","evaluate":"30","nick_name":"拓者App","avatar":"http://tz.tuozhe8.com/","address":"","charge":"收费面议"},{"uid":"100148","ordered":"0","bill":"0","evaluate":"0","nick_name":"默默","avatar":"http://tz.tuozhe8.com/","address":"","charge":"收费面议"}],"case":[{"id":"7","logo":"/uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg","uid":"100131"},{"id":"8","logo":"/uploads/images/20180408/5d83e41cd2572d5384f8868952508f5f.jpeg","uid":"100103"},{"id":"9","logo":"/uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg","uid":"100103"}]}
     * message : success
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

    public static class DataBean {
        private List<DisplayBean> display;
        @SerializedName("case")
        private List<CaseBean> caseX;

        public List<DisplayBean> getDisplay() {
            return display;
        }

        public void setDisplay(List<DisplayBean> display) {
            this.display = display;
        }

        public List<CaseBean> getCaseX() {
            return caseX;
        }

        public void setCaseX(List<CaseBean> caseX) {
            this.caseX = caseX;
        }

        public static class DisplayBean {
            /**
             * uid : 100103
             * ordered : 50
             * bill : 10
             * evaluate : 0
             * nick_name : 设计师
             * avatar : http://tz.tuozhe8.com//uploads/images/20180321/25945f25d9a30a9c450c2dd22885097a.jpeg
             * address : 北京
             * charge : 收费面议
             */

            private String uid;
            private String ordered;
            private String bill;
            private String evaluate;
            private String nick_name;
            private String avatar;
            private String address;
            private String charge;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getOrdered() {
                return ordered;
            }

            public void setOrdered(String ordered) {
                this.ordered = ordered;
            }

            public String getBill() {
                return bill;
            }

            public void setBill(String bill) {
                this.bill = bill;
            }

            public String getEvaluate() {
                return evaluate;
            }

            public void setEvaluate(String evaluate) {
                this.evaluate = evaluate;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
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

            public String getCharge() {
                return charge;
            }

            public void setCharge(String charge) {
                this.charge = charge;
            }
        }

        public static class CaseBean {
            /**
             * id : 7
             * logo : /uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg
             * uid : 100131
             */

            private String id;
            private String logo;
            private String uid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }
        }
    }
}

