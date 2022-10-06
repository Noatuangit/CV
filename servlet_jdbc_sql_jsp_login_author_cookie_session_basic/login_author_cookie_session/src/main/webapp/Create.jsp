<%@ page import="com.mysql.cj.Session" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add New Fish</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="form.css">
</head>
<body>
<a href="/mainServlet?action=display"><img src="Img/logo.jpg" alt="not found" class="logo"></a>

<div class="header">
    <div class="menu">
        <div class="up">
            <ul>
                <li><a href="/mainServlet?action=addNew">
                    <img src="logo/addNew.png" class="icon" alt="not found"> Add new fish</a></li>
                <li><a href="#"> <img src="logo/edit.svg" class="icon" alt="not found">Edit Fish</a></li>
                <%--                <li><a href="#"><img src="logo/buy.jpg" class="icon" alt="not found"> Buy Fish</a></li>--%>
                <li>
                    <a href="#"><img src="logo/cart.png" class="icon" alt="not found">My Cart</a>
                </li>
                <c:if test="${requestScope.message != null }">
                    <li>${requestScope.message}</li>
                </c:if>
                <c:if test="${sessionScope.account != null }">
                    <li>Hello ${sessionScope.account.username}</li>
                    <li>
                        <form method="post" action="/loginAccount?action=logoutAccount">
                            <button type="submit" class="logout">Logout</button>
                        </form>
                    </li>
                </c:if>

                <c:if test="${cookie['username'] != null}">
                    <li>Hello ${cookie['username'].value}</li>
                    <li>
                        <form method="post" action="/loginAccount?action=logoutAccount">
                            <button type="submit" class="logout">Logout</button>
                        </form>
                    </li>
                </c:if>

                <c:if test="${sessionScope.account == null and cookie['username'] == null}">
                    <li><a href="login.jsp">
                        <button class="login">Login</button>
                    </a></li>
                </c:if>
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
<div class="form-create">
    <form method="post">
        <div class="insertFish">
            <table>
                <tr>
                    <td>
                        Name:
                    </td>
                    <td colspan="2">
                        <input type="text" name="name" placeholder="Name Fish" class="input-create" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Price:
                    </td>
                    <td colspan="2">
                        <input type="number" name="price" placeholder="0000000 vnd" class="input-create"
                               required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Type:
                    </td>
                    <td colspan="2">
                        <input type="text" name="type" placeholder="Type Fish" class="input-create" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Gender:
                    </td>
                    <td colspan="2">
                        <input type="radio" name="gender" value="true"> Male
                        <input type="radio" name="gender" value="false"> Female
                    </td>
                </tr>
                <tr>
                    <td>
                        Avatar:
                    </td>
                    <td colspan="2">
                        <input type="file" name="avatar" class="input-create" placeholder="link img">
                    </td>
                </tr>
                <tr>
                    <td>
                        <button class="btn-btn-create" type="submit">submit</button>
                    </td>
                    <td colspan="2">
                        <button class="btn-btn-create" type="reset">reset</button>
                        <a href="/mainServlet?action=display">
                            <button class="btn-btn-create" type="button">back list</button>
                        </a>
                    </td>
                </tr>
            </table>
        </div>
    </form>
    <div>
        <%String message = (String) request.getAttribute("message");%>
        <% if (message != null) {%>
        <p><%=message%>
        </p>
        <%}%></div>
</div>
</body>
</html>
