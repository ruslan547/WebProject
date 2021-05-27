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
    <title>Document</title>
  </head>
  <body>
  <c:import url="subpages/message.jsp"/>
    <h2>Event: ${event.title}</h2>
    <h3>Description</h3>
    <p>${event.descr}</p>
    <h3>Place</h3>
    <p>${event.place}</p>
    <h3>Date</h3>
    <p>${event.date}</p>
    <h3>Author</h3>
    <p>${event.author}</p>
  </body>
</html>