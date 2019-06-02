<%@ page import="experiment_1And2.experiment2.Good" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看商品</title>
</head>
<body>
    <%
        HttpSession httpSession = request.getSession();
        List<Good> list = (List<Good>) httpSession.getAttribute("list");
    %>
    <h1>
        所有商品
    </h1>
    <hr>
    <table>
        <tr>
            <th>
                商品名称
            </th>
            <th>
                商品价格
            </th>
            <th>
                商品原产地
            </th>
            <th>
                生产日期
            </th>
            <th>
                保质期
            </th>
            <th>
                上架日期
            </th>
        </tr>
    <%
        if (list.isEmpty()) {
            System.out.println("没有获取信息");
        }
        if (list.size() == 0) {
            System.out.println("没有获取信息");
        }
        for (Good good : list) {
    %>
            <tr>

                <td>
                    <a href="<%=good.getGoodID()%>">
                        <%=good.getGoodName()%>
                    </a>
                </td>
                <td>
                    <%=good.getGoodPrice()%>
                </td>
                <td>
                    <%=good.getGoodPrice()%>
                </td>
                <td>
                    <%=good.getGoodRigin()%>
                </td>
                <td>
                    <%=good.getProductData()%>
                </td>
                <td>
                    <%=good.getMonthNumber()%>
                </td>
                <td>
                    <%=good.getShelvesDate()%>
                </td>
            </tr>
    <%
        }
    %>
    </table>
</body>
</html>
