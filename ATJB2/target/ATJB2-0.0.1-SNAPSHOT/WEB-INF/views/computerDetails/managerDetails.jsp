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
			<button class="btn btn-success" data-bs-toggle="modal"
				data-bs-target="#createModal" id="createButton">
				<i class="fa-solid fa-plus"> </i> Create
			</button>
		</div>
		<div class="wrap-item-center">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>#</td>
						<td>Customer name</td>
						<td>Position computer</td>
						<td>Date begin</td>
						<td>Time begin</td>
						<td>Time use</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${details}" var="item" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${item.computerDetailsID.customer.name}</td>
							<td>${item.computerDetailsID.computer.position}</td>
							<td> 
								<fmt:formatDate value="${item.computerDetailsID.date_begin}" pattern="dd/MM/yyyy" />
							</td>
							<td>${item.computerDetailsID.time_begin}</td>
							<td>${item.time_use}</td>
							<td>
								<button data-bs-toggle="modal" data-bs-target="#exampleModal"
									class="btn btn-danger"
									onclick="handleDelete('${item.computerDetailsID.customer.id}',
                                        '${item.computerDetailsID.computer.id}',
                                        '${item.computerDetailsID.date_begin}',
                                        '${item.computerDetailsID.time_begin}',
                                        '${item.time_use}')">
									<i class="fa-solid fa-eraser"></i>
								</button>
							</td>
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
						href="${pageContext.request.contextPath}/managerComputer?page=${0}">
							<i class="fa-solid fa-angles-left"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/managerComputer?page=${page-1}">
							<i class="fa-solid fa-chevron-left"></i>
					</a></li>
				</c:if>
				<c:forEach begin="1" end="${totalPages}" var="item">
					<li class="page-item"><a
						class="${item-1  == page || page == null ? 'current page-link':'page-link' } "
						href="${pageContext.request.contextPath}/managerComputer?page=${item-1}">${item}</a>
					</li>
				</c:forEach>
				<c:if test="${page < totalPages -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/managerComputer?page=${page+1}">
							<i class="fa-solid fa-chevron-right"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/managerComputer?page=${totalPages - 1}">
							<i class="fa-solid fa-angles-right"></i>
					</a></li>
				</c:if>
			</ul>
		</nav>
	</div>

	<%@include file="../footer.jsp"%>

</body>
<!-- Modal -->
<div class="modal fade" id="createModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Create Modals</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">
				<form id="form">
					<div class="mask d-flex align-items-center h-100 gradient-custom-3">
						<div class="container h-100">
							<div
								class="row d-flex justify-content-center align-items-center h-100">
								<div class="card" style="border-radius: 15px;">
									<div class="card-body p-5">
										<div class="form-outline mb-4">
											<input type="text" id="customer"
												placeholder="Id must KHxxxxx (x is number)"
												class="form-control form-control-lg" /> <label
												class="form-label" for="customer">Customer Booking</label> <span
												id="errorCustomer" class="error"></span>
										</div>
										<div class="form-outline mb-4">
											<input type="text" id="name-customer" readonly
												class="form-control form-control-lg" /> <label
												class="form-label" for="name-customer">Customer name</label>
										</div>

										<div class="form-outline mb-4">
											<select id="computer" class="form-select"
												aria-label="Default select example">
											</select> <label class="form-label" for="computer">Computer
												Booking</label> <span id="errorComputer" class="error"></span>

										</div>
										<div class="form-outline mb-4">
											<input type="date" id="dateBegin"
												class="form-control form-control-lg" /> <label
												class="form-label" for="dateBegin">Date Begin</label> <span
												id="errorDate" class="error"></span>

										</div>
										<div class="form-outline mb-4">
											<input type="time" id="timeBegin"
												class="form-control form-control-lg" /> <label
												class="form-label" for="timeBegin">Time Begin</label> <span
												id="errorTimeBegin" class="error"></span>

										</div>
										<div class="form-outline mb-4">
											<input type="number" id="timeUse"
												class="form-control form-control-lg" /> <label
												class="form-label" for="timeUse">Time Use</label> <span
												id="errorTimeUse" class="error"></span>
										</div>
										<button type="button" class="btn btn-secondary"
											data-bs-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary" id="save">Save
											changes</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>

		</div>
	</div>
</div>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="delete">Delete Modal</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal"
					aria-label="Close"></button>
			</div>
			<div class="modal-body">Are you delete this service?</div>
			<div class="modal-footer">
				<input id="delete_cus_id" type="hidden"> <input
					id="delete_timeUse" type="hidden"> <input
					id="delete_com_id" type="hidden"> <input id="delete_date"
					type="hidden"> <input id="delete_time" type="hidden">
				<button type="button" class="btn btn-secondary"
					data-bs-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="deleteItem">Save
					changes</button>
			</div>
		</div>
	</div>
</div>

<script>
	function handleDelete(customer_id, computer_id, date_begin, time_begin,
			timeUse) {
		document.getElementById("delete_cus_id").value = customer_id;
		document.getElementById("delete_com_id").value = computer_id;
		document.getElementById("delete_timeUse").value = timeUse;
		document.getElementById("delete_date").value = date_begin;
		document.getElementById("delete_time").value = time_begin;
	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="resources/js/managerComputer.js"></script>
</html>
