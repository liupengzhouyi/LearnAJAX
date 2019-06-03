<%@ page import="Tools.LinkDatabases.LinkMySQLByDBCP.LinkTools.LinkDataBasesByDBCP" %>
<%@ page import="java.lang.management.GarbageCollectorMXBean" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-20
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>监听器</title>
  </head>
  <body>
    <%
      LinkDataBasesByDBCP linkDataBasesByDBCP = new LinkDataBasesByDBCP();
      Connection connection = linkDataBasesByDBCP.getConnection();
      if(connection != null) {
        %>
    <h1>
      连接
    </h1>
    <%
      } else {
    %>
    <h1>
      不连接
    </h1>
    <%
      }
    %>



  </body>
</html>
