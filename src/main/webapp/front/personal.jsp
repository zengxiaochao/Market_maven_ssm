<%@ page import="com.zeng.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020-04-30
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <style>
        /*body{*/
        /*    background-color: #619ac3;*/
        /*}*/
        .c1{
            width: 200px;
            height: 200px;
            border: 3px solid white;
            border-radius: 50%;
            overflow: hidden;
        }
        img{
            width: 100%;
        }
    </style>
</head>
<body>
    <div>
        <% User user = (User)session.getAttribute("user"); %>

        <center>
            <div class="c1">
                <img src=<%=user.getIcon_url()%> alt="">
            </div>
            <h1>
                <%=user.getName() %>
            </h1>

        </center>
    </div>
</body>
</html>
