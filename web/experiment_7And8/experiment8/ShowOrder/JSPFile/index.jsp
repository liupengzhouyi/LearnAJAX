<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="experiment_1And2.experiment2.Good" %>
<%@ page import="Tools.ReturnInformation.ReturnInformation" %>
<%@ page import="experiment_1And2.experiment2.Order" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>确认订单</title>
</head>
<body>

<%
    String goodID = request.getParameter("goodID");
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("goodID", goodID);
    ReturnInformation returnInformation = (ReturnInformation) httpSession.getAttribute("returnInformation");
    Order order = (Order) returnInformation.getObject();
%>
<h1>
    确认订单
</h1>
<hr>
<form action="/experiment_7And8/experiment8/GetOrderInformationServlet" method="post">
    <table>
        <tr>
            <th>
                用户
            </th>
            <td>
                <%=order.getGoodID()%>
            </td>
        </tr>
        <tr>
            <th>
                商品单价
            </th>
            <td>
                <%=order.getThe_unit_price()%>
            </td>
        </tr>
        <tr>
            <td>
                商品数量
            </td>
            <td>
                <%=order.getNumber()%>
            </td>
        </tr>
        <tr>
            <th>
                商品总价
            </th>
            <td>
                <%=order.getThe_total_price()%>
            </td>
        </tr>
        <tr>
            <th>
                订单创建日期
            </th>
            <td>
                <%=order.getDate()%>
            </td>
        </tr>
        <tr>
            <th>
                订单创建时间
            </th>
            <td>
                <%=order.getTime()%>
            </td>
        </tr>
        <tr>
            <th>
                <input type="submit" value="提交">
            </th>
            <td>
                <input type="reset" value="重置">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
