package com.zeng.mapper;

import com.zeng.entity.Carts;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartsMapper {

    @Insert("INSERT INTO carts (user_id, goods_id, goods_name, goods_num,goods_icon,goods_price) VALUES(#{user_id}, #{goods_id}, #{goods_name}, #{goods_num}, #{goods_icon}, #{goods_price})")
    void insert_Carts(Carts carts);


    @Select("SELECT * FROM carts WHERE user_id=#{id};")
    List<Carts> allMyCarts(int id);


    @Delete("delete from carts where user_id = #{user_id} AND goods_name = #{carts_name};")
    void deCarts(@Param("user_id")int user_id, @Param("carts_name")String carts_name);


    @Delete("delete from carts where user_id = #{user_id};")
    void allBuyEd(int user_id);
}
