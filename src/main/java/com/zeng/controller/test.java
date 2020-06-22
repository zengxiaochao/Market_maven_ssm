package com.zeng.controller;


import com.zeng.entity.Goods;
import com.zeng.service.GoodsService;
import com.zeng.service.impl.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/test")
public class test {


    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/admin")
    public String admin(){
        return "index";
    }




    @RequestMapping("/get_allGoods")
    public List<Goods> get_allGoods(){
        return goodsService.allGoods();
    }

    @RequestMapping("/ByName")
    public String ByName(String name){
        Goods goods = goodsService.find_Goods_name(name);
        return goods.getDetails_text();
    }






}
