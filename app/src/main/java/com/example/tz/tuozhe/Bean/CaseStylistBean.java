package com.example.tz.tuozhe.Bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tz on 2018/4/16.
 */
public class CaseStylistBean implements Serializable{


    /**
     * code : 1
     * data : {"display":{"uid":"100152","ordered":"0","bill":"0","evaluate":"0","nick_name":"柴","avatar":"http://tz.tuozhe8.com/uploads/avatar/86cad833bcf4df811448cdc7e4eccfb5100152.jpeg","address":"","charge":"收费面议"},"case":[{"uid":"100152","ordered":"0","bill":"0","evaluate":"0","name":"","mobile":"","space":"","status":"1","ren_zheng":"2","ren_zhengtime":"","city":"","address":"","charge":"收费面议","ren_zhengduetime":"","vipduetime":"","id":"9","catid":"3","catid2":"5","title":"案例777","type":"1","video_type":"","content":"<p>项目地点：杭州<\/p><p>项目类型：平层<\/p><p>项目性质：半包<\/p><p>考虑到户型的限制，客厅飘窗不能拆改，设计师在客厅打造了一面长长的飘窗，搭配着两侧木质书架，线条简洁有力，氛围温馨宁静，让这个浅色的家处处都洋溢着通透又安静的气息，在视觉感官上似乎增加了好几十方，这个小小的改变，除了能更有效的利用整个空间面积，也让人能更接近自然一些。<img src=\"http://tz.tuozhe8.com/uploads/images/20180323/1521767996740997.jpg\" title=\"1521767996740997.jpg\" alt=\"122201zf7fzi747eul19ze.jpg\"/><img src=\"http://tz.tuozhe8.com/uploads/images/20180323/1521768000224722.jpg\" title=\"1521768000224722.jpg\" alt=\"123046jrry2vof1v9cqqi0.jpg\"/><\/p>","lecturer":"无","sign_number":"0","purchase_number":"0","is_charge":"0","price":"0.00","label":"中文","logo":"http://tz.tuozhe8.com//uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg","like_number":"","like_count":"0","comment_count":"0","view_count":"23","hot":"1","creatime":"1521598471","hot_time":"1522215688","is_del":"0","source":"1","nick_name":"拓者大编","share_links":"http://tz.tuozhe8.com/api.php/api8/share/details/id/9.html"}],"circle":[{"posts_id":"102","circle_id":"0","type":"1","title":"柴","content":"柴柴柴","like_count":"0","comment_count":"0","view_count":"0","status":"1","is_top":"2","is_del":"0","address":"0","created_uid":"100152","created_at":"1523864133","update_at":"","attaches":[],"share_links":"http://tz.tuozhe8.com/api.php/api8/share/posts_detail/posts_id/102/token/667501003e3c382f85b2c14de7393791.html","collect":"0","is_like":"0","created_user":{"uid":"100152","nick_name":"柴","avatar":"http://tz.tuozhe8.com/uploads/avatar/86cad833bcf4df811448cdc7e4eccfb5100152.jpeg","age":"0","sex":"1","intro":"","follow":"2"}}],"evaluate":[]}
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

    public static class DataBean implements Serializable{
        /**
         * display : {"uid":"100152","ordered":"0","bill":"0","evaluate":"0","nick_name":"柴","avatar":"http://tz.tuozhe8.com/uploads/avatar/86cad833bcf4df811448cdc7e4eccfb5100152.jpeg","address":"","charge":"收费面议"}
         * case : [{"uid":"100152","ordered":"0","bill":"0","evaluate":"0","name":"","mobile":"","space":"","status":"1","ren_zheng":"2","ren_zhengtime":"","city":"","address":"","charge":"收费面议","ren_zhengduetime":"","vipduetime":"","id":"9","catid":"3","catid2":"5","title":"案例777","type":"1","video_type":"","content":"<p>项目地点：杭州<\/p><p>项目类型：平层<\/p><p>项目性质：半包<\/p><p>考虑到户型的限制，客厅飘窗不能拆改，设计师在客厅打造了一面长长的飘窗，搭配着两侧木质书架，线条简洁有力，氛围温馨宁静，让这个浅色的家处处都洋溢着通透又安静的气息，在视觉感官上似乎增加了好几十方，这个小小的改变，除了能更有效的利用整个空间面积，也让人能更接近自然一些。<img src=\"http://tz.tuozhe8.com/uploads/images/20180323/1521767996740997.jpg\" title=\"1521767996740997.jpg\" alt=\"122201zf7fzi747eul19ze.jpg\"/><img src=\"http://tz.tuozhe8.com/uploads/images/20180323/1521768000224722.jpg\" title=\"1521768000224722.jpg\" alt=\"123046jrry2vof1v9cqqi0.jpg\"/><\/p>","lecturer":"无","sign_number":"0","purchase_number":"0","is_charge":"0","price":"0.00","label":"中文","logo":"http://tz.tuozhe8.com//uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg","like_number":"","like_count":"0","comment_count":"0","view_count":"23","hot":"1","creatime":"1521598471","hot_time":"1522215688","is_del":"0","source":"1","nick_name":"拓者大编","share_links":"http://tz.tuozhe8.com/api.php/api8/share/details/id/9.html"}]
         * circle : [{"posts_id":"102","circle_id":"0","type":"1","title":"柴","content":"柴柴柴","like_count":"0","comment_count":"0","view_count":"0","status":"1","is_top":"2","is_del":"0","address":"0","created_uid":"100152","created_at":"1523864133","update_at":"","attaches":[],"share_links":"http://tz.tuozhe8.com/api.php/api8/share/posts_detail/posts_id/102/token/667501003e3c382f85b2c14de7393791.html","collect":"0","is_like":"0","created_user":{"uid":"100152","nick_name":"柴","avatar":"http://tz.tuozhe8.com/uploads/avatar/86cad833bcf4df811448cdc7e4eccfb5100152.jpeg","age":"0","sex":"1","intro":"","follow":"2"}}]
         * evaluate : []
         */

