package com.zeng.controller;


import com.zeng.entity.*;
import com.zeng.service.CartsService;
import com.zeng.service.GoodsService;
import com.zeng.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/carts")
public class cartsController {
    @Autowired
    private CartsService cartsService;
    @Autowired
    private IndentService indentService;
    @Autowired
    private GoodsService goodsService;


    /**
     * 增加购物车
     * @param model
     * @param session
     * @param buy_num
     * @return
     */

    @RequestMapping("/newCarts")
    public String newCarts(Model model, HttpSession session,String buy_num,String all_price){
        Carts carts = new Carts();
        Goods goods = (Goods) session.getAttribute("goods");
        User user = (User) session.getAttribute("user");

        carts.setGoods_id(goods.getGoods_id());
        carts.setGoods_name(goods.getGoods_name());
        carts.setGoods_num(Integer.parseInt(buy_num));
        carts.setGoods_price(goods.getPrice());
        carts.setGoods_icon(goods.getIcon_url());
        carts.setUser_id(user.getId());

        cartsService.insertCarts(carts);
        return "redirect:/front/home.jsp";
    }

    /**
     * 查询购物车
     */
    @RequestMapping("/myCarts")
    public String myCarts(Model model, HttpSession session){

        User user = (User) session.getAttribute("user");
        List<Carts> carts = cartsService.selectCart(user.getId());
        session.setAttribute("cartsList",carts);
        return "redirect:/front/carts.jsp";
    }
    /**
     * 查询购物车
     */
    @RequestMapping("/deleteCarts")
    public String deleteCarts(Model model, HttpSession session,String carts_name,int user_id){

//        User user = (User) session.getAttribute("user");
        cartsService.deleCarts(user_id,carts_name);
        List<Carts> carts = cartsService.selectCart(user_id);
        session.setAttribute("cartsList",carts);
        return "redirect:/front/carts.jsp";
    }
    /**
     * 查询购物车
     */
    @RequestMapping("/buyAll")
    public String buyAll(Model model, HttpSession session){

        User user = (User) session.getAttribute("user");
        List<Carts> list = cartsService.selectCart(user.getId());
        Address address = (Address) session.getAttribute("address");


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        long time = System.currentTimeMillis();
        String indent_id = String.valueOf(time);
        Indent indent = new Indent();
        indent.setCreate_time(date);
        indent.setIndent_id(indent_id);
        indent.setUser_tel(address.getTel());
        indent.setUser_name(address.getName());
        indent.setAddress_who(address.getAddress_who());
        indent.setUser_address_all(address.getAddress_all());
        indent.setUser_address(address.getAddress());

        for (Carts carts:list) {
            String goods_name = carts.getGoods_name();
            Goods goods = goodsService.find_Goods_name(goods_name);

            indent.setMoney(goods.getPrice()*carts.getGoods_num());
            indent.setGoods_kind(goods_name);
            indent.setGoods_num(carts.getGoods_num());
            indent.setGoods_icon(goods.getIcon_url());
            indentService.insertIndent(indent);
        }
        cartsService.all_buy(user.getId());
        return "redirect:/front/home.jsp";
    }


}
