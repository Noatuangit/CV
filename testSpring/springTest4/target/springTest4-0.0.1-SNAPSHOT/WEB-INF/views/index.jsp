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
    <script src="resources/controller.js"></script>

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
    <div class="wrap-item-center ">
        <form action="${pageContext.request.contextPath}/"
              method="get">
            <div class="input-group rounded">
                <input type="search" class="form-control rounded"
                       placeholder="Search status" aria-label="Search name" name="s"
                       aria-describedby="search-addon"/>
                <input type="search" class="form-control rounded"
                       placeholder="Search result" aria-label="Search name" name="r"
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
                <td>CCCD</td>
                <td>Họ tên</td>
                <td>Ngày sinh</td>
                <td>Giới tính</td>
                <td>Điện thoại</td>
                <td>Trạng thái</td>
                <td>Kết quả</td>
                <td>Ngày xét nghiệm</td>
                <td>Mã đặt vé</td>
                <td>Ngày đặt vé</td>
                <td>Biển số</td>
                <td>Điểm đi</td>
                <td>Điểm đến</td>
                <td>Ngày xuất phát</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${items}" var="item">
                <Tr>
                    <td>${item.customer.idCard}</td>
                    <td>${item.customer.name}</td>
                    <td>
                        <fmt:formatDate value="${item.customer.birthday}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>${item.customer.gender}</td>
                    <td>${item.customer.phone}</td>
                    <td>${item.customer.status}</td>
                    <td>${item.customer.result}</td>
                    <td>
                        <fmt:formatDate value="${item.customer.dayTest}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>${item.id}</td>
                    <td>
                        <fmt:formatDate value="${item.dayOrder}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>${item.carId}</td>
                    <td>${item.placeIn}</td>
                    <td>${item.placeOut}</td>
                    <td><fmt:formatDate value="${item.dayBegin}" pattern="dd/MM/yyyy"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/${item.id}">
                            <i class="fa-solid fa-pen-to-square"></i>
                        </a>

                    </td>
                </Tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="footer.jsp" %>
</body>
</html>