        private DisplayBean display;
        @SerializedName("case")
        private List<CaseBean> caseX;
        private List<CircleBean> circle;
        private List<?> evaluate;

        public DisplayBean getDisplay() {
            return display;
        }

        public void setDisplay(DisplayBean display) {
            this.display = display;
        }

        public List<CaseBean> getCaseX() {
            return caseX;
        }

        public void setCaseX(List<CaseBean> caseX) {
            this.caseX = caseX;
        }

        public List<CircleBean> getCircle() {
            return circle;
        }

        public void setCircle(List<CircleBean> circle) {
            this.circle = circle;
        }

        public List<?> getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(List<?> evaluate) {
            this.evaluate = evaluate;
        }

        public static class DisplayBean implements Serializable{
            /**
             * uid : 100152
             * ordered : 0
             * bill : 0
             * evaluate : 0
             * nick_name : 柴
             * avatar : http://tz.tuozhe8.com/uploads/avatar/86cad833bcf4df811448cdc7e4eccfb5100152.jpeg
             * address :
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

        public static class CaseBean implements Serializable{
            /**
             * uid : 100152
             * ordered : 0
             * bill : 0
             * evaluate : 0
             * name :
             * mobile :
             * space :
             * status : 1
             * ren_zheng : 2
             * ren_zhengtime :
             * city :
             * address :
             * charge : 收费面议
             * ren_zhengduetime :
             * vipduetime :
             * id : 9
             * catid : 3
             * catid2 : 5
             * title : 案例777
             * type : 1
             * video_type :
             * content : <p>项目地点：杭州</p><p>项目类型：平层</p><p>项目性质：半包</p><p>考虑到户型的限制，客厅飘窗不能拆改，设计师在客厅打造了一面长长的飘窗，搭配着两侧木质书架，线条简洁有力，氛围温馨宁静，让这个浅色的家处处都洋溢着通透又安静的气息，在视觉感官上似乎增加了好几十方，这个小小的改变，除了能更有效的利用整个空间面积，也让人能更接近自然一些。<img src="http://tz.tuozhe8.com/uploads/images/20180323/1521767996740997.jpg" title="1521767996740997.jpg" alt="122201zf7fzi747eul19ze.jpg"/><img src="http://tz.tuozhe8.com/uploads/images/20180323/1521768000224722.jpg" title="1521768000224722.jpg" alt="123046jrry2vof1v9cqqi0.jpg"/></p>
             * lecturer : 无
             * sign_number : 0
             * purchase_number : 0
             * is_charge : 0
             * price : 0.00
             * label : 中文
             * logo : http://tz.tuozhe8.com//uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg
             * like_number :
             * like_count : 0
             * comment_count : 0
             * view_count : 23
             * hot : 1
             * creatime : 1521598471
             * hot_time : 1522215688
             * is_del : 0
             * source : 1
             * nick_name : 拓者大编
             * share_links : http://tz.tuozhe8.com/api.php/api8/share/details/id/9.html
             */

            private String uid;
            private String ordered;
            private String bill;
            private String evaluate;
            private String name;
            private String mobile;
            private String space;
            private String status;
            private String ren_zheng;
            private String ren_zhengtime;
            private String city;
            private String address;
            private String charge;
            private String ren_zhengduetime;
            private String vipduetime;
            private String id;
            private String catid;
            private String catid2;
            private String title;
            private String type;
            private String video_type;
            private String content;
            private String lecturer;
            private String sign_number;
            private String purchase_number;
            private String is_charge;
            private String price;
            private String label;
            private String logo;
            private String like_number;
            private String like_count;
            private String comment_count;
            private String view_count;
            private String hot;
            private String creatime;
            private String hot_time;
            private String is_del;
            private String source;
            private String nick_name;
            private String share_links;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getSpace() {
                return space;
            }

