<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSTL 解析XML 文件</title>
</head>
<body>

<x:parse var="sampleXML">
    <c:import url="../XMLFile/index.xml" charEncoding="utf-8"/>
</x:parse>

<b>The title of the first book is</b>:
<x:out select="$sampleXML/books/book[1]/name" />
<br>
<b>The price of the second book</b>:
<x:out select="$sampleXML/books/book[2]/price" />

<ul class="list">
    <x:forEach select="$sampleXML/books/book/name" var="item">
        <li>Book Name: <x:out select="$item" /></li>
    </x:forEach>
</ul>


</body>
</html>
