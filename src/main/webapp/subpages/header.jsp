<%@ page import="by.itClass.constants.Constant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<table>
    <tr>
        <c:choose>
            <c:when test="${not empty user}">
                <th>
                    <a href="<c:url value="<%= Constant.INDEX_JSP%>"/>">INDEX</a>
                </th>
                <td>
                    <a href="<c:url value="<%= Constant.HOME_JSP%>"/>"> ${user.login} </a>
                </td>
                <td>
                    <a href="<c:url value="<%= Constant.LOGOUT_CONT %>"/>">Logout</a>
                </td>
            </c:when>
            <c:otherwise>
                <td>
                    <a href="<c:url value="<%= Constant.LOGIN_JSP %>"/>">Login</a>
                </td>
                <td>
                    <a href="<c:url value="<%= Constant.REGISTRATION_JSP %>"/>">Registration</a>
                </td>
            </c:otherwise>
        </c:choose>
    </tr>
</table>