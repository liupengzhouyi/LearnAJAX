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
    <title>上传文件</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
    <h1>文件上传实例 - By 刘鹏</h1>
    <form method="post" action="/experiment_9And10/experiment9/UploadServlet" enctype="multipart/form-data">
        选择一个文件:
        <input type="file" name="uploadFile" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
</body>
</html>
