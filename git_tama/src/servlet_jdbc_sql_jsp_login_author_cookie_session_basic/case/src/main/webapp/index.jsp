<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <%--        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"--%>
    <%--              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">--%>
    <%--        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">--%>
    <link rel="stylesheet" href="FormList.css">
</head>
<body>

<header>
    <div>
        <img src="AC_Milan.png" alt="AC MILAN">
    </div>
    <h3 class="header-bar-text">Boss Cu Meo</h3>
<%--    <%String username = (String) request.getAttribute("usernameCookie");%>--%>
<%--    <c:if test="<%=username == null%>">--%>
<%--        <c:redirect url="login.jsp"></c:redirect>--%>
<%--    </c:if>--%>
<%--    <c:if test="<%=username != null%>">--%>
<%--        <h3 class="header-bar-text">Hello <%=username.toUpperCase()%></h3>--%>
<%--        <a href="/list?action=logout">--%>
<%--            <button>Logout</button>--%>
<%--        </a>--%>
<%--    </c:if>--%>
</header>

<nav>
    <table>
        <tr>
            <td class="bar-menu-nav">
                <a href="index.jsp">Home</a>
            </td>
            <td class="bar-menu-nav">
                <a href="/list?action=displayCustomer">Customer</a>
            </td>
            <td class="bar-menu-nav">
                <a href="/list?action=displayEmployee">Employee</a>
            </td>
            <td class="bar-menu-nav">
                <a href="/list?action=displayService">Service</a>
            </td>
            <td class="bar-menu-nav">
                <a href="/list?action=displayContract">Contract</a>
            </td>
        </tr>
    </table>
</nav>

<section>
    <aside>
        <ul>
            <li class="menu-side"><a href="#">New Type Customer </a></li>
            <li class="menu-side"><a href="#">New Position</a></li>
            <li class="menu-side"><a href="#">New Division</a></li>
            <li class="menu-side"><a href="#">New Education Degree</a></li>
            <li class="menu-side"><a href="#">New Service Type</a></li>
            <li class="menu-side"><a href="#">New Rent Type</a></li>
            <li class="menu-side"><a href="#">New Attach Service</a></li>
        </ul>
    </aside>

    <article>
        <table>

        </table>
    </article>

</section>

<footer>
    Write by Cú Mèo
</footer>

</body>
</html>