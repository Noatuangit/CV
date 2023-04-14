<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
</head>
<style>
.waiting {
	color: red !important;
}

.pending {
	color: green !important;
}

.off {
	color: blue !important;
}

.current {
	background-color: #0dcaf0 !important;
	color: white !important;
}

</style>
<body>
	<%@include file="../header.jsp"%>
	<div class="main">
		<div class="wrap-item">
			<a href="#" style="padding-right: 10px">
				<button class="btn btn-success" data-bs-toggle="modal"
					data-bs-target="#createModal">
					<i class="fa-solid fa-plus"> </i> Create
				</button>
			</a>
		</div>
		<div class="wrap-item-center">
			<form action="${pageContext.request.contextPath}/computer"
				method="get">
				<div class="input-group rounded">
					<input type="search" class="form-control rounded"
						placeholder="Search position" aria-label="Search" name="position"
						aria-describedby="search-addon" /> <input type="search"
						class="form-control rounded" placeholder="Search status"
						aria-label="Search" name="status" aria-describedby="search-addon" />
					<span>
						<button type="submit" class="btn btn-light">
							<i class="fas fa-search"></i>
						</button>
					</span>
				</div>
			</form>

			<table class="table  table-striped">
				<thead>
					<tr>
						<td>#</td>
						<td>Position</td>
						<td>Status</td>
						<td></td>
					</tr>
				</thead>
				<tbody>
					<c:if test="${computers.size() > 0 }"> 
					<c:forEach items="${computers}" varStatus="status" var="item">
						<tr
							class="${item.status == 'waiting' ? 'waiting' : item.status == 'pending' ? 'pending' :  item.status == 'off' ? 'off' : 'on'  }">
							<td>${status.count}</td>
							<td>${item.position}</td>
							<td>${item.status}</td>
							<td>
								<button
									onclick="editForm('${item.id}','${item.position}','${item.status}')"
									data-bs-toggle="modal" class="btn btn-warning"
									data-bs-target="#createModal">
									<i class="fa-solid fa-computer"></i>
								</button>

								<button class="btn btn-danger" ${item.status eq "on"? ""  :"disabled"}
									onclick="deleteThis('${item.id}','${item.position}','${item.status}')"
									data-bs-toggle="modal" data-bs-target="#deleteModal">
									<i class="fa-solid fa-power-off"></i>
								</button>

							</td>
						</tr>
					</c:forEach>
					</c:if> 
					<c:if test="${computers.size() == 0 }"> 
							<tr>
							<td colSpan="4" style="text-align: center">
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
						href="${pageContext.request.contextPath}/computer?page=${0}&position=${position}&status=${status}">
							<i class="fa-solid fa-angles-left"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/computer?page=${page-1}&position=${position}&status=${status}">
							<i class="fa-solid fa-chevron-left"></i>
					</a></li>
				</c:if>
				<c:forEach begin="1" end="${pageTotals}" var="item">
					<li class="page-item">
					<a
						class="${item-1  == page || page == null ? 'current page-link':'page-link' } "
						href="${pageContext.request.contextPath}/computer?page=${item-1}&position=${position}&status=${status}">${item}</a>
					</li>
				</c:forEach>
				<c:if test="${page < pageTotals -1}">
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/computer?page=${page+1}&position=${position}&status=${status}">
							<i class="fa-solid fa-chevron-right"></i>
					</a></li>
					<li class="page-item"><a class="page-link"
						href="${pageContext.request.contextPath}/computer?page=${pageTotals - 1}&position=${position}&status=${status}">
							<i class="fa-solid fa-angles-right"></i>
					</a></li>
				</c:if>
			</ul>
		</nav>
	</div>
	<!-- delete Modal -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="${pageContext.request.contextPath}/computer/delete"
					method="get">
					<input name="id" id="id-delete" type="hidden" />
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Delete Modal</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						You want to delete computer in <span id="position-delete"></span>
						with status <span id="status-delete"></span>
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
	<!-- Create Modal -->
	<div class="modal fade" id="createModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="create">Create modal</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="${pageContext.request.contextPath}/computer"
						method="post" id="form">
						<div class="form-outline mb-4">
							<input type="text" id="position-update"
								onfocusout="validatePosition()" name="position"
								class="form-control form-control-lg" /> <label
								class="form-label" for="position-update">Position you
								want put <span id="required-position"
								style="display: none; color: red"> need something</span>
							</label>
						</div>
						<input type="hidden" id="id-update" name="id">
						<div class="form-outline mb-4">
							<input type="text" id="status-update"
								onfocusout="validateStatus()" name="status"
								class="form-control form-control-lg" /> <label
								class="form-label" for="status-update">Status Computer <span
								id="required-status" style="display: none; color: red">
									need something</span> <span id="pattern-status"
								style="display: none; color: red"> must choice
									on/off/pending/waiting</span></label>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-bs-dismiss="modal">Close</button>
							<button type="submit" class="btn btn-primary" id="save" disabled>Save
								changes</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>
	<%@include file="../footer.jsp"%>
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="resources/js/computerController.js"></script>
</html>