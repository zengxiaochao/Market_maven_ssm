<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: Z
  Date: 2020-05-14
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>提交订单</title>
    <link id="css" rel="stylesheet" type="text/css" href="../css/indent.css"  />
</head>
<body>
<form action="../indent/CreateIndent" method="post">
    <div class="Caddress">
        <div class="add_mi">
            <p style="border-bottom:1px dashed #ccc;line-height:28px;"><span>${address.address}</span>(<span>${address.address_who}</span>收)</p>
            <p><span>${address.address_all}</span> <span>${address.tel}</span></p>

        </div>
    </div>

    <div class="shopping_content">

            <div class="shopping_table">
                <table border="1" bordercolor="#cccccc" cellspacing="0" cellpadding="0" style="width: 100%; text-align: center;">
                    <tr>
                        <th>商品图片</th>
                        <th>商品名称</th>
                        <th>商品价格</th>
                        <th>商品数量</th>
                    </tr>
                    <tr>
                        <td>
                            <a><img src=${goods.icon_url} /></a>
                        </td>
                        <td><span><input class="momey_input" style="width: 90px" name="goods_name" value="${goods.goods_name}" readonly="readonly" ></span></td>

                        <td>
                            <span class="span_momey">
                                <input class="momey_input" name="every_price" value="${goods.price}" readonly="readonly" >
                                </span>
                        </td>

                        <td>
                            <input class="momey_input" type="" name="buy_num" value="${param.buy_num}" readonly="readonly" >
                        </td>

                    </tr>


                </table>
                <div class="" style="width: 100%; text-align: right; margin-top: 10px;">
                    <div class="div_outMumey" style="float: left;">
                        总价：￥<span class="out_momey" ><input class="momey_input" name="prize" value="${param.all_prize}" readonly="readonly" >${param.all_prize}</span>
                    </div>
                    <button class="btn_closing" type="submit">结算</button>
                </div>

            </div>

    </div>
    <input style="display:none" name="every_icon" value="${goods.icon_url}">
</form>
</body>
</html>
