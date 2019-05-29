<%@ page import="experiment_1And2.experiment2.Good" %>
<%@ page import="experiment_1And2.experiment2.Order" %>
<%@ page import="experiment_1And2.experiment2.User" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP EL级联读取JavaBean对象的属性值</title>
    <link type="text/css" href="../CSSFile/index.css" rel="stylesheet">
</head>
<body>
<%
    Good good = new Good("default");
    Order order = new Order("default");
    User user = new User("default");
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("good", good);
    httpSession.setAttribute("order", order);
    httpSession.setAttribute("user", user);
%>
<h2>
    JSP EL级联读取JavaBean对象的属性值
</h2>

<h3>
    商品类
</h3>

<hr>

商品编号:${good.goodID}
<br>
商品原产地:${good.goodRigin}
<br>
商品价格:${good.goodPrice}
<br>
商品名称:${good.goodName}
<br>
上架日期:${good.shelvesDate}
<br>
保质期:${good.monthNumber}
<br>
生产日期:${good.productData}
<br>
下架日期:${good.eliminateDate}
<br>
是否下架:${good.key}

<h3>
    用户类
</h3>
<hr>

用户ID：${user.userID}
<br>
用户名：${user.userName}
<br>
用户密码：${user.passwordValue}
<br>
用户注册日期：${user.registeredDate}
<br>
用户余额：${user.money}


<h3>
    订单类
</h3>
<hr>

订单编号：${order.orderID}
<br>
用户编号: ${order.orderID}
<br>
商品数量: ${order.number}
<br>
单价: ${order.the_unit_price}
<br>
总价: ${order.the_total_price}
<br>
日期: ${order.date}
<br>
时间: ${order.time}

</body>
</html>
