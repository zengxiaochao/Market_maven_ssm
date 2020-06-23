package com.zeng.controller;



import com.zeng.entity.Address;
import com.zeng.entity.Goods;
import com.zeng.entity.Indent;
import com.zeng.service.GoodsService;
import com.zeng.service.IndentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/indent")
public class indentController {

    @Autowired
    private IndentService indentService;

    @RequestMapping("/All")
    public String All(String name, HttpSession session)
    {
        List<Indent> indents = indentService.allIndent();
        System.out.println(indents);
        session.setAttribute("indentlist",indents);
        return "redirect:/front/myindent.jsp";
    }
    @RequestMapping("/CreateIndent")
    public String newIndent(String goods_name, int buy_num,double prize,String every_price,String every_icon, HttpSession session)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        long time = System.currentTimeMillis();
        String indent_id = String.valueOf(time);

        Address address = (Address) session.getAttribute("address");
        Indent indent = new Indent();
        indent.setMoney(prize);
        indent.setGoods_kind(goods_name);
        indent.setCreate_time(date);
        indent.setIndent_id(indent_id);
        indent.setUser_tel(address.getTel());
        indent.setUser_name(address.getName());
        indent.setUser_address_all(address.getAddress_all());
        indent.setUser_address(address.getAddress());
        indent.setAddress_who(address.getAddress_who());
        indent.setGoods_num(buy_num);
        indent.setGoods_icon(every_icon);
        indentService.insertIndent(indent);
        return "redirect:/front/home.jsp";
    }













}
