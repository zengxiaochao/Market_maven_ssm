package com.zeng.entity;

public class Carts {
    private int user_id;
    private int goods_id;
    private int goods_num;
    private String goods_icon;
    private double goods_price;
    private String goods_name;

    @Override
    public String toString() {
        return "Carts{" +
                "user_id=" + user_id +
                ", goods_id=" + goods_id +
                ", goods_num=" + goods_num +
                ", goods_icon='" + goods_icon + '\'' +
                ", goods_price=" + goods_price +
                ", goods_name='" + goods_name + '\'' +
                '}';
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(int goods_num) {
        this.goods_num = goods_num;
    }

    public String getGoods_icon() {
        return goods_icon;
    }

    public void setGoods_icon(String goods_icon) {
        this.goods_icon = goods_icon;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
}
