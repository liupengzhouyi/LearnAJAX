<%@ page import="experiment_1And2.experiment2.Good" %>
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
    <title>添加订单</title>
</head>
<body>

<%
    String goodID = request.getParameter("goodID");
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("goodID", goodID);
    ReturnInformation returnInformation = (ReturnInformation) httpSession.getAttribute("returnInformation");
    Good good = (Good) returnInformation.getObject();
    if (good.equals(null)) {
        System.out.println("abc");
    } else {
        %>
<h1>
    创建订单《Bug : 显示俩次》
</h1>
<hr>
<form action="/experiment_7And8/experiment8/GetOrderInformationServlet" method="post">
    <table>
        <tr>
            <th>
                商品名称
            </th>
            <td>
                <%=good.getGoodName()%>
            </td>
        </tr>
        <tr>
            <th>
                商品单价
            </th>
            <td>
                <%=good.getGoodPrice()%>
            </td>
        </tr>
        <tr>
            <th>
                商品单价
            </th>
            <td>
                <%=good.getGoodPrice()%>
            </td>
        </tr>
        <tr>
            <td>
                商品数量
            </td>
            <td>
                <input type="number" name="liupengGoodNumbers">
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
<%
    }
%>
</body>
</html>
