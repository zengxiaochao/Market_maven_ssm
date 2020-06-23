<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020-06-23
  Time: 07:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>购物车</title>
    <script src="../js/carts.js"></script>
    <link rel="stylesheet" href="../css/carts.css">
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
            <table>
                <thead>
                <tr>
                    <th class="tdone">序号</th>
                    <th class="tdtwo">商品名称</th>
                    <th class="tdthree">数量</th>
                    <th class="tdfour">单价</th>
                    <th class="tdfive">小计</th>
                    <th class="tdsix">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:set value="0" var="sum_price" />
                <c:set value="0" var="sum_num" />
                <c:forEach items="${cartsList}" var="carts" varStatus="i">
                    <tr class="trclass">
                        <td class="tdone xuhao">${i.index+1}</td>
                        <td class="tdtwo " id="carts_name">${carts.goods_name}</td>
                        <td class="tdthree"><span class="jiajie"><input type="button" value="-" style="display: none"><span class="num">${carts.goods_num}</span><input type="button" value="+" style="display: none"></span>
                        </td>
                        <td class="tdfour"><span>单价：</span><span class="unit">${carts.goods_price}</span></td>
                        <td class="tdfive"><span>小计：</span><span class="subtal">${carts.goods_price*carts.goods_num}</span></td>
                        <td class="tdsix"><button onclick="deleteCarts()">移出购物车</button></td>
                    </tr>
                    <c:set value="${sum_price + (carts.goods_price*carts.goods_num)}" var="sum_price" />
                    <c:set value="${sum_num + carts.goods_num}" var="sum_num" />

                </c:forEach>
                    <tr>
                        <td colspan="6" ; class="talast"><span>商品一共 <span class="allgoods_num">${sum_num}</span> 件; 共计花费 <span class="pricetal">${sum_price}</span> 元</span>
                            &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
                            <button class="button8" onclick="buyall()">    去结算==》</button>

                        </td>
                    </tr>

                </tbody>

            </table>

        </div>
        <input value="${user.id}" style="display: none" id="user_id">
        <div style="float: left;width: 20%;height: 1000px;background-color: hotpink;">
        </div>
    </div>
</body>
<style>
    .button8 {
        border: none;
        background: dodgerblue;
        padding: 13px 18px;
        margin-top: 20px;
        transition-duration: 0.6s;
    }

    .button8:hover {
        box-shadow: 0 12px 16px 0 rgba(0, 255, 0, 0.24), 0 17px 50px 0 rgba(0, 0, 255, 0.19);
    }

</style>

</html>