<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lian
  Date: 17/7/13
  Time: 09:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <h2>LIAN</h2>
            <form id="login-form" method="post" action="j_spring_security_check">
                <input type="text" name="j_username" id="username" placeholder="请输入您的用户名" value="">
                <input type="password" type="password" name="j_password" id="password" placeholder="请输入您的密码" value="">
                <input class="submit" type="submit" value="Login">
            </form>
            <c:if test="${param.error == 'true'}">
                <span>用户名密码错误</span>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
