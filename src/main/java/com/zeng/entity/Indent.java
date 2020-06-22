package com.zeng.entity;


public class Indent {
    String create_time;
    String indent_id;
    String money;
    String goods_kind;
    String user_name;
    String user_address;
    String user_address_all;
    String user_tel;
    String address_who;
    String goods_num;

    @Override
    public String toString() {
        return "Indent{" +
                "create_time='" + create_time + '\'' +
                ", indent_id='" + indent_id + '\'' +
                ", money='" + money + '\'' +
                ", goods_kind='" + goods_kind + '\'' +
                ", user_name='" + user_name + '\'' +
                ", user_address='" + user_address + '\'' +
                ", user_address_all='" + user_address_all + '\'' +
                ", user_tel='" + user_tel + '\'' +
                ", address_who='" + address_who + '\'' +
                ", goods_num='" + goods_num + '\'' +
                ", goods_icon='" + goods_icon + '\'' +
                ", goods_price='" + goods_price + '\'' +
                '}';
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getIndent_id() {
        return indent_id;
    }

    public void setIndent_id(String indent_id) {
        this.indent_id = indent_id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getGoods_kind() {
        return goods_kind;
    }

    public void setGoods_kind(String goods_kind) {
        this.goods_kind = goods_kind;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }

    public String getUser_address_all() {
        return user_address_all;
    }

    public void setUser_address_all(String user_address_all) {
        this.user_address_all = user_address_all;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getAddress_who() {
        return address_who;
    }

    public void setAddress_who(String address_who) {
        this.address_who = address_who;
    }

    public String getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(String goods_num) {
        this.goods_num = goods_num;
    }

    public String getGoods_icon() {
        return goods_icon;
    }

    public void setGoods_icon(String goods_icon) {
        this.goods_icon = goods_icon;
    }

    public String getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(String goods_price) {
        this.goods_price = goods_price;
    }

    String goods_icon;
    String goods_price;


}
