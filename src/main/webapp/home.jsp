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
  <title>Home Page</title>
</head>
<body>
  <h3>Hello ${user.name} ${user.surname}</h3>
  <p>${user.id}</p>
  <p>${user.login}</p>
  <p>${user.age}</p>
  <p>${user.email}</p>

  <div class="events_container">
    <table>
      <tr>
        <th>id</th>
        <th>Title</th>
        <th>Description</th>
        <th>Place</th>
        <th>Date</th>
        <th>Author</th>
        <th></th>
      </tr>

      <c:forEach var="event" items="${events}">
        <tr>
          <td>${event.id}</td>
          <td>${event.title}</td>
          <td>${event.desc}</td>
          <td>${event.place}</td>
          <td>${event.date}</td>
          <td>${event.author}</td>
        </tr>
      </c:forEach>
    </table>
  </div>

  <a href="<c:url value="<%= Constant.NEW_EVENT_JSP%>"/>">New event</a>
  <a href="#">Edit event</a>
  <a href="#">Delete event</a>
</body>
</html>
