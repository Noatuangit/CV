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
    <style>
        .main-blog {
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
                <input type="date" class="form-control rounded"
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
                <td>Mã đơn hàng</td>
                <td>Mã khách hàng</td>
                <td>Tên khách hàng</td>
                <td>Giới tính</td>
                <td>Số điện thoại</td>
                <td>Ngày đặt may</td>
                <td>Trạng thái thanh toán</td>
                <td>Ngày hẹn trả</td>
                <td>Trạng thái đơn hàng</td>
                <td>Ngày trả</td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${data}" var="item">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.customer}</td>
                    <td>${item.name}</td>
                    <td>${item.gender}</td>
                    <td>${item.phone}</td>
                    <td>
                        <fmt:formatDate value="${item.dateOrder}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>${item.statusCheckOut}</td>
                    <td>
                        <fmt:formatDate value="${item.dateEnd}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>${item.statusOrder}</td>
                    <td><fmt:formatDate value="${item.datePay}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/${item.id}">
                            <button type="button" class="btn btn-primary">
                                <i class="fa-solid fa-pen-to-square"></i>
                            </button>
                        </a>
                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                onclick="renderList('${item.list}')"
                                data-bs-target="#exampleModal">
                            <i class="fa-solid fa-circle-info"></i>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <td>Mã chi tiết</td>
                        <td>Tên mặt hàng</td>
                        <td>Số tiền</td>
                        <td>Ghi chú</td>
                    </tr>
                    </thead>
                    <tbody id="body">

                    </tbody>
                </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<%@include file="footer.jsp" %>
</body>
</html>