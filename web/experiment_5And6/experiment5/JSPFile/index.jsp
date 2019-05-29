<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL 数据库操作</title>
</head>
<body>
<sql:setDataSource var="dblink" driver="com.mysql.cj.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/javaDatabase?useSSL=false&serverTimezone=UTC"
                   user="root"  password="Lp184126"></sql:setDataSource>
<sql:query dataSource="${dblink}" sql="select * from user;" var="result"></sql:query>

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
