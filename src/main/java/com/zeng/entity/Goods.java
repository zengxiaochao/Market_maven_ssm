package com.zeng.entity;

public class Goods {
    private int goods_id;
    private int num;//库存
    private int sales;//销量
    private double price;//价格
    private String goods_deleted;
    private String goods_name;//名字
    private String icon_url;//图
    private String details_text;//详情
    private String details_img_url;//详情图
    private String spec;//规格

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", num=" + num +
                ", sales=" + sales +
                ", price=" + price +
                ", goods_deleted='" + goods_deleted + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", icon_url='" + icon_url + '\'' +
                ", details_text='" + details_text + '\'' +
                ", details_img_url='" + details_img_url + '\'' +
                ", spec='" + spec + '\'' +
                '}';
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getGoods_deleted() {
        return goods_deleted;
    }

    public void setGoods_deleted(String goods_deleted) {
        this.goods_deleted = goods_deleted;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getIcon_url() {
        return icon_url;
    }

    public void setIcon_url(String icon_url) {
        this.icon_url = icon_url;
    }

    public String getDetails_text() {
        return details_text;
    }

    public void setDetails_text(String details_text) {
        this.details_text = details_text;
    }

    public String getDetails_img_url() {
        return details_img_url;
    }

    public void setDetails_img_url(String details_img_url) {
        this.details_img_url = details_img_url;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }
}
