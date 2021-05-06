<%@ page import="by.itClass.constants.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Web Project</title>
</head>
<body>
  <h1>Hello ${user.login}</h1>
  <a href="<c:url value="<%= Constant.LOGIN_JSP%>"/>">Login</a>
  <a href="<c:url value="<%= Constant.REGISTRATION_JSP%>"/>">Registration</a>
  <a href="<c:url value="<%= Constant.LOGOUT_CONT%>"/>">Logout</a>
</body>
</html>
