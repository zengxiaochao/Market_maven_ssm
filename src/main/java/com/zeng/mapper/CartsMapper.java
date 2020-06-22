package com.zeng.mapper;

import com.zeng.entity.Carts;
import org.apache.ibatis.annotations.Insert;

public interface CartsMapper {

    @Insert("INSERT INTO carts (user_id, goods_id, goods_name, goods_num,goods_icon,goods_price) VALUES(#{user_id}, #{goods_id}, #{goods_name}, #{goods_num}, #{goods_icon}, #{goods_price})")
    void insert_Carts(Carts carts);
}
