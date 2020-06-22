<%@ page import="com.zeng.entity.Goods" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020-06-12
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/admin.css">
    <script charset="utf-8" type="text/javascript" src="../js/admin.js"></script>
    <title>管理员</title>
</head>
<body>
    <div style="float: left;width: 100%;height: 20px;background-color:azure;">
        <!--上边栏空白占位  -->

    </div>
    <div style="float: left;width: 20%;height: 1000px;background-color: aqua;">
        <!--左边栏空白占位  -->

    </div>
    <%
        session.setAttribute("sort","1");

    %>
    <div style="float: left;width: 60%;height: 1000px;">
        <table id="table1">
            <tr>
                <th colspan="5" style="text-align: center;">商品表</th>
            </tr>

            <tr>
                <td>商品名</td>
                <td>
                    <button id="th1" class="button10" style="vertical-align: middle" onclick="sort2('1')"><span>库存</span></button>
                </td>
                <td>
                    <button id="th2" class="button10" style="vertical-align: middle" onclick="sort2('2')"><span>销量</span></button>
                </td>
                <td>
                    <button id="th3" class="button10" style="vertical-align: middle" onclick="sort2('3')"><span>价格</span></button>
                </td>
                <td>
                    管理
                </td>
            </tr>
                <c:forEach items="${goodslist}" var="good">
                <tr>

                    <td name="td0">${good.goods_name}
                        <input name="product_up" value="${good.goods_id}" style="display:none">
                    </td>
                    <td name="td1">${good.num}</td>
                    <td name="td2">${good.sales}</td>
                    <td >￥<span name="td3">${good.price}</span></td>
                    <c:if test="${good.goods_deleted=='1'}">
                        <td name="td4"><button class="button12" style="background: rosybrown" onclick="up_good(${good.goods_id})">上架</button></td>
                    </c:if>
                    <c:if test="${good.goods_deleted=='0'}">
                        <td name="td4"><button class="button12" onclick="down_good(${good.goods_id})">下架</button></td>
                    </c:if>
                </tr>
                </c:forEach>
        </table>
    </div>
    <div style="float: left;width: 20%;height: 1000px;background-color: aqua;">
        <!--右边栏空白占位  -->
        <div>

            <div style="float: right;">
                <a href="../user/Logout">
                    安全退出
                </a>
            </div>
            <iframe src="../front/personal.jsp" width="100%" height="100%" frameborder="0">
            </iframe>
        </div>
    </div>
</body>
</html>
