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
    <title>操作成功页面</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    ReturnInformation returnInformation = (ReturnInformation) httpSession.getAttribute("returnInformation");
%>
    <h1>
        操作成功
    </h1>
    <hr>

    <h2>
        信息
    </h2>
    <table>
        <tr>
            <th>
                信息
            </th>
            <td>
                <%=returnInformation.getMassage()%>
            </td>
        </tr>
        <tr>
            <th>
                位置
            </th>
            <td>
                <%=returnInformation.getWrongLocation()%>
            </td>
        </tr>
        <tr>
            <th>
                结果
            </th>
            <td>
                <%=returnInformation.getReturnInformation()%>
            </td>
        </tr>
        <tr>
            <th>
                返回结果
            </th>
            <td>
                <%=returnInformation.getResult()%>
            </td>
        </tr>
        <tr>
            <th>
                发生日期
            </th>
            <td>
                <%=returnInformation.getDate()%>
            </td>
        </tr>
        <tr>
            <th>
                发生时间
            </th>
            <td>
                <%=returnInformation.getTime()%>
            </td>
        </tr>
    </table>
</body>
</html>
