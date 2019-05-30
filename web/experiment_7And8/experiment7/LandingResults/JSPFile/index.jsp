<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP EL读取数组、List、Map值</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession();
    String landingreturnInformation = (String) httpSession.getAttribute("landingreturnInformation");
%>
    <h1>
        登陆
    </h1>
    <hr>
    <h2>
        <%=landingreturnInformation%>
    </h2>
    <h3>
        <a>
            点我退出登陆
        </a>
    </h3>

</body>
</html>
