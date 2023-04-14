<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
.head {
	cursor: pointer;
	text-decoration: none
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
			<a href="${pageContext.request.contextPath}/customer/form"
				style="padding-right: 10px">
				<button class="btn btn-success">
					<i class="fa-solid fa-plus"> </i> Create
				</button>
			</a>
		</div>
		<div class="wrap-item-center">
			<form action="${pageContext.request.contextPath}/customer"
				method="get">
				<div class="input-group rounded">
					<input type="search" class="form-control rounded"
						placeholder="Search" aria-label="Search name" name="name"
						aria-describedby="search-addon" /> <input type="search"
						class="form-control rounded" placeholder="Search"
						aria-label="Search phone" name="phone"
						aria-describedby="search-addon" /> <span>
						<button type="submit" class="btn btn-light">
							<i class="fas fa-search"></i>
						</button>
					</span>
				</div>
			</form>

			<table class="table table-striped">
				<thead>
					<tr>
						<td><a class="head"
							href="${pageContext.request.contextPath}/customer?page=${0}&phone=${phone}&name=${name}&sort=id">
								# </a></td>
						<td><a class="head"
							href="${pageContext.request.contextPath}/customer?page=${0}&phone=${phone}&name=${name}&sort=name">
								Name </a></td>
						<td><a class="head"
							href="${pageContext.request.contextPath}/customer?page=${0}&phone=${phone}&name=${name}&sort=phone">
								Phone </a></td>
						<td><a class="head"
							href="${pageContext.request.contextPath}/customer?page=${0}&phone=${phone}&name=${name}&sort=email">
								Email </a></td>
						<td><a class="head"
							href="${pageContext.request.contextPath}/customer?page=${0}&phone=${phone}&name=${name}&sort=address">
								Address </a></td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${customers.size() >0 }"> 
					<c:forEach items="${customers}" varStatus="status" var="item">
						<tr>
							<td>${status.count}</td>
							<td>${item.name}</td>
							<td>${item.phone}</td>
							<td>${item.email}</td>
							<td>${item.address}</td>
							<td><a
								href="${pageContext.request.contextPath}/customer/edit/${item.id}">
									<i class="fa-solid fa-user-pen"></i>
							</a> <a onclick="deleteThis('${item.id}','${item.name}')"
								data-bs-toggle="modal" style="cursor: pointer; color: red"
								data-bs-target="#exampleModal"> <i
									class="fa-solid fa-user-slash"></i>
							</a></td>
						</tr>
					</c:forEach>
					</c:if>
					<c:if test="${customers.size() == 0 }"> 
							<tr>
							<td colSpan="6" style="text-align: center">
										No record suitable with condition
							</td>
							</tr>
					</c:if>
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
						href="${pageContext.request.contextPath}/customer?page=${0}&phone=${phone}&name=${name}&sort=${sort}">
							<i class="fa-solid fa-angles-left"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/customer?page=${page-1}&phone=${phone}&name=${name}&sort=${sort}">
							<i class="fa-solid fa-chevron-left"></i>
					</a></li>
				</c:if>
				<c:forEach begin="1" end="${pageTotals}" var="item">
					<li class="page-item"><a
						class="${item-1  == page || page == null ? 'current page-link':'page-link' } "
						href="${pageContext.request.contextPath}/customer?page=${item-1}&phone=${phone}&name=${name}&sort=${sort}">${item}</a>
					</li>
				</c:forEach>
				<c:if test="${page < pageTotals -1}">
					<li class="page-item"><a
						class="${item-1  == page || page == null ? 'current page-link':'page-link' } "
						href="${pageContext.request.contextPath}/customer?page=${page+1}&phone=${phone}&name=${name}&sort=${sort}">
							<i class="fa-solid fa-chevron-right"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/customer?page=${pageTotals - 1}&phone=${phone}&name=${name}&sort=${sort}">
							<i class="fa-solid fa-angles-right"></i>
					</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
	<%--message --%>
	<c:if test="${message != null}">
		<p id="message" style="display: none; color: ${message.contains("Delete")? "red": "green"}; text-align:center">${message}</p>

		<script>
        function displayMessage() {
            document.getElementById("message").style.display = "block";
            setTimeout(() => document.getElementById("message").style.display = "none", 3000);
        }

        displayMessage();
    </script>
	</c:if>
	<!-- Delete Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/customer/delete"
					method="get">
					<input name="id" id="id-delete" type="hidden" />
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Delete
							Customer</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						You want to delete customer 's name is <span id="name-delete"></span>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-danger">Delete</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
	<script>
    function deleteThis(id, name) {
        document.getElementById("name-delete").innerText = name;
        document.getElementById("id-delete").value = id;
    }
</script>
</body>
</html>