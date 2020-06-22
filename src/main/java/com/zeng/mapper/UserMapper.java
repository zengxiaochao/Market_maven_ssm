package com.zeng.mapper;

import com.zeng.entity.Address;
import com.zeng.entity.Goods;
import com.zeng.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {


    /**
     * 查询用户
     */
    @Select("SELECT * FROM user WHERE name=#{name} AND pwd = #{pwd};")
    User Login(@Param("name")String name,@Param("pwd")String pwd);


    /**
     * 同名查询
     * @param re_name
     * @return
     */
    @Select("SELECT * FROM user WHERE name=#{re_name};")
    User checkU(String re_name);

    /**
     * 注册用户
     * @param user
     */
    @Insert("INSERT INTO user (name, pwd, icon_url, manager) VALUES(#{name}, #{pwd}, #{icon_url}, #{manager})")
    void AddUser(User user);

    /**
     *注册地址
     * @param address
     */
    @Insert("INSERT INTO imf (name , address, tel, address_all, address_who) VALUES(#{name}, #{address}, #{tel}, #{address_all}, #{address_who})")
    void AddAddress(Address address);


    @Select("SELECT * FROM imf WHERE name=#{name};")
    Address Get_Address(String name);
}
