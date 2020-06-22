package com.zeng.service;

import com.zeng.entity.Goods;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<Goods> allGoods();
    Goods find_Goods_name(String name);
    Goods find_Goods_Id(int id);
    boolean up_Goods(int id);
    boolean down_Goods(int id);

}
