<%@ page import="experiment_1And2.experiment2.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="Tools.ReturnInformation.ReturnInformation" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>留言板分页显示</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    ReturnInformation returnInformation = (ReturnInformation) httpSession.getAttribute("returnInformation");
    List<Order> list = (List<Order>) returnInformation.getObject();
%>
<table>
    <tr>
        <th>
            用户
        </th>
        <th>
            商品单价
        </th>
        <td>
            商品数量
        </td>
        <th>
            商品总价
        </th>
        <th>
            订单创建日期
        </th>
        <th>
            订单创建时间
        </th>
    </tr>
<%
    for (Order order:list) {
        %>

    <tr>
        <td>
            <%=order.getGoodID()%>
        </td>
        <td>
            <%=order.getThe_unit_price()%>
        </td>
        <td>
            <%=order.getNumber()%>
        </td>
        <td>
            <%=order.getThe_total_price()%>
        </td>
        <td>
            <%=order.getDate()%>
        </td>
        <td>
            <%=order.getTime()%>
        </td>
    </tr>

<%
    }
%>

    <a href="/experiment_11And12/experiment11/GetOrderAndPagingShowServlet">下一页</a>
</table>
</body>
</html>
