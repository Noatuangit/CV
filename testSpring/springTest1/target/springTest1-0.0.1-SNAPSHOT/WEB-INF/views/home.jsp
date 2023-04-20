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
</head>
<body>
<div class="main">
    <div class="wrap-item">
        <a href="${pageContext.request.contextPath}/create">
            <button class="btn btn-success" id="createButton">
                <i class="fa-solid fa-plus"> </i> Create
            </button>
        </a>
    </div>
    <div class="wrap-item-center">
        <form action="${pageContext.request.contextPath}/"
              method="get">
            <div class="input-group rounded">
                <input type="search" class="form-control rounded"
                       placeholder="Search" aria-label="Search name" name="n"
                       aria-describedby="search-addon"/>
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
                <td>#</td>
                <td>Id</td>
                <td>Name</td>
                <td>Type</td>
                <td>Phone</td>
                <td>Day order</td>
                <td>Persons</td>
                <td>Children</td>
                <td>Time begin</td>
                <td>Total</td>
                <td>Edit</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list.content}" varStatus="status" var="item">
                <tr>
                    <td>${status.count}</td>
                    <td>${item.id}</td>
                    <td>${item.name}</td>
                    <td>${item.customer.id}</td>
                    <td>${item.phone}</td>
                    <td>
                        <fmt:formatDate value="${item.dateOrder}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>${item.persons}</td>
                    <td>${item.children}</td>
                    <td>${item.timeIn}</td>
                    <td>${item.total} vnd</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/${item.id}">
                            <button class="btn btn-warning"><i class="fa-solid fa-pen-to-square"></i></button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <!--page-->
        <div style="display: flex; justify-content: center">
            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <c:if test="${list.number > 0}">
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}?p=${0}&n=${name}">
                            <i class="fa-solid fa-angles-left"></i>
                        </a></li>
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}?p=${list.number - 1}&n=${name}">
                            <i class="fa-solid fa-chevron-left"></i>
                        </a></li>
                    </c:if>
                    <c:forEach begin="1" end="${list.totalPages}" var="item">
                        <li class="page-item"><a
                                class="${item - 1  == list.number || list.number  == null ? 'current page-link':'page-link' } "
                                href="${pageContext.request.contextPath}?p=${item - 1}&n=${name}">${item}</a>
                        </li>
                    </c:forEach>
                    <c:if test="${list.number < list.totalPages -1}">
                        <li class="page-item"><a
                                class="page-link"
                                href="${pageContext.request.contextPath}?p=${list.number + 1}&n=${name}">
                            <i class="fa-solid fa-chevron-right"></i>
                        </a></li>
                        <li class="page-item"><a class="page-link"
                                                 href="${pageContext.request.contextPath}?p=${list.totalPages - 1}&n=${name}">
                            <i class="fa-solid fa-angles-right"></i>
                        </a></li>
                    </c:if>
                </ul>
            </nav>
        </div>

        <%--message --%>
        <c:if test="${message ne null}">
            <p id="message"
               style="display: none; color: red; text-align:center">${message}</p>
            <script>
                function displayMessage() {
                    document.getElementById("message").style.display = "block";
                    setTimeout(() => document.getElementById("message").style.display = "none", 3000);
                }
                displayMessage();
            </script>
        </c:if>
    </div>
</div>
</body>
</html>