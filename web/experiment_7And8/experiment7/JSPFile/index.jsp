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
    <h1>
        登陆
    </h1>
    <hr>
    <form action="/experiment_7And8/experiment7/LandingServlet" method="post">
        <table>
            <tr>
                <th>
                    <p>
                        用户名
                    </p>
                </th>
                <td>
                    <input type="text" name="liupengUserID">
                </td>
            </tr>
            <tr>
                <th>
                    <p>
                        密码
                    </p>
                </th>
                <td>
                    <input type="password" name="liupengPassword">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="提交">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>