            public void setSpace(String space) {
                this.space = space;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getRen_zheng() {
                return ren_zheng;
            }

            public void setRen_zheng(String ren_zheng) {
                this.ren_zheng = ren_zheng;
            }

            public String getRen_zhengtime() {
                return ren_zhengtime;
            }

            public void setRen_zhengtime(String ren_zhengtime) {
                this.ren_zhengtime = ren_zhengtime;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
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

            public String getRen_zhengduetime() {
                return ren_zhengduetime;
            }

            public void setRen_zhengduetime(String ren_zhengduetime) {
                this.ren_zhengduetime = ren_zhengduetime;
            }

            public String getVipduetime() {
                return vipduetime;
            }

            public void setVipduetime(String vipduetime) {
                this.vipduetime = vipduetime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getCatid() {
                return catid;
            }

            public void setCatid(String catid) {
                this.catid = catid;
            }

            public String getCatid2() {
                return catid2;
            }

            public void setCatid2(String catid2) {
                this.catid2 = catid2;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getVideo_type() {
                return video_type;
            }

            public void setVideo_type(String video_type) {
                this.video_type = video_type;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getLecturer() {
                return lecturer;
            }

            public void setLecturer(String lecturer) {
                this.lecturer = lecturer;
            }

            public String getSign_number() {
                return sign_number;
            }

            public void setSign_number(String sign_number) {
                this.sign_number = sign_number;
            }

            public String getPurchase_number() {
                return purchase_number;
            }

            public void setPurchase_number(String purchase_number) {
                this.purchase_number = purchase_number;
            }

            public String getIs_charge() {
                return is_charge;
            }

            public void setIs_charge(String is_charge) {
                this.is_charge = is_charge;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getLike_number() {
                return like_number;
            }

            public void setLike_number(String like_number) {
                this.like_number = like_number;
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

            public String getHot() {
                return hot;
            }

            public void setHot(String hot) {
                this.hot = hot;
            }

            public String getCreatime() {
                return creatime;
            }

            public void setCreatime(String creatime) {
                this.creatime = creatime;
            }

            public String getHot_time() {
                return hot_time;
            }

            public void setHot_time(String hot_time) {
                this.hot_time = hot_time;
            }

            public String getIs_del() {
                return is_del;
            }

            public void setIs_del(String is_del) {
                this.is_del = is_del;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getShare_links() {
                return share_links;
            }

            public void setShare_links(String share_links) {
                this.share_links = share_links;
            }
        }

        public static class CircleBean implements Serializable{
            /**
             * posts_id : 102
             * circle_id : 0
             * type : 1
             * title : 柴
             * content : 柴柴柴
             * like_count : 0
             * comment_count : 0
             * view_count : 0
             * status : 1
             * is_top : 2
             * is_del : 0
             * address : 0
             * created_uid : 100152
             * created_at : 1523864133
             * update_at :
             * attaches : []
             * share_links : http://tz.tuozhe8.com/api.php/api8/share/posts_detail/posts_id/102/token/667501003e3c382f85b2c14de7393791.html
             * collect : 0
             * is_like : 0
             * created_user : {"uid":"100152","nick_name":"柴","avatar":"http://tz.tuozhe8.com/uploads/avatar/86cad833bcf4df811448cdc7e4eccfb5100152.jpeg","age":"0","sex":"1","intro":"","follow":"2"}
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
            private String share_links;
            private String collect;
            private String is_like;
            private CreatedUserBean created_user;
            private List<?> attaches;

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

            public String getShare_links() {
                return share_links;
            }

            public void setShare_links(String share_links) {
                this.share_links = share_links;
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

            public CreatedUserBean getCreated_user() {
                return created_user;
            }

            public void setCreated_user(CreatedUserBean created_user) {
                this.created_user = created_user;
            }

            public List<?> getAttaches() {
                return attaches;
            }

            public void setAttaches(List<?> attaches) {
                this.attaches = attaches;
            }

            public static class CreatedUserBean implements Serializable{
                /**
                 * uid : 100152
                 * nick_name : 柴
                 * avatar : http://tz.tuozhe8.com/uploads/avatar/86cad833bcf4df811448cdc7e4eccfb5100152.jpeg
                 * age : 0
                 * sex : 1
                 * intro :
                 * follow : 2
                 */

                private String uid;
                private String nick_name;
                private String avatar;
                private String age;
                private String sex;
                private String intro;
                private String follow;

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
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

                public String getAge() {
                    return age;
                }

                public void setAge(String age) {
                    this.age = age;
                }

                public String getSex() {
                    return sex;
                }

                public void setSex(String sex) {
                    this.sex = sex;
                }

                public String getIntro() {
                    return intro;
                }

                public void setIntro(String intro) {
                    this.intro = intro;
                }

                public String getFollow() {
                    return follow;
                }

                public void setFollow(String follow) {
                    this.follow = follow;
                }
            }
        }
    }
}

