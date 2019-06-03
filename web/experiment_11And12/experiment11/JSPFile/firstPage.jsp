<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-06-04
  Time: 02:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("pageNumber", "0");
    response.sendRedirect("/experiment_11And12/experiment11/GetOrderAndPagingShowServlet");
%>
</body>
</html>
