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
  <title>New event</title>
</head>
<body>
  <h2>Event form</h2>
  <form id="addProgramForm" method="post" action="<c:url value="<%= Constant.ADD_EVENT_CONT%>"/>">
    <input type="text" name="<%= Constant.TITLE %>" placeholder="Title">
    <input type="text" name="<%= Constant.DESCR %>" placeholder="Description">
    <input type="text" name="<%= Constant.PLACE %>" placeholder="Place">
    <input type="date" name="<%= Constant.DATE %>" placeholder="Date">
    <br><br>
    <div id="program_cont">
      <input id="pr_title" type="text" name="<%= Constant.PR_TITLE %>" placeholder="Title">
      <input id="pr_time" type="time" name="<%= Constant.PR_TIME %>" placeholder="Time">

    </div>
    <input id="add_btn" type="submit" value="Create">
  </form>

  <a href="JavaScript:addProgram()">Add program</a>
  <a href="JavaScript:removeProgram()">Remove program</a>
  <script src="js/main.js"></script>
</body>
</html>