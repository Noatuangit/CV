<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<link rel="stylesheet" type="text/css" href="resources/style.css" />
<style>
.error {
	color: red;
}

.current {
	background-color: #0dcaf0 !important;
	color: white !important;
}
</style>
</head>
<body>
	<%@include file="../header.jsp"%>
	<div class="main">
		<div class="wrap-item">
			<a href="${pageContext.request.contextPath}/booking"
				style="padding-right: 10px">
				<button class="btn btn-success">
					<i class="fa-solid fa-plus"> </i> Create
				</button>
			</a>
		</div>
		<div class="wrap-item-center">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>#</td>
						<td>Customer name</td>
						<td>Service booking</td>
						<td>Date begin</td>
						<td>Time begin</td>
						<td>Amount</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${services}" varStatus="status" var="item">
						<tr>
							<td>${status.count}</td>
							<td>${item.serviceDetailsID.customer.name}</td>
							<td>${item.serviceDetailsID.service.name}</td>
							<td>	
							<fmt:formatDate value="${item.serviceDetailsID.date_use}" pattern="dd/MM/yyyy" />
							</td>
							<td>${item.serviceDetailsID.time_begin}</td>
							<td>${item.amount}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!--page-->
	<div style="display: flex; justify-content: center">
		<nav aria-label="Page navigation example">
			<ul class="pagination">
				<c:if test="${page > 0}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/managerService?page=${0}">
							<i class="fa-solid fa-angles-left"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/managerService?page=${page-1}">
							<i class="fa-solid fa-chevron-left"></i>
					</a></li>
				</c:if>
				<c:forEach begin="1" end="${totalPages}" var="item">
					<li class="page-item"><a
						class="${item-1  == page || page == null ? 'current page-link':'page-link' } "
						href="${pageContext.request.contextPath}/managerService?page=${item-1}">${item}</a>
					</li>
				</c:forEach>
				<c:if test="${page < totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/managerService?page=${page+1}">
							<i class="fa-solid fa-chevron-right"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/managerService?page=${totalPages - 1}">
							<i class="fa-solid fa-angles-right"></i>
					</a></li>
				</c:if>
			</ul>
		</nav>
	</div>

	<%@include file="../footer.jsp"%>
</body>
</html>
