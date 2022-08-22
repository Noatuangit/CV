<%@ page import="com.mysql.cj.Session" %>
<%@ page import="com.login_author_cookie_session.models.Fish" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Betta World</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="form.css">
</head>
<body>
<a href="/mainServlet?action=display"><img src="Img/logo.jpg" alt="not found" class="logo"></a>
<c:if test="${requestScope.message != null }">
    <div class="header">${requestScope.message}</div>
</c:if>
<div class="header">
    <div class="menu">
        <div class="up">
            <ul>
                <li><a href="/mainServlet?action=addNew">
                    <img src="logo/addNew.png" class="icon" alt="not found"> Add new fish</a></li>
                <li><a href="/mainServlet?action=edit"> <img src="logo/edit.png" class="icon" alt="not found">Edit Fish</a></li>
                <li><a href="#"><img src="logo/buy.jpg" class="icon" alt="not found"> Buy Fish</a></li>
                <li>
                    <a href="#"><img src="logo/cart.png" class="icon" alt="not found">My Cart</a>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.account != null }">
                        <%--                <c:if test="${sessionScope.account != null }">--%>
                        <li>Hello ${sessionScope.account.username}</li>
                        <li>
                            <form method="post" action="/loginAccount?action=logoutAccount">
                                <button type="submit" class="logout">Logout</button>
                            </form>
                        </li>
                        <%--                </c:if>--%>
                    </c:when>
                    <c:when test="${cookie['username'] != null}">
                        <%--                <c:if test="${cookie['username'] != null}">--%>
                        <li>Hello ${cookie['username'].value}</li>
                        <li>
                            <form method="post" action="/loginAccount?action=logoutAccount">
                                <button type="submit" class="logout">Logout</button>
                            </form>
                        </li>
                        <%--                </c:if>--%>
                    </c:when>
                    <c:otherwise>
                        <%--                    <c:if test="${sessionScope.account == null and cookie['username'] == null}">--%>
                        <li><a href="login.jsp">
                            <button class="login">Login</button>
                        </a></li>
                        <%--                    </c:if>         --%>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
        <div class="down">
            <div class="search">
                <div>
                    <label>
                        <input type="text" placeholder="search name betta you want search" name="nameSearch"
                               class="searchName">
                    </label>
                    <a href="#"><img src="logo/search_icon_153438.png" alt="not found" class="icon"></a>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="left-side">
</div>

<div class="container">
    <div class="mainContainer">
        <% List<Fish> list = (List<Fish>) request.getAttribute("list");%>
        <c:forEach items="<%=list%>" var="item">
            <div class="item"><a class="page-link" href="/mainServlet?action=infoFish&&id=${item.id}"><img
                    src="${item.avatar}" alt="please wait ...">${item.name} type ${item.type}</a>
            </div>
        </c:forEach>
    </div>
</div>
<div class="right-side">
</div>
    <div class="page-container">
        <% int max_page = (int) request.getAttribute("max_page");%>
        <% String link_action = (String) request.getAttribute("link"); %>
        <ul class="page-jump">
            <c:forEach begin="1" end="<%=max_page%>" var="item">
                <li class="item-jump"><a class="page-link"
                                         href="<%=link_action%>&&offset=${item - 1}">${item}</a></li>
            </c:forEach>
        </ul>
    </div>

<script>
    // function getCookie(cname) {
    //     let name = cname + "=";
    //     let decodedCookie = decodeURIComponent(document.cookie);
    //
    //     let ca = decodedCookie.split(';');
    //     for (let i = 0; i < ca.length; i++) {
    //         let c = ca[i];
    //         while (c.charAt(0) === ' ') {
    //             c = c.substring(1);
    //         }
    //         if (c.indexOf(name) === 0) {
    //             return c.substring(name.length, c.length);
    //         }
    //     }
    //     return "";
    // }
    //
    // window.onload = (event) => {
    //     const userNameCookie = document.cookie.replace("username=", "");
    //     if (userNameCookie.trim() === "") return;
    //     document.getElementById("username").innerText = "Hello " + userNameCookie;
    // };
</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>