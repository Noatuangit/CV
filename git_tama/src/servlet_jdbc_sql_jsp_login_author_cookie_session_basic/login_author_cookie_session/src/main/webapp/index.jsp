<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Web Bán Cá</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="form.css">
</head>
<body>
<div class="header"><%= "Hello World!" %>
</div>
<div class="header">
    <a href="/mainServlet?action=display">Shop ít nào</a>
</div>
<%--<div class="header">--%>
<%--    <%String message = (String) request.getAttribute("message");%>--%>
<%--    <% if (message != null) {%>--%>
<%--    <p><%=message%>--%>
<%--    </p>--%>
<%--    <%} else {--%>
<%--        --%>
<%--    }%>--%>
<%--</div>--%>
<c:choose>
    <c:when test="${requestScope.message!= null}">
        <div class="header">
            <c:out value="${requestScope.message}"></c:out>
        </div>
    </c:when>
    <c:when test="${sessionScope.account != null}">
        <div class="header">
            <c:out value="Hello session ${sessionScope.account.username}"></c:out>
        </div>

    </c:when>
    <c:when test="${cookie['username'] != null}">
        <div class="header">
            <c:out value="Hello comeback cookie ${cookie['username'].value}"></c:out>
        </div>
    </c:when>
</c:choose>
<%--<c:if test="${cookie['username'] != null}">--%>
<%--    <li>Hello comeback ${cookie['username'].value}</li>--%>
<%--</c:if>--%>
</body>
</html>