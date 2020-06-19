package com.zeng.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class test {

    @RequestMapping("/admin")
    public String admin(){
        return "index";
    }

}
