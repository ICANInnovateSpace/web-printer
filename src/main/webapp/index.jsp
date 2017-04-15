<%--
  Created by IntelliJ IDEA.
  User: mrzhou
  Date: 17-4-15
  Time: 下午2:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文档选择</title>
</head>
<body>
<form action="getUrl" method="post" enctype="multipart/form-data">
    <table align="center">
        <caption>文件上传</caption>
        <tr>
            <td>文档选择：</td>
            <td><input type="file" name="document" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="上传"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
</body>
</html>
