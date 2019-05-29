<%@ page import="experiment_1And2.experiment1.ReadArray" %>
<%@ page import="experiment_1And2.experiment1.ReadList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="experiment_1And2.experiment1.ReadMap" %>
<%@ page import="java.util.Map" %>
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
    <link type="text/css" href="../CSSFile/index.css" rel="stylesheet">
</head>
<body>
<%
    ReadArray readArray = new ReadArray();
    String[] strings = readArray.getStrings();
    int arrayLength = readArray.getStrings().length;
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("strings", strings);
%>
<%
    ReadList readList = new ReadList();
    List<String> list = readList.getList();
    int listLength = list.size();
    httpSession.setAttribute("list", list);
%>
<%
    ReadMap readMap = new ReadMap();
    Map map = readMap.getMyMap();
    httpSession.setAttribute("map", map);
%>
<h2>
    JSP EL读取数组
</h2>
<hr>
${strings[0]}
<br
${strings[1]}
<br>
${strings[2]}
<br>
${strings[3]}
<h2>
    JSP EL读取List
</h2>
<hr>
${list[1]}
<br>
${list[2]}
<br>
${list[3]}

<h2>
    JSP EL读取Map
</h2>
<hr>
${map["Zara"]}
<br>
${map["Mahnaz"]}
<br>
${map["Ayan"]}
<br>
${map["Daisy"]}
</body>
</html>
