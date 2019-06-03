<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL 数据库操作</title>
</head>
<body>

<%--使用sql:DataSource获取数据库连接--%>
<sql:setDataSource dataSource="jdbc/javaDatabase" var="dblink"></sql:setDataSource>

<h1>
    连接数据库
</h1>

<sql:query dataSource="${dblink}" sql="select * from user" var="result"></sql:query>




<%--<table border="1" width="80%">
    <tr>
        <th>userName</th>
        <th>userID</th>
        <th>paswordValue</th>
        <th>registeredDate</th>
        <th>money</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.userName}"/></td>
            <td><c:out value="${row.userID}"/></td>
            <td><c:out value="${row.paswordValue}"/></td>
            <td><c:out value="${row.registeredDate}"/></td>
            <td><c:out value="${row.money}"/></td>
        </tr>
    </c:forEach>
</table>--%>


</body>
</html>
