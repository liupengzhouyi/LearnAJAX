<%@ page import="experiment_1And2.experiment1.ReadArray" %>
<%@ page import="experiment_1And2.experiment1.ReadList" %>
<%@ page import="java.util.List" %>
<%@ page import="experiment_1And2.experiment1.ReadMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="experiment_1And2.experiment2.Good" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: liupeng
  Date: 2019-05-29
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>JSTL</title>
    <link type="text/css" href="../CSSFile/index.css" rel="stylesheet">
</head>
<body>
<%
    ReadArray readArray = new ReadArray();
    String[] strings = readArray.getStrings();
    int arrayLength = readArray.getStrings().length;
    HttpSession httpSession = request.getSession();
    httpSession.setAttribute("strings", strings);
    httpSession.setAttribute("arrayLength", arrayLength);
%>
<%
    ReadList readList = new ReadList();
    List<String> list = readList.getList();
    int listLength = list.size();
    httpSession.setAttribute("list", list);
    httpSession.setAttribute("listLength", listLength);
%>
<%
    ReadMap readMap = new ReadMap();
    Map map = readMap.getMyMap();
    int mpaSize = map.size();
    httpSession.setAttribute("map", map);
    httpSession.setAttribute("mpaSize", mpaSize);
    httpSession.setAttribute("gender", 0);
%>
<%
    Good good = new Good("default");
    ArrayList<Good> goodList = new ArrayList<>();
    for(int i=0;i<9;i++) {
        goodList.add(good);
    }
    httpSession.setAttribute("goodList", goodList);
%>
<h1>
利用编写程序输出EL表达式的值，其中EL表达式分别包含算术运算、逻辑运算、关系运算、条件运算、empty运算。
</h1>
<hr>
<h2>
    算术运算
</h2>
2+3= <c:out value="${2+3}" default="默认值" escapeXml="false"></c:out>
<br>
2-3= <c:out value="${2-3}" default="默认值" escapeXml="false"></c:out>
<br>
2*3= <c:out value="${2*3}" default="默认值" escapeXml="false"></c:out>
<br>
6/3= <c:out value="${6/3}" default="默认值" escapeXml="false"></c:out>
<br>
<h2>
    逻辑运算
</h2>
false&&true= <c:out value="${false&&true}" default="1&0=未知" escapeXml="false"></c:out>
<br>
false||false= <c:out value="${false||false}" default="1&0=未知" escapeXml="false"></c:out>
<br>
true&&true= <c:out value="${true||true}" default="1&0=未知" escapeXml="false"></c:out>
<h2>
    关系运算
</h2>
${gender eq 0?"男":"女"}
<h2>
    条件运算
</h2>
(1>2)?1:2 -- ${(1>2)?1:2}
<h2>
    empty运算
</h2>
${empty null}
<br>
${empty gender}

<h1>
    将一个变量存到JSP内置对象session中，并输出。
</h1>
<br>
方式一：<c:out value="${gender}"></c:out>
<br>
方式二：<%=httpSession.getAttribute("gender")%>
<br>
方式三：
<br>
方式四：
<br>
方式五：
<br>
方式六：
<br>
<h1>
    利用设计程序测试一个变量在删除前后值有什么变化。
</h1>
<hr>

设置值: <c:set var="myValue" scope="session" value="${2000*2}"/>
<br>
输出值: <c:out value="${myValue}"/>
<br>
移除值: <c:remove var="myValue" scope="session"></c:remove>
<br>
删除 salary 变量后的值: <c:out value="${myValue}"/>

<h1>
    设计一个利用捕获异常的程序。
</h1>
<hr>
<c:catch var ="catchException">
    <% int x = 5/0;%>
</c:catch>
<c:if test = "${catchException != null}">
    <p>异常为 : ${catchException} <br />
        发生了异常: ${catchException.message}</p>
</c:if>
<h1>
    利用设计一个条件语句并测试，利用测试多分支选择语句。
</h1>
<hr>

<h2>
    If 语句
</h2>
<c:if test="${myValue > 2000}">
    <p>
        我的工资为: <c:out value="${myValue}"/>
    <p>
    </c:if>

<h2>
    choose & when 语句
</h2>
<c:choose>
    <c:when test="${myValue <= 0}">
        太惨了。
    </c:when>
    <c:when test="${myValue > 1000}">
        不错的薪水，还能生活。
    </c:when>
    <c:otherwise>
        什么都没有。
    </c:otherwise>
</c:choose>
<h1>
    设计一个数组，用循环输出数组中的元素的值，并测试varStatus属性的所有值。
</h1>
<hr>
<c:forEach items="${strings}" begin="1" end="${arrayLength}" step="1" var="string">
    <c:out value="${string}"></c:out>
    <br>
</c:forEach>
<h1>
    设计一个List对象，用循环输出List中的元素的值。
</h1>
<hr>
<c:forEach items="${list}" var="listItem" begin="1" end="${listLength}" step="1">
    <c:out value="${listItem}"></c:out>
    <br>
</c:forEach>
<h1>
    设计一个Map对象，用循环输出Map中元素的键和值。
</h1>
<hr>
<c:forEach items="${map}" var="mapItem">
    <c:out value="${mapItem.key}"></c:out>
    <c:out value="${mapItem.value}"></c:out>
    <br>
</c:forEach>

<h1>
    设计一个表格，利用的varStatus属性实现表格隔行背景色变化。
</h1>
<hr>
<table border="1">
    <c:forEach items="${goodList}" var="good" varStatus="varStatus">
        <tr bgcolor="${varStatus.index % 2 == 1 ? '#EFEFEF' : 'FFFFFF'}">
            <td>${good.goodID}</td>
            <td>${good.goodName}</td>
            <td>${good.goodPrice}</td>
            <td>${good.goodRigin}</td>
            <td>${good.monthNumber}</td>
            <td>${good.productData}</td>
            <td>${good.shelvesDate}</td>
            <td>${good.eliminateDate}</td>
            <td>${good.eliminateKey}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>