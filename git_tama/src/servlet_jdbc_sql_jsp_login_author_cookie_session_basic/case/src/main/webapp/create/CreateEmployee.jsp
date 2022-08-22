<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="models.extra.Education" %>
<%@ page import="models.extra.Division" %>
<%@ page import="models.extra.Position" %>
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
    <section class="h-100 bg-dark">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col">
                    <div class="card card-registration my-4">
                        <div class="row g-0">
                            <div class="col-xl-6">
                                <div class="card-body p-md-5 text-black">
                                    <h3 class="mb-5 text-uppercase">Employee registration form</h3>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="text" id="form3Example1m" name="id" min="0"
                                                       class="form-control form-control-lg" required/>
                                                <label class="form-label" for="form3Example1m">Id</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="text" id="form3Example1n" name="name"
                                                       class="form-control form-control-lg" required
                                                       pattern="^[a-zA-Z ,.'-]+$"/>
                                                <label class="form-label" for="form3Example1n">Name</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="date" id="form3Example1m1" name="birthday"
                                                       placeholder="dd-mm-yyyy"
                                                       class="form-control form-control-lg" required/>
                                                <label class="form-label" for="form3Example1m1">Birthday</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <input type="text" id="form3Example1n1" name="id_card"
                                                       placeholder="NV-xxx number"
                                                       class="form-control form-control-lg" required
                                                       pattern="^NV-\d{3}$"/>
                                                <label class="form-label" for="form3Example1n1">Id Card</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="number" id="form3Example8" class="form-control form-control-lg"
                                               min="0"
                                               name="salary" required/>
                                        <label class="form-label" for="form3Example8">Salary</label>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-3 mb-4">
                                            <%List<Education> educations = (List<Education>) request.getAttribute("educations");%>
                                            <h4> Education </h4>
                                            <label>

                                                <select class="select" name="educations" required>
                                                    <c:forEach items="<%=educations%>" var='item'>
                                                        <option value="<c:out value="${item.id}"></c:out>">
                                                            <c:out value="${item.name}"></c:out>
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3 mb-4">
                                            <%List<Division> divisions = (List<Division>) request.getAttribute("divisions");%>
                                            <h4> Division </h4>
                                            <label>
                                                <select class="select" name="divisions" required>
                                                    <c:forEach items="<%=divisions%>" var='item'>
                                                        <option value="<c:out value="${item.id}"></c:out>">
                                                            <c:out value="${item.name}"></c:out>
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </label>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-3 mb-4">
                                            <%List<Position> positions = (List<Position>) request.getAttribute("positions");%>
                                            <h4> Position </h4>
                                            <select class="select" name="positions" required>
                                                <c:forEach items="<%=positions%>" var='item'>
                                                    <option value="<c:out value="${item.id}"></c:out>">
                                                        <c:out value="${item.name}"></c:out>
                                                    </option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>


                                    <div class="form-outline mb-4">
                                        <input type="text" id="form3Example9" class="form-control form-control-lg"
                                               name="phone" required pattern="^0\d{9}$"/>
                                        <label class="form-label" for="form3Example9">Phone</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="email" id="form3Example90" class="form-control form-control-lg"
                                               name="email" required/>
                                        <label class="form-label" for="form3Example90">Email</label>
                                    </div>

                                    <div class="form-outline mb-4">
                                        <input type="text" id="form3Example99" class="form-control form-control-lg"
                                               name="address" required/>
                                        <label class="form-label" for="form3Example99">Address</label>
                                    </div>

                                    <div class="d-flex justify-content-end pt-3">
                                        <button type="reset" class="btn btn-warning btn-lg">Reset All</button>
                                        <button type="submit" class="btn btn-success btn-lg ms-2">Submit Form</button>
                                        <a href="/list?action=displayEmployee">
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
