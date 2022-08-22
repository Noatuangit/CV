<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.extra.TypeCustomer" %>
<%@ page import="java.util.List" %>
<%@ page import="models.person.Customer" %>
<%@ page import="models.person.Employee" %>
<%@ page import="models.professional_furama.Service" %>
<%@ page import="models.professional_furama.Contract" %>
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
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayService">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayContract">Contract</a>
</nav>

<form method="post">
    <section class="vh-100" style="background-color: #2779e2;">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-xl-9">

                    <h1 class="text-white mb-4">Edit Contract Form</h1>
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
                            <% Contract contract = (Contract) request.getAttribute("contract");%>
                            <input type="hidden" name="id" value="<%=contract.getId()%>">
                            <div class="row align-items-center pt-4 pb-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">ID : <%=contract.getId()%></h6>
                                </div>
                                <input type="hidden" name="id" value="<%=contract.getId()%>">
                            </div>
                            <div class="row align-items-center pt-4 pb-3">
                                <div class="col-md-3 ps-5">
                                    <h6 class="mb-0">Day Begin</h6>
                                </div>
                                <div class="col-md-9 pe-5">
                                    <input type="datetime-local" class="form-control form-control-lg" name="start_date"
                                           value="<%=contract.getStart_day()%>"
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
                                           value="<%=contract.getEnd_day()%>"
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
                                           name="deposit" min="0" value="<%=contract.getDeposit()%>"
                                           required></input>
                                </div>
                            </div>
                            <div class="row align-items-center py-3">
                                <div class="col-md-3 ps-5">

                                    <h6 class="mb-0">Total Money</h6>

                                </div>
                                <div class="col-md-9 pe-5">
                                    <input class="form-control" type="number" placeholder="0 Vnd" min="0"
                                           value="<%=contract.getTotal_money()%>" name="total_money"
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
                                                    <label>
                                                        <select class="select" name="customers" required>
                                                            <% for (Customer customer : customers) {%>
                                                            <option value="<%=customer.getId()%>"
                                                                    <%if (customer.getId() == Integer.parseInt(contract.getCustomer_id())) {%>
                                                                    selected <%}%>>ID <%=customer.getId()%>.
                                                                Name <%=customer.getName()%>
                                                            </option>
                                                            <%}%>
                                                        </select>
                                                    </label>
                                                </div>
                                                <div class="mb-6 pb-2">
                                                    <h1>Employee </h1>
                                                    <%List<Employee> employees = (List<Employee>) request.getAttribute("employees");%>
                                                    <label>
                                                        <select class="select" name="employees" required>
                                                            <% for (Employee employee : employees) {%>
                                                            <option value="<%=employee.getId()%>"
                                                                    <%if (employee.getId() == Integer.parseInt(contract.getEmployee_id())) {%>
                                                                    selected <%}%>>ID <%=employee.getId()%>.
                                                                Name <%=employee.getName()%>
                                                            </option>
                                                            <%}%>
                                                        </select>
                                                    </label>
                                                </div>
                                                <div class="mb-6 pb-2">
                                                    <h1>Service Rent</h1>
                                                    <%List<Service> services = (List<Service>) request.getAttribute("services");%>
                                                    <label>
                                                        <select class="select" name="services" required>
                                                            <% for (Service service : services) {%>
                                                            <option value="<%=service.getId()%>"
                                                                    <%if (service.getId() == Integer.parseInt(contract.getService_id())) {%>
                                                                    selected <%}%>>ID <%=service.getId()%>.
                                                                Name <%=service.getName()%>
                                                            </option>
                                                            <%}%>
                                                        </select>
                                                    </label>
                                                </div>
                                            </div>
                                            <hr class="mx-n3">
                                            <div class="px-5 py-4">
                                                <button type="submit" class="btn btn-success btn-lg">Update
                                                </button>
                                                <button type="reset" class="btn btn-warning btn-lg">Reset
                                                </button>
                                                <a href="/list?action=displayContract">
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
