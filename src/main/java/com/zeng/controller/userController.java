package com.zeng.controller;

import com.zeng.utils.getUserIp;
import com.zeng.entity.Address;
import com.zeng.entity.User;
import com.zeng.entity.Userlog;
import com.zeng.service.UserLogService;
import com.zeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserLogService userLogService;



    /**
     * 注册用户
     * @param session
     * @param re_name
     * @param re_pwd
     * @param re_tel
     * @param re_address
     * @param re_address_all
     * @param re_address_who
     * @param file1
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/Registered", method = RequestMethod.POST)
    public String Registered(HttpSession session,String re_name, String re_pwd, String re_tel, String re_address, String re_address_all, String re_address_who, MultipartFile file1, HttpServletRequest request) throws IOException {


        //检查同名
        if(userService.checkUser(re_name))
        {
            System.out.println("同名注册");
            session.setAttribute("error","账号已存在！！！");
            return "redirect:/index.jsp";
        }
        //上传头像
        String icon_url="./image/head.jpg";
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        MultipartFile mf = mhsr.getFile("user_icon");

        if(null != mf && mf.getSize()>0)
        {
            //存放路径
            String path = request.getSession().getServletContext().getRealPath("/");
            File path2 = new File(path+"/image/user_icon");
            if(!(path2.exists()))
            {
                path2.mkdir();
            }
            //文件名
            String hz = mf.getOriginalFilename();
            String[] hz2 = hz.split("\\.");
            if(hz2[hz2.length-1].toString().equals("jpg")||hz2[hz2.length-1].toString().equals("png"))
            {
                System.out.println(hz2[hz2.length-1].toString());
                String name = re_name+"."+hz2[hz2.length-1].toString();
                //拷贝
                mf.transferTo(new File(path2,name));
                System.out.println(name);
                icon_url = "../image/user_icon/"+name;
            }
        }
        User user = new User();
        user.setIcon_url(icon_url);
        user.setName(re_name);
        user.setPwd(re_pwd);
        user.setManager("0");
        Address address = new Address();
        address.setAddress(re_address);
        address.setAddress_all(re_address_all);
        address.setAddress_who(re_address_who);
        address.setName(re_name);
        address.setTel(re_tel);
        userService.addUser(user);
        userService.addAddress(address);


        /**
         * 写注册日志
         */
        //获取IP
        getUserIp user_Ip = new getUserIp();
        //获取时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        //新对象
        Userlog userlog = new Userlog();
        userlog.setLogin_ip(user_Ip.getIp(request));
        userlog.setLogin_time(date);
        userlog.setUser_operation("用户注册");
        userlog.setLogin_ornot("注册成功");
        userlog.setLogin_name(re_name);
        //执行写入
        userLogService.insertIndent(userlog);



        return "redirect:/index.jsp";
    }


    /**
     * 用户登录
     * @param name
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/Login")
    public String Login(String name, String pwd, HttpSession session,HttpServletRequest request)
    {
        User user = userService.getUser(name,pwd);
        Address address = userService.getAddress(name);

        /**
         * 写登陆日志
         */
        //获取IP
        getUserIp user_Ip = new getUserIp();
        //获取时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        //新对象
        Userlog userlog = new Userlog();
        userlog.setLogin_ip(user_Ip.getIp(request));
        userlog.setLogin_time(date);
        userlog.setUser_operation("用户登录");
        userlog.setLogin_name(name);



        if(user==null)
        {
            //日志操作
            userlog.setLogin_ornot("不存在该账号或密码错误");
            //执行写入
            userLogService.insertIndent(userlog);
            session.setAttribute("error","管理员账号不存在或密码错误！！！");
            return "redirect:/index.jsp";
        }
        else if(user.getManager().equals("1"))
        {
            //日志操作
            userlog.setLogin_ornot("不是用户身份");
            //执行写入
            userLogService.insertIndent(userlog);
            session.setAttribute("error","管理员账号不存在或密码错误！！！");
            return "redirect:/index.jsp";
        }
        else {
            //日志操作
            userlog.setLogin_ornot("用户登陆成功");
            //执行写入
            userLogService.insertIndent(userlog);
            session.setAttribute("user",user);
            session.setAttribute("address",address);
            return "redirect:/goods/home";
        }
    }

    /**
     * 管理员登陆
     * @param name
     * @param pwd
     * @param session
     * @return
     */
    @RequestMapping("/mLogin")
    public String mLogin(String name, String pwd, HttpSession session,HttpServletRequest request)
    {
        User user = userService.getUser(name,pwd);


        /**
         * 写登陆日志
         */
        //获取IP
        getUserIp user_Ip = new getUserIp();
        //获取时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        //新对象
        Userlog userlog = new Userlog();
        userlog.setLogin_ip(user_Ip.getIp(request));
        userlog.setLogin_time(date);
        userlog.setUser_operation("管理员登陆");
        userlog.setLogin_name(name);


        if(user==null)
        {
            //日志操作
            userlog.setLogin_ornot("管理员账号不存在或密码错误");
            //执行写入
            userLogService.insertIndent(userlog);
            session.setAttribute("error","管理员账号不存在或密码错误！！！");
            return "redirect:/index.jsp";
        }
        else if(user.getManager().equals("0"))
        {
            //日志操作
            userlog.setLogin_ornot("管理员身份不符");
            //执行写入
            userLogService.insertIndent(userlog);
            session.setAttribute("error","管理员账号不存在或密码错误！！！");
            return "redirect:/index.jsp";
        }
        else {
            //日志操作
            userlog.setLogin_ornot("管理员登陆成功");
            //执行写入
            userLogService.insertIndent(userlog);
            session.setAttribute("user",user);
            return "redirect:/goods/manage";
        }
    }

    /**
     * 安全退出
     * @param session
     * @return
     */
    @RequestMapping("/Logout")
    public String mLogout(HttpSession session,HttpServletRequest request)
    {
        User user = (User) session.getAttribute("user");
        /**
         * 写登陆日志
         */
        //获取IP
        getUserIp user_Ip = new getUserIp();
        //获取时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        //新对象
        Userlog userlog = new Userlog();
        userlog.setLogin_ip(user_Ip.getIp(request));
        userlog.setLogin_time(date);
        userlog.setUser_operation("安全退出");
        userlog.setLogin_name(user.getName());
        //日志操作
        userlog.setLogin_ornot("退出成功");
        //执行写入
        userLogService.insertIndent(userlog);


        session.invalidate();
        return "redirect:/index.jsp";
    }
}
