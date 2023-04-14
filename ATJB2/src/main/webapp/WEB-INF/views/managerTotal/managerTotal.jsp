<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer</title>
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
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <style type="text/css">
        .current {
            background-color: #0dcaf0 !important;
            color: white !important;
        }
    </style>

</head>
<body>
<%@include file="../header.jsp" %>
<div class="main">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <td>#</td>
            <td>ID customer</td>
            <td>Name customer</td>
            <td>Computer Id</td>
            <td>Computer Position</td>
            <td>Computer Status</td>
            <td>date begin computer</td>
            <td>time begin computer</td>
            <td>time use Computer</td>
            <td>service id</td>
            <td>date Service</td>
            <td>time Service</td>
            <td>amount</td>
            <td>total</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${totals}" var="item" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${item[0]}</td>
                <td>${item[1]}</td>
                <td>${item[2]}</td>
                <td>${item[3]}</td>
                <td>${item[4] }</td>
                <td>${item[5]}</td>
                <td>${item[6]}</td>
                <td>${item[7]}</td>
                <td>${item[8]}</td>
                <td>${item[9]}</td>
                <td>${item[10]}</td>
                <td>${item[11]}</td>
                <td>${item[12] }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<!--page-->
<div style="display: flex; justify-content: center">
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <c:if test="${page > 0}">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/managerTotal?page=${0}">
                    <i class="fa-solid fa-angles-left"></i>
                </a></li>
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/managerTotal?page=${page-1}">
                    <i class="fa-solid fa-chevron-left"></i>
                </a></li>
            </c:if>
            <c:forEach begin="1" end="${totalsPage}" var="item">
                <li class="page-item"><a
                        class="${item-1  == page || page == null ? 'current page-link':'page-link' } "
                        href="${pageContext.request.contextPath}/managerTotal?page=${item-1}">${item}</a>
                </li>
            </c:forEach>
            <c:if test="${page < totalsPage -1}">
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/managerTotal?page=${page+1}">
                    <i class="fa-solid fa-chevron-right"></i>
                </a></li>
                <li class="page-item"><a class="page-link"
                                         href="${pageContext.request.contextPath}/managerTotal?page=${totalsPage - 1}">
                    <i class="fa-solid fa-angles-right"></i>
                </a></li>
            </c:if>
        </ul>
    </nav>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>
