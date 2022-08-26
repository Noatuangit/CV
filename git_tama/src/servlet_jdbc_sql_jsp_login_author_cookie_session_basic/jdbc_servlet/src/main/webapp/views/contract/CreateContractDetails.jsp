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
    <section class="h-100 h-custom gradient-custom-2">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12">
                    <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                        <div class="card-body p-0">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <h3 class="fw-normal mb-5" style="color: #4835d4;">Contact Info</h3>
                                        <div class="mb-4 pb-2">
                                            <input type="hidden" name="id" value="${contracts.id}">
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" id="form3Examplev2"
                                                           value="${contracts.start_day}"
                                                           class="form-control form-control-lg" readonly/>
                                                    <label class="form-label" for="form3Examplev2">Start Date</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" id="form3Examplev3"
                                                           value="${contracts.end_day}"
                                                           class="form-control form-control-lg" readonly/>
                                                    <label class="form-label" for="form3Examplev3">End date</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" id="form3Examplev1"
                                                           value="${contracts.deposit}"
                                                           class="form-control form-control-lg" readonly/>
                                                    <label class="form-label" for="form3Examplev1">Deposit</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6 mb-4 pb-2">

                                                <div class="form-outline">
                                                    <input type="text" id="form3Examplev0"
                                                           value="${contracts.total_money}"
                                                           class="form-control form-control-lg" readonly/>
                                                    <label class="form-label" for="form3Examplev0">Total Money</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-12 mb-4 pb-2">
                                                <c:forEach items="${customers}" var="item">
                                                    <c:if test="${contracts.customer_id == item.id}">
                                                        <label class="form-label" for="form3Examplev6">Customer </label>
                                                        <input type="text" id="form3Examplev6" value="Name ${item.name}. Id Card ${item.id_card}"
                                                               class="form-control form-control-lg" readonly/>

                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                            <div class="col-md-12 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <c:forEach items="${services}" var="item">
                                                        <c:if test="${contracts.service_id == item.id}">
                                                            <label class="form-label" for="form3Examplev6">Service </label>
                                                            <input type="text" id="form3Examplev6" value="Name: ${item.name}. Cost: ${item.cost}$. Area to use: ${item.area}. Max people: ${item.max_people}."
                                                                   class="form-control form-control-lg" readonly/>

                                                        </c:if>
                                                    </c:forEach>
                                                </div>
                                            </div>
                                            <div class="col-md-12 mb-4 pb-2">
                                                <c:forEach items="${employees}" var="item">
                                                    <c:if test="${contracts.employee_id == item.id}">
                                                        <label class="form-label" for="form3Examplev6">Employee </label>
                                                        <input type="text" id="form3Examplev6" value="Name ${item.name}. Id Card ${item.id_card}"
                                                               class="form-control form-control-lg" readonly/>

                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 bg-indigo text-white">
                                    <div class="p-5">
                                        <h3 class="fw-normal mb-5" style="color: black">Contact Details</h3>
                                        <c:if test="${message != null}">
                                            <h3 style="color:red;">${message}</h3>
                                        </c:if>
                                        <div class="mb-4 pb-2">
                                            <label class="form-label" style="color: black">Attach
                                                Service</label>
                                            <select class="select" name="attach_service_id" required>
                                                <c:forEach items="${addOnList}" var="item">
                                                    <option value="${item.id}">
                                                        ID: ${item.name}
                                                        . Name: ${item.name}
                                                        . Cost: ${item.cost}
                                                        . Unit: ${item.unit}
                                                        . Status: ${item.status}
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="mb-4 pb-2">
                                            <div class="form-outline form-white">
                                                <label class="form-label" for="form3Examplea11" style="color: black">
                                                    Quantity </label>
                                                <input type="number" id="form3Examplea11" name="quantity" min="0"
                                                       class="form-control form-control-lg" required/>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-success btn-lg"
                                                data-mdb-ripple-color="dark">Booking Details
                                        </button>
                                        <button type="reset" class="btn btn-warning btn-lg"
                                                data-mdb-ripple-color="dark">Reset
                                        </button>
                                        <a href="/contract?action=displayContract">
                                            <button type="button" class="btn btn-primary btn-lg ms-2">Back List</button>
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
