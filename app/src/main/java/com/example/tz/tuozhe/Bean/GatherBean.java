package com.example.tz.tuozhe.Bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tz on 2018/3/23.
 */
public class GatherBean implements Serializable {


    /**
     * code : 1
     * data : {"article":[{"id":"2","catid":"2","catid2":"1","title":"文章666666666","type":"2","video_type":"","uid":"","lecturer":"无","sign_number":"0","purchase_number":"0","is_charge":"0","price":"0","label":"中文,英文,汉语,中文乱码,中文乱码,中文乱码","logo":"http://tz.tuozhe8.com//uploads/images/20180408/5d83e41cd2572d5384f8868952508f5f.jpeg","like_number":"59","like_count":"0","comment_count":"0","hot":"1","creatime":"1521789131","hot_time":"1522826985","is_del":"","source":"1","nick_name":"拓者小编","status":"1","share_links":"http://tz.tuozhe8.com/api.php/api8/share/details/id/2.html"},{"id":"3","catid":"3","catid2":"7","title":"123","type":"2","video_type":"","uid":"","lecturer":"无","sign_number":"0","purchase_number":"0","is_charge":"0","price":"0","label":"","logo":"http://tz.tuozhe8.com//uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg","like_number":"0","like_count":"0","comment_count":"0","hot":"1","creatime":"1521789431","hot_time":"1522806815","is_del":"","source":"2","nick_name":"拓者小编","status":"1","share_links":"http://tz.tuozhe8.com/api.php/api8/share/details/id/3.html"}],"video":[{"id":"7","catid":"4","catid2":"8","title":"123","type":"3","video_type":"","uid":"100131","content":"<p>项目地点：杭州<\/p><p>项目类型：平层<\/p><p>项目性质：半包<\/p><p>考虑到户型的限制，客厅飘窗不能拆改，设计师在客厅打造了一面长长的飘窗，搭配着两侧木质书架，线条简洁有力，氛围温馨宁静，让这个浅色的家处处都洋溢着通透又安静的气息，在视觉感官上似乎增加了好几十方，这个小小的改变，除了能更有效的利用整个空间面积，也让人能更接近自然一些。<img src=\"/uploads/images/20180323/1521767996740997.jpg\" title=\"1521767996740997.jpg\" alt=\"122201zf7fzi747eul19ze.jpg\"/><img src=\"/uploads/images/20180323/1521768000224722.jpg\" title=\"1521768000224722.jpg\" alt=\"123046jrry2vof1v9cqqi0.jpg\"/><\/p>","lecturer":"无","sign_number":"0","purchase_number":"0","is_charge":"0","price":"0","label":"中文,英文,汉语,中文乱码,中文乱码,中文乱码","logo":"http://tz.tuozhe8.com//uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg","like_number":"","like_count":"0","comment_count":"0","hot":"1","creatime":"1521539216","hot_time":"1522205833","is_del":"","source":"1","nick_name":"拓者大编","status":"3","share_links":"http://tz.tuozhe8.com/api.php/api8/share/details/id/7.html"},{"id":"8","catid":"2","catid2":"7","title":"123","type":"3","video_type":"","uid":"100103","content":"<p>项目地点：杭州<\/p><p>项目类型：平层<\/p><p>项目性质：半包<\/p><p>考虑到户型的限制，客厅飘窗不能拆改，设计师在客厅打造了一面长长的飘窗，搭配着两侧木质书架，线条简洁有力，氛围温馨宁静，让这个浅色的家处处都洋溢着通透又安静的气息，在视觉感官上似乎增加了好几十方，这个小小的改变，除了能更有效的利用整个空间面积，也让人能更接近自然一些。<img src=\"/uploads/images/20180323/1521767996740997.jpg\" title=\"1521767996740997.jpg\" alt=\"122201zf7fzi747eul19ze.jpg\"/><img src=\"/uploads/images/20180323/1521768000224722.jpg\" title=\"1521768000224722.jpg\" alt=\"123046jrry2vof1v9cqqi0.jpg\"/><\/p>","lecturer":"无","sign_number":"0","purchase_number":"0","is_charge":"0","price":"0","label":"中文,英文","logo":"http://tz.tuozhe8.com//uploads/images/20180408/5d83e41cd2572d5384f8868952508f5f.jpeg","like_number":"","like_count":"0","comment_count":"0","hot":"1","creatime":"1521594376","hot_time":"1522215687","is_del":"","source":"1","nick_name":"拓者大编","status":"3","share_links":"http://tz.tuozhe8.com/api.php/api8/share/details/id/8.html"}]}
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
        private List<ArticleBean> article;
        private List<VideoBean> video;

        public List<ArticleBean> getArticle() {
            return article;
        }

        public void setArticle(List<ArticleBean> article) {
            this.article = article;
        }

        public List<VideoBean> getVideo() {
            return video;
        }

        public void setVideo(List<VideoBean> video) {
            this.video = video;
        }

        public static class ArticleBean implements Serializable{
            /**
             * id : 2
             * catid : 2
             * catid2 : 1
             * title : 文章666666666
             * type : 2
             * video_type :
             * uid :
             * lecturer : 无
             * sign_number : 0
             * purchase_number : 0
             * is_charge : 0
             * price : 0
             * label : 中文,英文,汉语,中文乱码,中文乱码,中文乱码
             * logo : http://tz.tuozhe8.com//uploads/images/20180408/5d83e41cd2572d5384f8868952508f5f.jpeg
             * like_number : 59
             * like_count : 0
             * comment_count : 0
             * hot : 1
             * creatime : 1521789131
             * hot_time : 1522826985
             * is_del :
             * source : 1
             * nick_name : 拓者小编
             * status : 1
             * share_links : http://tz.tuozhe8.com/api.php/api8/share/details/id/2.html
             */

