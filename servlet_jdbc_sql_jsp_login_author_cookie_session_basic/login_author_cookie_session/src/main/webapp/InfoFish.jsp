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
<div class="header">
    <div class="menu">
        <div class="up">
            <ul>
                <li><a href="/mainServlet?action=addNew">
                    <img src="logo/addNew.png" class="icon" alt="not found"> Add new fish</a></li>
                <li><a href="#"> <img src="logo/edit.png" class="icon" alt="not found">Edit Fish</a></li>
                <li><a href="#"><img src="logo/buy.jpg" class="icon" alt="not found"> Buy Fish</a></li>
                <li>
                    <a href="#"><img src="logo/cart.png" class="icon" alt="not found">My Cart</a>
                </li>
                <c:if test="${requestScope[message] != null }">
                    <li>${requestScope[message]}</li>
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
<% Fish fish = (Fish) request.getAttribute("fish");%>
<div class="form-create">
    <div class="insertFish">
        <input type="hidden" name="id" value="<%=fish.getId()%>">
        <table>
            <tr>
                <td>
                    Name:
                </td>
                <td colspan="2">
                    <input type="text" name="name" value="<%=fish.getName()%>" class="input-create" readonly required>
                </td>
            </tr>
            <tr>
                <td>
                    Price:
                </td>
                <td colspan="2">
                    <input type="number" name="price" min="0" value="<%=fish.getPrice()%>" readonly class="input-create"
                           required>
                </td>
            </tr>
            <tr>
                <td>
                    Type:
                </td>
                <td colspan="2">
                    <input type="text" name="type" value="<%=fish.getType()%>" class="input-create" readonly required>
                </td>
            </tr>
            <tr>
                <td>
                    Gender:
                </td>
                <td colspan="2">
                    <input type="radio" name="gender" value="true"
                           <%if(fish.getGender()==Boolean.valueOf("true")){%>checked<%}%> disabled> Male
                    <input type="radio" name="gender" value="false"
                           <%if(fish.getGender()==Boolean.valueOf("false")){%>checked<%}%> disabled> Female
                </td>
            </tr>
            <tr>
                <td>
                    Avatar:
                </td>
                <td colspan="2">
                    <img src="<%=fish.getAvatar()%>" style="width: 693px; height: 553px " alt="please wait...">
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <a href="/mainServlet?buyFish&&id=<%=fish.getId()%>">
                        <button class="btn-btn-create" type="submit">buy</button>
                    </a>
                    <a href="/mainServlet?action=display">
                        <button class="btn-btn-create" type="button">back list</button>
                    </a>
                </td>
            </tr>
        </table>
    </div>
    <div>
        <%String message = (String) request.getAttribute("message");%>
        <% if (message != null) {%>
        <p><%=message%>
        </p>
        <%}%></div>
</div>

</body>
</html>
