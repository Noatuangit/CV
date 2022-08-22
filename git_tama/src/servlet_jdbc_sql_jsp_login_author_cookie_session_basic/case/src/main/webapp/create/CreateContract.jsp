<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.extra.TypeCustomer" %>
<%@ page import="java.util.List" %>
<%@ page import="models.person.Customer" %>
<%@ page import="models.person.Employee" %>
<%@ page import="models.professional_furama.Service" %>
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
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayCustomer">Customer</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayEmployee">Employee</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="<c:url value="/list?action=displayService"/>">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayContract">Contract</a>
</nav>

<form method="post">
    <section class="vh-100" style="background-color: #2779e2;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-xl-9">

                    <h1 class="text-white mb-4">Create Contract Form</h1>

                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body">
                            <% String message = (String) request.getAttribute("message");%>
                            <%if (message != null) {%>
                            <div class="col-md-3 ps-5">
                                <h6>
                                    <%=message%>
                                </h6>
                            </div>
                            <%}%>
                            <div class="row align-items-center pt-4 pb-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Day Begin</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input type="datetime-local" class="form-control form-control-lg" name="start_date"
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
                                           required/>
                                </div>
                            </div>

                            <hr class="mx-n3">

                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">

                                    <h6 class="mb-0">Deposit</h6>

                                </div>
                                <div class="col-md-9 pe-5">
                                    <input class="form-control" type="number" placeholder="number deposit"
                                           name="deposit" min="0"
                                           required></input>
                                </div>
                            </div>
                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">

                                    <h6 class="mb-0">Total Money</h6>

                                </div>
                                <div class="col-md-9 pe-5">
                                    <input class="form-control" type="number" placeholder="0 Vnd" min="0" value="0"
                                           id="money" name="total_money"
                                           readonly></input>
                                </div>
                            </div>
                            <hr class="mx-n3">
                            <div class="row align-items-center py-3">
                                <div class="card-body p-0">
                                    <div class="row g-0">
                                        <div class="col-lg-6">
                                            <div class="p-5">
                                                <div class="mb-6 pb-2">
                                                    <h1>Customer Rent</h1>
                                                    <%List<Customer> customers = (List<Customer>) request.getAttribute("customers");%>
                                                    <select class="select" name="customers" required>
                                                        <c:forEach items="<%=customers%>" var="item">
                                                            <option value="${item.id}">Id:
                                                                <c:out value="${item.id}"></c:out>. Id card:
                                                                <c:out value="${item.id_card}"></c:out>. Name:
                                                                <c:out value="${item.name}"></c:out>
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="mb-6 pb-2">
                                                    <h1>Employee </h1>
                                                    <%List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>
                                                    <select class="select" name="employees" required>
                                                        <c:forEach items="<%=employees%>" var="item">
                                                            <option value="${item.id}">Id:
                                                                <c:out value="${item.id}"></c:out>. Id card:
                                                                <c:out value="${item.id_card}"></c:out>. Name:
                                                                <c:out value="${item.name}"></c:out>
                                                            </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                                <div class="mb-6 pb-2">
                                                    <h1>Service Rent</h1>
                                                    <%List<Service> services = (List<Service>) request.getAttribute("services");%>
                                                    <select class="select" name="services" required>
                                                        <c:forEach items="<%=services%>" var="item">
                                                            <option value="${item.id}">Id:
                                                                <c:out value="${item.id}"></c:out>. Name:
                                                                <c:out value="${item.name}"></c:out></option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                            <hr class="mx-n3">
                                            <div class="px-5 py-4">
                                                <button type="submit" class="btn btn-success btn-lg">Create New
                                                </button>
                                                <button type="reset" class="btn btn-warning btn-lg">Reset
                                                </button>
                                                <a href="${pageContext.request.contextPath}/list?action=displayContract">
                                                    <button type="button" class="btn btn-primary btn-lg ms-2">Back
                                                        List
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
