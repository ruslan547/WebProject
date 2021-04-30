<%@ page import="by.itClass.constants.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport"
        content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Registration</title>
</head>
<body>
  <div class="container">
    <h2>Registration</h2>
    <form id="registForm" method="post" action="<c:url value="<%= Constant.REGISTRATION_CONT%>"/>">
      <input type="text" name="<%= Constant.LOGIN%>" placeholder="Login"/>
      <input type="password" name="<%= Constant.PASSWORD%>" placeholder="password">
      <input type="text" name="<%= Constant.NAME%>" placeholder="Name"/>
      <input type="text" name="<%= Constant.SURNAME%>" placeholder="Surname"/>
      <input type="text" name="<%= Constant.AGE%>" placeholder="Age"/>
      <input type="email" name="<%= Constant.EMAIL%>" placeholder="email"/>
      <input type="submit" value="registration"/>
    </form>
  </div>
</body>
</html>
