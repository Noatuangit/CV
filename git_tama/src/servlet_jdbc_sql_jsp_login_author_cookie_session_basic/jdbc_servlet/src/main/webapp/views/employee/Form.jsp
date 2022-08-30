<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="../index.jsp">Home</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/customer?action=displayCustomer">Customer</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/employee?action=displayEmployee">Employee</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/service?action=displayService">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/contract?action=displayContract">Contract</a>
</nav>
<form method="post">
    <section class="h-100 bg-dark">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col">
                    <div class="card card-registration my-4">
                        <div class="row g-0">
                            <div class="col-xl-3 d-none d-xl-block">
                                <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                                     alt="Sample photo" class="img-fluid"
                                     style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;"/>
                            </div>
                            <div class="col-xl-9">
                                <div class="card-body p-md-5 text-black">
                                    <h3 class="mb-5 text-uppercase">Form Controller Employee</h3>
                                    <c:if test="${message != null}">
                                        <h5 style="color:red;">${message}</h5>
                                    </c:if>
                                    <input type="hidden" name="id" value="${employee.id}">
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="text" id="form3Example1m" name="name" value="${employee.name}"
                                                       class="form-control form-control-lg" required/>
                                                <label class="form-label" for="form3Example1m">Name</label>
                                                <c:if test="${error != null}">
                                                    <h3 style="color:red;">${error.get("name")}</h3>
                                                </c:if>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="text" id="form3Example1n" name="id_card" value="${employee.id_card}"
                                                       class="form-control form-control-lg" required/>
                                                <label class="form-label" for="form3Example1n">Id card</label>
                                                <c:if test="${error != null}">
                                                    <h3 style="color:red;">${error.get("id_card")}</h3>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="date" id="form3Example1m1" name ="birthday" value="${employee.birthday}"
                                                       class="form-control form-control-lg" required/>
                                                <label class="form-label" for="form3Example1m1">Birthday</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="number" id="form3Example1n1" name="salary" value="${employee.salary}"
                                                       class="form-control form-control-lg" required/>
                                                <label class="form-label" for="form3Example1n1">Salary</label>
                                                <c:if test="${error != null}">
                                                    <h3 style="color:red;">${error.get("salary")}</h3>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">
                                        <h6 class="mb-0 me-4">Division </h6>
                                        <c:forEach items="${divisions}" var="item">
                                            <c:choose>
                                                <c:when test="${employee.division == item.id}">
                                                    <div class="form-check form-check-inline mb-0 me-4">
                                                        <input class="form-check-input" type="radio" name="divisions"
                                                               value="${item.id}" checked/>
                                                        <label class="form-check-label" >${item.name}</label>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="form-check form-check-inline mb-0 me-4">
                                                        <input class="form-check-input" type="radio" name="divisions"
                                                               value="${item.id}" />
                                                        <label class="form-check-label">${item.name}</label>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                    <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">
                                        <h6 class="mb-0 me-4">Education </h6>
                                        <c:forEach items="${educations}" var="item">
                                            <c:choose>
                                                <c:when test="${employee.education_degree == item.id}">
                                                    <div class="form-check form-check-inline mb-0 me-4">
                                                        <input class="form-check-input" type="radio" name="educations"
                                                               value="${item.id}" checked/>
                                                        <label class="form-check-label" >${item.name}</label>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="form-check form-check-inline mb-0 me-4">
                                                        <input class="form-check-input" type="radio" name="educations"
                                                               value="${item.id}" />
                                                        <label class="form-check-label">${item.name}</label>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                    <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">
                                        <h6 class="mb-0 me-4">Position </h6>
                                        <c:forEach items="${positions}" var="item">
                                            <c:choose>
                                                <c:when test="${employee.positions == item.id}">
                                                    <div class="form-check form-check-inline mb-0 me-4">
                                                        <input class="form-check-input" type="radio" name="positions"
                                                               value="${item.id}" checked/>
                                                        <label class="form-check-label" >${item.name}</label>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="form-check form-check-inline mb-0 me-4">
                                                        <input class="form-check-input" type="radio" name="positions"
                                                               value="${item.id}" />
                                                        <label class="form-check-label">${item.name}</label>
                                                    </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input type="text" name="phone" value="${employee.phone}" class="form-control form-control-lg" required/>
                                        <label class="form-label">Phone</label>
                                        <c:if test="${error != null}">
                                            <h3 style="color:red;">${error.get("phone")}</h3>
                                        </c:if>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="form3Example90" name="email" value="${employee.email}" class="form-control form-control-lg" required/>
                                        <label class="form-label" for="form3Example90">Email</label>
                                        <c:if test="${error != null}">
                                            <h3 style="color:red;">${error.get("email")}</h3>
                                        </c:if>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="form3Example99" name="address" value="${employee.address}" class="form-control form-control-lg" required/>
                                        <label class="form-label" for="form3Example99">Address</label>
                                    </div>

                                    <div class="d-flex justify-content-end pt-3">
                                        <button type="submit" class="btn btn-success btn-lg ms-2">Submit</button>
                                        <button type="reset" class="btn btn-warning btn-lg">Reset all</button>
                                       <a href="/employee?action=displayEmployee">
                                           <button type="button" class="btn btn-info btn-lg">Back List</button>
                                       </a>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>

</body>
</html>
