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


</body>
</html>
