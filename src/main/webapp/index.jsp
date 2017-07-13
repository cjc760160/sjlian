<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css"/>
    <title>登录页面</title>
</head>
<body>
<div class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <h2> hello world login!</h2>
            <form id="login-form" method="post" action="j_spring_security_check">
                <input type="text" name="j_username" id="username" placeholder="请输入您的用户名" value="">
                <input type="password" name="j_password" id="password" placeholder="请输入您的密码" value="">
                <input class="submit" type="submit" value="Login">
            </form>
            <br/>
            <c:if test="${param.error == 'true'}">
                <span>用户名密码错误</span>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
