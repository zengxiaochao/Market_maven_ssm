package com.zeng.mapper;

import com.zeng.entity.Indent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IndentMapper {

    @Select("SELECT * FROM indent;")
    List<Indent> selectIndent();

    @Insert("INSERT INTO indent (goods_icon,user_name, create_time, indent_id, money,goods_kind ,user_address , user_address_all, user_tel, address_who, goods_num) VALUES( #{goods_icon}, #{user_name}, #{create_time}, #{indent_id}, #{money} ,#{goods_kind}, #{user_address}, #{user_address_all}, #{user_tel},#{address_who}, #{goods_num})")
    void select_Indent(Indent indent);
}
