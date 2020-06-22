package com.zeng.service.impl;

import com.zeng.entity.Goods;
import com.zeng.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;



@Service
public class GoodsServiceImpl implements com.zeng.service.GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    /**
     * 查询所有货物
     * @return
     */
    @Override
    public List<Goods> allGoods() {
        return goodsMapper.selectGoods();
    }

    /**
     * 根据名字查询货物
     * @return
     */
    @Override
    public Goods find_Goods_name(String name) {
        return goodsMapper.findGoodsByName(name);
    }

    /**
     * 根据ID查找
     * @param id
     * @return
     */
    @Override
    public Goods find_Goods_Id(int id){
        return goodsMapper.findGoodsById(id);
    }

    /**
     * 上架
     * @param id
     * @return
     */
    @Override
    public boolean up_Goods(int id) {
        return goodsMapper.up_Good_By_Id(id);
    }

    /**
     * 下架
     * @param id
     * @return
     */
    @Override
    public boolean down_Goods(int id) {
        return goodsMapper.down_Good_By_Id(id);
    }


}
