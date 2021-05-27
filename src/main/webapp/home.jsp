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
    <div class="header">
      <c:import url="subpages/header.jsp"/>
    </div>

    <h3>Hello ${user.name} ${user.surname}</h3>
    <p>${user.id}</p>
    <p>${user.login}</p>
    <p>${user.age}</p>
    <p>${user.email}</p>

    <c:import url="subpages/message.jsp"/>

    <div class="events_container">
      <table>
        <tr>
          <th>Choose</th>
          <th>Title</th>
          <th>Place</th>
          <th>Date</th>
        </tr>

        <c:forEach var="event" items="${events}">
          <tr>
            <td>
              <input form="deleteForm" type="checkbox" name="<%= Constant.ID %>" value="${event.id}">
            </td>
            <td>${event.title}</td>
            <td>${event.place}</td>
            <td>${event.date}</td>
          </tr>
        </c:forEach>

      </table>
    </div>

    <a href="JavaScript:sendFormMenu('home')">View events</a>
    <a href="<c:url value="<%= Constant.NEW_EVENT_JSP %>"/>">New event</a>
    <a href="JavaScript:sendDeleteForm()">Delete event</a>

    <form id="deleteForm" method="post" action="<c:url value="<%= Constant.DELETE_EVENT_CONT %>" /> ">
    </form>
    <form id="formMenu" method="get" action="<c:url value="<%= Constant.EVENT_LIST_CONT %>"/>" style="display: none">
    </form>
    <script src="js/main.js"></script>
  </body>
</html>
