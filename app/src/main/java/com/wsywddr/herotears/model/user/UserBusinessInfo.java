package com.wsywddr.herotears.model.user;

/**
 * Created by fengxiang on 2016/3/25.
 */
public class UserBusinessInfo {

    private String id;
    private String uid;
    private String business_type;
    private String status;//0 待审核 1 审核通过 2 审核不通过
    private String appid;
    private String addtime;
    private String title;//店铺名称
    private String name;//店铺联系人
    private String tel;//店铺联系电话
    private String zhizhao;
    private String bg_img;
    private String avatar;

    private String big_cate_name;
    private String small_cate_name;
    private String shop_address;

    private String business_id;
    private String bussiness_name;
    private String area_id;
    private String area_name;

    public String getBig_cate_name() {
        return big_cate_name;
    }

    public void setBig_cate_name(String big_cate_name) {
        this.big_cate_name = big_cate_name;
    }

    public String getSmall_cate_name() {
        return small_cate_name;
    }

    public void setSmall_cate_name(String small_cate_name) {
        this.small_cate_name = small_cate_name;
    }

    public String getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(String business_id) {
        this.business_id = business_id;
    }

    public String getBussiness_name() {
        return bussiness_name;
    }

    public void setBussiness_name(String bussiness_name) {
        this.bussiness_name = bussiness_name;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public String getShop_address() {
        return shop_address;
    }

    public void setShop_address(String shop_address) {
        this.shop_address = shop_address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(String business_type) {
        this.business_type = business_type;
    }


    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getZhizhao() {
        return zhizhao;
    }

    public void setZhizhao(String zhizhao) {
        this.zhizhao = zhizhao;
    }

    public String getBg_img() {
        return bg_img;
    }

    public void setBg_img(String bg_img) {
        this.bg_img = bg_img;
    }


    @Override
    public String toString() {
        return "UserBusinessInfo{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", business_type='" + business_type + '\'' +
                ", status='" + status + '\'' +
                ", appid='" + appid + '\'' +
                ", addtime='" + addtime + '\'' +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", zhizhao='" + zhizhao + '\'' +
                ", bg_img='" + bg_img + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}
