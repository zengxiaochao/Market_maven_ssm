package com.zeng.controller;


import com.zeng.entity.Goods;
import com.zeng.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class goodsController {

    @Autowired
    private GoodsService goodsService;


    /**
     * 查找全部商品
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/home")
    public String home(Model model, HttpSession session){
        session.setAttribute("goodslist",goodsService.allGoods());
        return "redirect:/front/home.jsp";
    }
    @RequestMapping("/manage")
    public String get_allGoods(Model model){
        model.addAttribute("goodslist", goodsService.allGoods());
        return "admin/admin.jsp";
    }


    /**
     * 通过名字查商品
     * @param name
     * @return
     */
    @RequestMapping("/Details")
    public String ByName(@RequestParam(value = "name",defaultValue = "卫龙") String name,HttpSession session){
        session.setAttribute("goods",goodsService.find_Goods_name(name));
        return "redirect:/front/details.jsp";
    }

    /**
     * 通过id查商品
     * @param id
     * @return
     */
    @RequestMapping("/ById")
    public String ById(@RequestParam(value = "id",defaultValue = "1") int id){
        Goods goods = goodsService.find_Goods_Id(id);
        System.out.println(goods);
        return "front/details.jsp?name="+id;
    }


    /**
     * 上下架
     * @param id
     * @return
     */
    @RequestMapping("/Up")
    public String Up(int id){
        boolean re = goodsService.up_Goods(id);
        System.out.println(re);
        return "redirect:/goods/manage";
    }
    @RequestMapping("/Down")
    public String Down(int id){
        boolean re = goodsService.down_Goods(id);
        System.out.println(re);
        return "redirect:/goods/manage";
    }

    /**
     * 新建商品
     */




    /**
     * 删除商品
     */



}
