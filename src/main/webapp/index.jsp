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
        <c:import url="subpages/header.jsp"/>
      </div>

      <c:if test="${not empty user}">
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
          <form id="formMenu" method="get" action="<c:url value="<%= Constant.EVENT_LIST_CONT %>"/>" style="display: none">
          </form>
        </div>

        <c:import url="subpages/message.jsp"/>

        <div class="events_container">
          <table>
            <tr>
              <th>Title</th>
              <th>Place</th>
              <th>Date</th>
            </tr>

            <c:forEach var="event" items="${events}">
              <tr>
                <td>
                  <c:url var="eventCont" value="<%= Constant.EVENT_CONT %>">
                    <c:param name="<%= Constant.ID %>" value="${event.id}"/>
                  </c:url>
                  <a href="${eventCont}">${event.title}</a>
                </td>
                <td>${event.place}</td>
                <td>${event.date}</td>
              </tr>
            </c:forEach>

          </table>
        </div>
      </c:if>

    </div>

  <script src="js/main.js"></script>
  </body>
</html>
