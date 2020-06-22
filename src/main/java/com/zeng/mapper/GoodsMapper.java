package com.zeng.mapper;

import com.zeng.entity.Goods;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {

    /**
     * 查询所有货物
     * @return
     */
    @Select("SELECT * FROM goods;")
    List<Goods> selectGoods();

    /**
     * 查询所有货物
     * @return
     */
    @Select("SELECT * FROM goods WHERE goods_id=#{id};")
    Goods findGoodsById(int id);

    /**
     * 根据名字查找货物
     * @param name
     * @return
     */
    @Select("SELECT * FROM goods WHERE goods_name=#{name};")
    Goods findGoodsByName(String name);


    /**
     * 上下架
     * @param id
     * @return
     */
    @Update("update goods set goods_deleted=0 where goods_id=#{id}")
    boolean up_Good_By_Id(int id);
    @Update("update goods set goods_deleted=1 where goods_id=#{id}")
    boolean down_Good_By_Id(int id);
}
