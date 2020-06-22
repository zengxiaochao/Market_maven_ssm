<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false" %>
<script charset="utf-8" type="text/javascript" src="./js/index.js"></script>
<style>
    input{
        outline-style: none ;
        border: 1px solid #ccc;
        border-radius: 3px;
        padding: 13px 14px;
        width: 620px;
        font-size: 14px;
        font-weight: 700;
        font-family: "Microsoft soft";
    }
    .button11 {
        position: relative;
        /*必须添上这一句，否则波纹布满整个页面*/
        background: dodgerblue;
        border: none;
        color: white;
        width: 180px;
        font-size: 16px;
        /*可以通过字体控制button大小*/
        padding: 20px;
        border-radius: 12px;
        transition-duration: 0.4s;
        overflow: hidden;
        outline-style: none;
        /*去除点击时外部框线*/
    }

    .button11:after {
        content: "";
        background: aquamarine;
        opacity: 0;
        display: block;
        position: absolute;
        padding-top: 300%;
        padding-left: 350%;
        margin-left: -20px!important;
        margin-top: -120%;
        transition: all 0.5s;
    }

    .button11:active:after {
        padding: 0;
        margin: 0;
        opacity: 1;
        transition: 0.1s;
    }
</style>
<html>
<body background="image/background.jpg">

<div style="text-align:center;width: 100%;height: 350px;">

</div>
<div style="text-align:center;width: 45%;height: 100%;">



    <button class="button11" onclick="displayWindow2()">我是用户</button>
    <br>
    <br>
    <br>
    <button class="button11" onclick="displayWindow3()">我是管理员</button>
    <br>
    <br>
    <br>
    <button onclick="displayWindow()" class="button11">注&emsp;册</button>

</div>

    <%--用户登录弹窗--%>
    <div id="window2" class="window_css" style="text-align:center;">
        <br><br><h1>用户登陆</h1>
        <br><br><br>
        <form action="user/Login" method="POST">
            <input type="text" name="name"><br>
            <input type="password" name="pwd"><br><br>
            <button type="submit" class="button11">登&emsp;陆</button>
        </form>
        <button onclick="hideWindow2()" class="button11">取&emsp;消</button>
    </div>



    <%--管理员登陆弹窗--%>
    <div id="window3" class="window_css" style="text-align:center;">
        <br><br><h1>管理员登陆</h1>
        <br><br><br>
        <form action="user/mLogin" method="POST">
            <input type="text" name="name"><br>
            <input type="password" name="pwd"><br><br>
            <button type="submit" class="button11">登&emsp;陆</button>
        </form>
        <button onclick="hideWindow3()" class="button11">取&emsp;消</button>
    </div>
    <br><br><br>




<%--  注册弹窗--%>
    <!--悬浮窗口 -->
    <div id="window" class="window_css" style="text-align:center;">
        <h1>用户注册</h1>
        <form action="user/Registered"  method="post" onSubmit="return zhuce(this)" enctype="multipart/form-data">
            账&emsp;&emsp;号：<input type="text" placeholder="请输入账号" name="re_name"><br><br>
            密&emsp;&emsp;码：<input type="password" placeholder="请输入密码" name="re_pwd"><br><br>
            确认密码：<input type="password" placeholder="请确认密码" name="re_rpwd"><br><br>
            电话号码：<input type="text" placeholder="请输入电话号码" name="re_tel"><br><br>
            所在省份：<input type="text" placeholder="请输入你的地址" name="re_address"><br><br>
            详细地址：<input type="text" placeholder="请输入详细收件地址" name="re_address_all"><br><br>
            快递收件人：<input type="text" placeholder="请输入快递收件人" name="re_address_who"><br><br>
            <%--上传头像--%>
            头像上传：<input type="file" name="user_icon" id="user_icon"><br><br>
            <button type="submit" class="button11">提交注册</button>
        </form>
        <button onclick="hideWindow()" class="button11">取&emsp;消</button>
    </div>
    <!--出现悬浮窗口后,背景变暗-->
    <div id="shadow" class="shadow_css"></div>


</body>

<script type="text/javascript">
    function zhuce(form) {
        if(form.re_name.value==""){
            alert("账号不能为空！！");
            form.re_name.focus();
            return false;
        }
        if(form.re_pwd.value==""){
            alert("密码不能为空！！");
            form.re_pwd.focus();
            return false;
        }
        if(form.re_rpwd.value==""){
            alert("请输入两次密码！！");
            form.re_rpwd.focus();
            return false;
        }
        if(form.re_tel.value==""){
            alert("电话不能为空！！");
            form.re_tel.focus();
            return false;
        }
        if(form.re_address.value==""){
            alert("地址不能为空！！");
            form.re_address.focus();
            return false;
        }
        if(form.re_address_all.value==""){
            alert("详细地址不能为空！！");
            form.re_address_all.focus();
            return false;
        }
        if(form.re_address_who.value==""){
            alert("收件人不能为空！！");
            form.re_address_who.focus();
            return false;
        }
        if(form.re_pwd.value!=form.re_rpwd.value){
            alert("两次输入密码不同！！");
            form.re_rpwd.focus();
            return false;
        }
    }
</script>




<%--  /*注册弹窗的样式*/--%>
<style>
    .shadow_css {
        display: none;
        position: absolute;
        top: 0%;
        left: 0%;
        width: 100%;
        height: 150%;
        background-color: black;
        z-index: 10;
        /* 为mozilla firefox 设置透明度  */
        -moz-opacity: 0.6;
        /* 设置透明度 */
        opacity: .60;
        /* 为IE 设置透明度  */
        filter: alpha(opacity=66);
    }

    .window_css {
        display: none;
        position: absolute;
        top: 20%;
        left: 25%;
        width: 50%;
        height: 70%;
        border: 3px solid honeydew;
        background-color: aliceblue;
        z-index: 11;
    }
</style>
</html>
