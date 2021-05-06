<%@ page import="by.itClass.constants.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login page</title>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <c:if test="${not empty message}">
            <p style="color: red">${message}</p>
        </c:if>
        <form id="loginForm" method="post" action="<c:url value="<%= Constant.LOGIN_CONT%>"/>">
            <input type="text" name="<%= Constant.LOGIN%>" placeholder="Login"/>
            <input type="password" name="<%= Constant.PASSWORD%>" placeholder="Password"/>
            <input type="submit" value="login"/>
        </form>
    </div>
</body>
</html>

