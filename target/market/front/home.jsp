<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020-04-27
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<link id="css" rel="stylesheet" type="text/css" href="../css/index.css"  />
<script charset="utf-8" type="text/javascript" src="../js/index.js"></script>
<html>
  <head>
    <title>零食商城</title>
      <script>
          function click_line()
          {
              var goods_name = arguments[0];
              // alert(goods_name.toString());
              var href = "../goods/Details?name="+goods_name.toString();
              window.location.href = href;
          }
      </script>
  </head>
  <body>
    <div style="width: 100%;height: 100%;">

      <div style="float: left;width: 100%;height: 100px;background-color: ivory;">
        <img src="../image/公告.jpg" alt="" style="width: 100%;height: 100px;">
      </div>

      <div style="float: left;width: 20%;height: 1000px;background-color: aqua;">
        <!--左边栏空白占位  -->
      </div>
      <div style="float: left;width: 60%;height: 1000px;">
        <!-- <div style="float: left;width: 100%;height: 80px;text-align:center;">
            <h1>零食选购</h1>
        </div> -->
        <div style="float: left;width: 2%;height: 1000px;">

        </div>
        <!-- 零食卡片 -->
        <div style="float: left;width: 98%;height: 1000px;">
            <c:forEach items="${goodslist}" var="good">
                <c:if test="${good.goods_deleted=='0'}">
                    <div class="cardBox" onclick="click_line('${good.goods_name}')">
                      <div class="headerBox" style="background-image: url(${good.icon_url});">
    <%--                    <p><%=g.getGoods_name() %></p>--%>
                      </div>
                      <div class="bodyBox" >
                        <p>${good.goods_name}</p>
                        <p>销量：${good.sales}</p>
                        <p>库存：<span style="color:green">${good.num}</span></p>
                        <p>价格：￥${good.price}</p>
                      </div>
                    </div>
                </c:if>
            </c:forEach>
        </div>
      </div>

      <div style="float: left;width: 20%;height: 1000px;background-color: hotpink;text-align:center;">
        <!--右边栏  -->
        <center>
<%--            <iframe frameborder="no" border="0" marginwidth="0" marginheight="0" width=298 height=52 src="//music.163.com/outchain/player?type=2&id=1456493780&auto=0&height=32">--%>

<%--            </iframe>--%>
            <div>
                <div style="">
                    <a href="../carts/myCarts" >
                        购物车
                    </a>
                    <a href="../indent/All" >
                        查询我的订单
                    </a>
                    <a href="../user/Logout">
                        注销
                    </a>
                </div>
                <iframe src="./personal.jsp" width="100%" height="100%" frameborder="0">

                </iframe>
            </div>
        </center>
      </div>
    </div>
  </body>
</html>
