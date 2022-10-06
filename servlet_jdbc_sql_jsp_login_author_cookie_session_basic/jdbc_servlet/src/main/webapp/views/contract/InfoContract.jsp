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
    <a class="flex-sm-fill text-sm-center nav-link" href="/contract?action=displayContract">Contract</a></nav>
<section class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
    <div class="mask d-flex align-items-center h-100 gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Info Contract</h2>
                            <div class="form-outline mb-4">
                                <input type="datetime-local" value="${contracts.start_day}"
                                       class="form-control form-control-lg" readonly/>
                                <label class="form-label">Start Day</label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="datetime-local" value="${contracts.end_day}"
                                       class="form-control form-control-lg" readonly/>
                                <label class="form-label">End Day</label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="number" value="${contracts.deposit}"
                                       class="form-control form-control-lg" readonly/>
                                <label class="form-label">Deposit</label>
                            </div>

                            <div class="form-outline mb-4">
                                <c:forEach items="${employees}" var="item">
                                    <c:if test="${contracts.employee_id == item.id}">
                                        <label class="form-label" for="form3Examplev6">Employee </label>
                                        <input type="text" id="form3Examplev6"
                                               value="Name ${item.name}. Id Card ${item.id_card}"
                                               class="form-control form-control-lg" readonly/>

                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="form-outline mb-4">
                                <c:forEach items="${customers}" var="item">
                                    <c:if test="${contracts.customer_id == item.id}">
                                        <label class="form-label" for="form3Examplev6">Customer </label>
                                        <input type="text" id="form3Examplev6"
                                               value="Name ${item.name}. Id Card ${item.id_card}"
                                               class="form-control form-control-lg" readonly/>

                                    </c:if>
                                </c:forEach>
                            </div>
                            <div class="form-outline mb-4">
                                <c:forEach items="${services}" var="item">
                                    <c:if test="${contracts.service_id == item.id}">
                                        <label class="form-label" for="form3Examplev6">Service </label>
                                        <input type="text" id="form3Examplev6"
                                               value="Name: ${item.name}. Cost: ${item.cost}$. Area to use: ${item.area}. Max people: ${item.max_people}."
                                               class="form-control form-control-lg" readonly/>

                                    </c:if>
                                </c:forEach>
                            </div>
                            <c:forEach items="${details}" var="item">
                                <c:forEach items="${addOnList}" var="check">
                                    <c:if test="${item.id_attach_service == check.id}">
                                        <label class="form-label">Add On Service </label>
                                        <input type="text"
                                               value="Name: ${check.name}, Unit: ${check.unit}, Cost ${check.cost}" class="form-control form-control-lg" readonly/>
                                    </c:if>
                                </c:forEach>
                                <div class="form-outline mb-4">
                                    <label class="form-label">Quantity </label>
                                    <input type="number"
                                           value="${item.quantity}" class="form-control form-control-lg" readonly/>
                                </div>
                            </c:forEach>
                            <a href="/contract?action=displayContract">
                                <button class="btn btn-info btn-lg">Back Contract</button>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
