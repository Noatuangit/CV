<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">

    <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"></script>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="resources/layout.css"/>
    <style>
        .main-blog{
            height: 45vh;
            overflow: auto;
        }
    </style>
</head>
<body>
<%@include file="header.jsp" %>

<div class="main">
    <div class="wrap-item">
        <a href="${pageContext.request.contextPath}/create">
            <button class="btn btn-success" id="createButton">
                <i class="fa-solid fa-plus"> </i> Create
            </button>
        </a>
    </div>
    <div class="wrap-item-center main-blog">
        <form action="${pageContext.request.contextPath}/"
              method="get">
            <div class="input-group rounded">
                <input type="search" class="form-control rounded"
                       placeholder="Search" aria-label="Search name" name="n"
                       aria-describedby="search-addon"/>
                <label>
                    <select name="id" class="form-control">
                        <option value="" selected>choice some thing</option>
                        <c:forEach items="${types}" var="item">
                            <option value="${item.id}">id: ${item.id}, name: ${item.name}</option>
                        </c:forEach>
                    </select>
                </label>
                <span>
						<button type="submit" class="btn btn-light">
							<i class="fas fa-search"></i>
						</button>
					</span>
            </div>
        </form>
        <table class="table table-striped">
            <thead>
            <tr>
                <td>Id</td>
                <td>Id plate</td>
                <td>Id building</td>
                <td>Area</td>
                <td>Name</td>
                <td>Phone</td>
                <td>Month Join</td>
                <td>Number Month</td>
                <td>Month End</td>
                <td>Total</td>
                <td>Check out</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.idPlate}</td>
                    <td>${item.building.id}</td>
                    <td>${item.area}</td>
                    <td>${item.name}</td>
                    <td>${item.phone}</td>
                    <td>
                        <fmt:formatDate value="${item.monthJoin}" pattern="MM/yyyy"/></td>
                    <td>${item.numberMonth}</td>
                    <td>
                        <fmt:formatDate value="${item.dayEnd}" pattern="dd/MM/yyyy"/></td>
                    <td>${item.total}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/${item.id}"><i
                                class="fa-solid fa-money-bill"></i></a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</div>
<%--message --%>
<c:if test="${message ne null}">
    <marquee width="100%" behavior="scroll" scrollamount="20" loop="1">
        <span style="color: green">${message}</span>
    </marquee>
</c:if>

<%@include file="footer.jsp" %>

</body>
</html>