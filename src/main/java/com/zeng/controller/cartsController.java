package com.zeng.controller;


import com.zeng.entity.Carts;
import com.zeng.entity.Goods;
import com.zeng.entity.User;
import com.zeng.service.CartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/carts")
public class cartsController {
    @Autowired
    private CartsService cartsService;

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



        return "redirect:/front/home.jsp";
    }

}
