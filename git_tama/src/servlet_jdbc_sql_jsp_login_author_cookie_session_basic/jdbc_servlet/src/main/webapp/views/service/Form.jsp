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
<section class="h-100 h-custom" style="background-color: #8fc4b7;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Service Form</h3>

                        <form method="post">
                                <input type="hidden" id="form3Example1q" class="form-control" name="id"
                                       value="${service.id}">
                            <c:if test="${message != null}">
                                <h3 style="color:red;">${message}</h3>
                            </c:if>
                            <div class="row">
                                <div class="col-md-8 mb-4">
                                    <div class="form-outline datepicker">
                                        <label for="exampleDatepicker1" class="form-label">Name Service</label>
                                        <input type="text" class="form-control" id="exampleDatepicker1" name="name"
                                               value="${service.name}" required/>
                                    </div>
                                    <div class="form-outline datepicker">
                                        <label for="exampleDatepicker2" class="form-label">Area Service</label>
                                        <input type="number" class="form-control" id="exampleDatepicker2" name="area"
                                               value="${service.area}" required/>
                                        <c:if test="${error != null}">
                                            <h3 style="color:red;">${error.get('area')}</h3>
                                        </c:if>
                                    </div>
                                    <div class="form-outline datepicker">
                                        <label for="exampleDatepicker3" class="form-label">Service Cost</label>

                                        <input type="number" class="form-control" id="exampleDatepicker3" name="cost"
                                               value="${service.cost}" required/>
                                        <c:if test="${error != null}">
                                            <h3 style="color:red;">${error.get('cost')}</h3>
                                        </c:if>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <p>Rent Type</p>
                                    <select class="select" name="rent">
                                        <c:forEach items="${listRent}" var="item">
                                            <c:choose>
                                                <c:when test="${service.rent_type == item.id}">
                                                    <option value="${item.id}" selected>
                                                            ${item.name} have cost ${item.rent_type_cost}
                                                    </option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${item.id}">
                                                            ${item.name} have cost ${item.rent_type_cost}
                                                    </option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <p>Service Type</p>
                                    <select class="select" name="type">
                                        <c:forEach items="${listService}" var="item">
                                            <c:choose>
                                                <c:when test="${service.service_type == item.id}">
                                                    <option value="${item.id}" selected>
                                                            ${item.name}
                                                    </option>
                                                </c:when>
                                                <c:otherwise>
                                                    <option value="${item.id}">
                                                            ${item.name}
                                                    </option>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="row mb-8 pb-2 pb-md-0 mb-md-5">
                                <div class="col-md-6">
                                    <div class="form-outline">
                                        <label class="form-label">Max People</label>
                                        <input type="number" class="form-control" name="max_people"
                                               value="${service.max_people}" required/>
                                        <c:if test="${error != null}">
                                            <h3 style="color:red;">${error.get('max_people')}</h3>
                                        </c:if>
                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Standard Room</label>
                                        <input type="text" class="form-control" name="standard_room"
                                               value="${service.standard_room}"
                                               required/>
                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Description</label>
                                        <input type="text" class="form-control" name="description_other_convenience"
                                               value="${service.description_other_convenience}"
                                               required/>

                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Pool Area</label>
                                        <input type="number" class="form-control" name="pool_area"
                                               value="${service.pool_area}" required/>
                                        <c:if test="${error != null}">
                                            <h3 style="color:red;">${error.get('pool_area')}</h3>
                                        </c:if>

                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Number Floors</label>
                                        <input type="number" class="form-control" name="number_of_floors"
                                               value="${service.number_of_floors}" required/>
                                        <c:if test="${error != null}">
                                            <h3 style="color:red;">${error.get('number_of_floors')}</h3>
                                        </c:if>

                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Facility Text</label>

                                        <input type="text" class="form-control" name="facility_text"
                                               value="${service.facility_text}"
                                               required/>
                                    </div>

                                </div>
                            </div>
                            <button type="submit" class="btn btn-success btn-lg mb-1">Update</button>
                            <button type="reset" class="btn btn-warning btn-lg mb-1">Reset</button>
                            <a href="/service?action=displayService">
                                <button type="button" class="btn btn-primary btn-lg mb-1">Back List</button>
                            </a>
                        </form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
