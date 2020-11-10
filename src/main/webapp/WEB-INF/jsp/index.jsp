<%--
  Created by IntelliJ IDEA.
  User: ychw
  Date: 2020/11/8
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>登录成功</h3>


<shiro:hasPermission name="first-level">
    <a id="save" href="#" class="easyui-linkbutton">first-level</a>
</shiro:hasPermission>

<shiro:hasPermission name="second-level">
    <a id="save" href="#" class="easyui-linkbutton">second-level</a>
</shiro:hasPermission>

<shiro:hasRole name="staff">
    <a id="save" href="#" class="easyui-linkbutton">staff</a>
</shiro:hasRole>

<shiro:hasRole name="manager">
    <a id="save" href="#" class="easyui-linkbutton">manager</a>
</shiro:hasRole>

<h2>权限申请</h2>

<form action="apply" method="get">
    申请ID：<br><input type="text" name="applyID" /><br>
    申请权限：<br><input type="text" name="permission" /><br>
    <input type="submit" value="提交">
</form>


</body>
</html>