            private String id;
            private String catid;
            private String catid2;
            private String title;
            private String type;
            private String video_type;
            private String uid;
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
            private String hot;
            private String creatime;
            private String hot_time;
            private String is_del;
            private String source;
            private String nick_name;
            private String status;
            private String share_links;

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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getShare_links() {
                return share_links;
            }

            public void setShare_links(String share_links) {
                this.share_links = share_links;
            }
        }

        public static class VideoBean implements Serializable{
            /**
             * id : 7
             * catid : 4
             * catid2 : 8
             * title : 123
             * type : 3
             * video_type :
             * uid : 100131
             * content : <p>项目地点：杭州</p><p>项目类型：平层</p><p>项目性质：半包</p><p>考虑到户型的限制，客厅飘窗不能拆改，设计师在客厅打造了一面长长的飘窗，搭配着两侧木质书架，线条简洁有力，氛围温馨宁静，让这个浅色的家处处都洋溢着通透又安静的气息，在视觉感官上似乎增加了好几十方，这个小小的改变，除了能更有效的利用整个空间面积，也让人能更接近自然一些。<img src="/uploads/images/20180323/1521767996740997.jpg" title="1521767996740997.jpg" alt="122201zf7fzi747eul19ze.jpg"/><img src="/uploads/images/20180323/1521768000224722.jpg" title="1521768000224722.jpg" alt="123046jrry2vof1v9cqqi0.jpg"/></p>
             * lecturer : 无
             * sign_number : 0
             * purchase_number : 0
             * is_charge : 0
             * price : 0
             * label : 中文,英文,汉语,中文乱码,中文乱码,中文乱码
             * logo : http://tz.tuozhe8.com//uploads/images/20180408/0c3e36b69aa8c2c629ba94209986d676.jpeg
             * like_number :
             * like_count : 0
             * comment_count : 0
             * hot : 1
             * creatime : 1521539216
             * hot_time : 1522205833
             * is_del :
             * source : 1
             * nick_name : 拓者大编
             * status : 3
             * share_links : http://tz.tuozhe8.com/api.php/api8/share/details/id/7.html
             */

            private String id;
            private String catid;
            private String catid2;
            private String title;
            private String type;
            private String video_type;
            private String uid;
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
            private String hot;
            private String creatime;
            private String hot_time;
            private String is_del;
            private String source;
            private String nick_name;
            private String status;
            private String share_links;

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

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getShare_links() {
                return share_links;
            }

            public void setShare_links(String share_links) {
                this.share_links = share_links;
            }
        }
    }
}

