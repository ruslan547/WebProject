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

  <div class="container">
    <div class="header">
      <h1>Hello ${user.login}</h1>
      <a href="<c:url value="<%= Constant.LOGIN_JSP%>"/>">Login</a>
      <a href="<c:url value="<%= Constant.REGISTRATION_JSP%>"/>">Registration</a>
      <a href="<c:url value="<%= Constant.LOGOUT_CONT%>"/>">Logout</a>
    </div>
    <div class="menu">
      <table>
        <tr>
          <td>
            <a href="JavaScript:sendFormMenu('today')">Today</a>
          </td>
          <td>
            <a href="JavaScript:sendFormMenu('tomorrow')">Tomorrow</a>
          </td>
          <td>
            <a href="JavaScript:sendFormMenu('soon')">Soon</a>
          </td>
          <td>
            <a href="JavaScript:sendFormMenu('finished')">Finished</a>
          </td>
          <td>
            <a href="JavaScript:sendFormMenu('all')">All</a>
          </td>
        </tr>
      </table>
      <form id="formMenu" method="get" action="<c:url value="<%= Constant.EVENT_LIST_CONT%>"/>" style="display: none" >

      </form>
    </div>
  </div>

<script src="js/main.js"></script>

</body>
</html>
