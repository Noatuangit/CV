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
<body>
	<%@include file="../header.jsp"%>

	<section style="background-color: #eee;">
		<div class="container">
			<div class="row d-flex justify-content-center align-items-center ">
				<div class="col-lg-12 col-xl-11">
					<div class="card text-black" style="border-radius: 25px;">
						<div class="card-body p-md-5">
							<div class="row justify-content-center">
								<div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

									<p class="text-center h1 fw-bold mb-5 mx-1 mx-md-4 mt-4">Sign
										up</p>
									<form:form class="mx-1 mx-md-4"
										action="${pageContext.request.contextPath}/customer/${action}"
										method="post" modelAttribute="customer">
										<input type="hidden" name="id" value="${customer.id}">
										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-user fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example1c"
													value="${customer.name}" name="name" class="form-control" />
												<label class="form-label" for="form3Example1c">Name</label>
												<form:errors path="name" style="color: red" />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-envelope fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example3c"
													value="${customer.email}" name="email" class="form-control" />
												<label class="form-label" for="form3Example3c">Your
													Email</label>
												<form:errors path="email" style="color: red" />
											</div>
										</div>

										<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-lock fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example4c"
													value="${customer.phone}" name="phone" class="form-control" />
												<label class="form-label" for="form3Example4c">Phone</label>
												<form:errors path="phone" style="color: red" />
											</div>
										</div>

									<div class="d-flex flex-row align-items-center mb-4">
											<i class="fas fa-key fa-lg me-3 fa-fw"></i>
											<div class="form-outline flex-fill mb-0">
												<input type="text" id="form3Example4cd"
													value="${customer.address}" name="address"
													class="form-control" /> <label class="form-label"
													for="form3Example4cd">Address</label>
												<form:errors path="address" style="color: red" />
											</div>
										</div>
										<div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
											<a href="${pageContext.request.contextPath}/customer" style="margin-right: 5px">
												<button type="button" class="btn btn-secondary">Back
													list</button>
											</a>
											<button type="submit" class="btn btn-primary"
												>${action}</button>
										</div>

									</form:form>

								</div>
								<div
									class="col-md-10 col-lg-6 col-xl-7 d-flex align-items-center order-1 order-lg-2">
									<img
										src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/draw1.webp"
										class="img-fluid" alt="Sample image">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<%@include file="../footer.jsp"%>
</body>
</html>
