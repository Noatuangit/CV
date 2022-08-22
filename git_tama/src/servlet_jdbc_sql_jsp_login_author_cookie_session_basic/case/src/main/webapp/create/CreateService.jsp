<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.sun.org.apache.xpath.internal.operations.Div" %>
<%@ page import="models.extra.*" %>
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

                        <form class="px-md-2" method="post">

                            <div class="form-outline mb-4">
                                <input type="number" id="form3Example1q" class="form-control" name="id" required/>
                                <label class="form-label" for="form3Example1q">Id</label>
                            </div>

                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline datepicker">
                                        <label for="exampleDatepicker1" class="form-label">Name Service</label>
                                        <input type="text" class="form-control" id="exampleDatepicker1" name="name"
                                               min="0" required/>
                                    </div>
                                    <div class="form-outline datepicker">
                                        <label for="exampleDatepicker2" class="form-label">Area Service</label>
                                        <input type="number" class="form-control" id="exampleDatepicker2" name="area"
                                               min="0" required/>

                                    </div>
                                    <div class="form-outline datepicker">
                                        <label for="exampleDatepicker3" class="form-label">Service Cost</label>

                                        <input type="number" class="form-control" id="exampleDatepicker3" name="cost"
                                               min="0" required/>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <p>Rent Type</p>
                                    <%List<RentType> typeList = (List<RentType>) request.getAttribute("listRent");%>
                                    <select class="select" name="rent">
                                        <c:forEach items="<%=typeList%>" var="item">
                                            <option value="${item.id}"><c:out value="${item.name}"></c:out></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <p>Service Type</p>
                                    <%List<ServiceType> serviceTypes = (List<ServiceType>) request.getAttribute("listService");%>
                                    <select class="select" name="type">
                                        <c:forEach items="<%=serviceTypes%>" var="item">
                                            <option value="${item.id}"><c:out value="${item.name}"></c:out></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>

                            <div class="row mb-4 pb-2 pb-md-0 mb-md-5">
                                <div class="col-md-6">

                                    <div class="form-outline">
                                        <label class="form-label">Max People</label>
                                        <input type="number" class="form-control" name="max_people" min="0" required/>
                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Standard Room</label>
                                        <input type="text" class="form-control" name="standard_room"
                                               required/>
                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Description</label>
                                        <input type="text" class="form-control" name="description_other_convenience"
                                               required/>

                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Pool Area</label>
                                        <input type="number" class="form-control" name="pool_area"
                                               min="0" required/>

                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Number Floors</label>
                                        <input type="number" class="form-control" name="number_of_floors"
                                               min="0" required/>

                                    </div>
                                    <div class="form-outline">
                                        <label class="form-label">Facility Text</label>

                                        <input type="text" class="form-control" name="facility_text"
                                               required/>
                                    </div>

                                </div>
                            </div>
                            <button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>
                            <button type="reset" class="btn btn-warning btn-lg mb-1">Reset</button>
                            <a href="/list?action=displayService">
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
