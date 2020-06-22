<%@ page import="com.zeng.entity.Goods" %>
<%@ page import="com.zeng.mapper.GoodsMapper" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020-06-11
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的订单</title>
    <link id="css" rel="stylesheet" type="text/css" href="../css/myindent.css"  />
</head>
<body>

    <div style="width: 100%;height: 100%;">
        <div style="float: left;width: 100%;height: 100px;background-color: grey;">
            <%--            页面上方留白--%>
        </div>
        <div style="float: left;width: 20%;height: 1000px;background-color: aqua;">
            <!--左边栏空白占位  -->
            <a href="home.jsp" class="button2" style="background: gold;
                border: 1px solid greenyellow;
                text-decoration: none;
                display: inline-block;
                padding: 10px 22px;
                border-radius: 20px;">返回主页</a>
        </div>
        <div style="float: left;width: 60%;height: 1000px;">

            <c:forEach items="${indentlist}" var="indent">
                <br><br>
                <div class="orderList normal">
                    <div class="title">
                        <p class="orderNum">
                            订单号：
                            <span>${indent.indent_id}</span>
                        </p>
                        <p class="orderTime">
                            下单时间：
                            <span>${indent.create_time}</span>
                        </p>
                        <p class="orderTime">
                            订单状态：<span style="color: #c40000">未支付</span>
                        </p>
                    </div>
                    <ul class="orderInfo">

                        <c:set value="${fn:split(indent.goods_kind, ' ')}" var="goods_li" />
                        <c:set value="${fn:split(indent.goods_num, ' ')}" var="num_li" />
                        <c:set value="${fn:split(indent.goods_price, ' ')}" var="price_li" />
                        <c:set value="${fn:split(indent.goods_icon, ' ')}" var="icon_li" />
                        <c:forEach items="${goods_li}"  varStatus="i" var="goods_l">
                            <li>
                                <img src=${icon_li[i.index]} />
                                <div class="info">
                                    <p class="productName">
                                            ${goods_li[i.index]}
                                    </p>
                                    <p class="count">
                                            <span class="unitPrice">
                                                        &yen;${price_li[i.index]}
                                                    </span>
                                        <span class="number">
                                                        &times;${num_li[i.index]}
                                                    </span>
                                    </p>
                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                    <div class="orderPrice clearfix">
                        <div class="detail">
                            <p class="amount">
                                订单金额：
                                <span>
                                                &yen;${indent.money}
                                </span>
                            </p>
                        </div>

                    </div>
                </div>
            </c:forEach>
        </div>
        <div style="float: left;width: 20%;height: 1000px;background-color: hotpink;">
        </div>
    </div>


</body>
</html>
