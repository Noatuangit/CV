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
    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="index.jsp">Home</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/customer?action=displayCustomer">Customer</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/employee?action=displayEmployee">Employee</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/service?action=displayService">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/contract?action=displayContract">Contract</a>
</nav>

<form method="post">
    <section class="vh-100" style="background-color: #2779e2;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-xl-9">
                    <h1 class="text-white mb-4">Contract Form</h1>
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <input type="hidden" name="id" value="${contracts.id}">
                            <div class="row align-items-center pt-4 pb-3">
                                <c:if test="${message!=null}">
                                    <h5 style="color:#ff0000;">${message}</h5>
                                </c:if>
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Day Begin</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input type="datetime-local" class="form-control form-control-lg" name="start_date"
                                           value="${contracts.start_day}"
                                           required/>
                                </div>
                            </div>
                            <hr class="mx-n3">
                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Day End</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input type="datetime-local" class="form-control form-control-lg" name="end_date"
                                           value="${contracts.end_day}"
                                           required/>
                                    <c:if test="${error != null}">
                                        <h3 style="color:red;">${error.get('end_date')}</h3>
                                    </c:if>
                                </div>
                            </div>
                            <hr class="mx-n3">
                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Deposit</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input class="form-control" type="number" placeholder="number deposit"
                                           name="deposit" value="${contracts.deposit}"
                                           required>
                                </div>
                            </div>
                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Total Money</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input class="form-control" type="number" placeholder="0 Vnd"
                                           value="${contracts.total_money}" name="total_money"
                                           readonly>
                                </div>
                            </div>
                            <hr class="mx-n3">
                            <div class="row align-items-center py-3">
                                <div class="card-body p-0">
                                    <div class="row g-0">
                                        <div class="col-lg-6">
                                            <div class="p-5">
                                                <div class="mb-12 pb-2">
                                                    <h1>Customer Rent</h1>
                                                    <label>
                                                        <select class="select" name="customers" required>
                                                            <c:forEach items="${customers}" var="item">
                                                                <c:choose>
                                                                    <c:when test="${contracts.customer_id == item.id}">
                                                                        <option value="${item.id}" selected>
                                                                            Name ${item.name}.
                                                                            Id Card ${item.id_card}.
                                                                            Email: ${item.email}.
                                                                            Phone ${item.phone}.
                                                                            Address ${item.address}
                                                                        </option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="${item.id}">
                                                                            Name ${item.name}.
                                                                            Id Card ${item.id_card}.
                                                                            Email: ${item.email}.
                                                                            Phone ${item.phone}.
                                                                            Address ${item.address}
                                                                        </option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </label>
                                                </div>
                                                <div class="mb-12 pb-2">
                                                    <h1>Employee Service</h1>
                                                    <label>
                                                        <select class="select" name="employees" required>
                                                            <c:forEach items="${employees}" var="item">
                                                                <c:choose>
                                                                    <c:when test="${contracts.employee_id == item.id}">
                                                                        <option value="${item.id}" selected>
                                                                            Name: ${item.name}.
                                                                            Id Card: ${item.id_card}.
                                                                            Email: ${item.email}.
                                                                            Phone: ${item.phone}.
                                                                            Address: ${item.address}
                                                                        </option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="${item.id}">
                                                                            Name: ${item.name}.
                                                                            Id Card: ${item.id_card}.
                                                                            Email: ${item.email}.
                                                                            Phone: ${item.phone}.
                                                                            Address: ${item.address}
                                                                        </option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach></select>
                                                    </label>
                                                </div>
                                                <div class="mb-12 pb-2">
                                                    <h1>Service Rent</h1>
                                                    <label>
                                                        <select class="select" name="services" onchange="getModal()"
                                                                required>
                                                            <c:forEach items="${services}" var="item">
                                                                <c:choose>
                                                                    <c:when test="${contracts.service_id == item.id}">
                                                                        <option value="${item.id}" selected>
                                                                            Name: ${item.name}.
                                                                            Cost: ${item.cost}$.
                                                                            Area to use: ${item.area}.
                                                                            Max people: ${item.max_people}.
                                                                        </option>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <option value="${item.id}">
                                                                            Name: ${item.name}.
                                                                            Cost: ${item.cost}$.
                                                                            Area to use: ${item.area}.
                                                                            Max people: ${item.max_people}.
                                                                            Floor: ${item.number_of_floors}.
                                                                            Description: ${item.description_other_convenience}.
                                                                            Standard room: ${item.standard_room}
                                                                        </option>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </c:forEach>
                                                        </select>
                                                    </label>
                                                </div>
                                            </div>
                                            <hr class="mx-n3">
                                            <div class="px-5 py-4">
                                                <button type="submit" class="btn btn-success btn-lg">Submit
                                                </button>
                                                <button type="reset" class="btn btn-warning btn-lg">Reset
                                                </button>
                                                <a href="/contract?action=displayContract">
                                                    <button type="button" class="btn btn-primary btn-lg">Back List
                                                    </button>
                                                </a>
                                            </div>
                                        </div>
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
