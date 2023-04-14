<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Service</title>
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
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
    <style>
        .error {
            color: red;
        }
    </style>

</head>
<body>
<%@include file="../header.jsp" %>
<section class="h-100 h-custom" style="background-color: #8fc4b7;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-8 col-xl-6">
                <div class="card rounded-3">
                    <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img3.webp"
                         class="w-100" style="border-top-left-radius: .3rem; border-top-right-radius: .3rem;"
                         alt="Sample photo">
                    <div class="card-body p-4 p-md-5">
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Booking Service</h3>
                        <form:form class="px-md-2" modelAttribute="detail"
                                   action="${pageContext.request.contextPath}/booking"
                                   method="post">
                            <div class="form-outline mb-4">
                                <select name="customer_id" id="customer_id" class="form-select"
                                        aria-label="Default select example">
                                    <option value="" disabled selected>--choice something--</option>
                                    <c:forEach items="${customers}" var="item">
                                        <option value="${item.id}">${item.name} have
                                            phone ${item.phone},email: ${item.email}</option>
                                    </c:forEach>
                                </select>
                                <label class="form-label" for="customer_id">Customer booking</label>
                                <form:errors path="customer_id" cssClass="error"/>
                            </div>

                            <div class="row">
                                <div class="col-md-12 mb-4">
                                    <div class="form-outline datepicker">
                                        <select name="service_id" id="service_id" class="form-select"
                                                aria-label="Default select example">
                                            <option value="" disabled selected>--choice something--</option>
                                            <c:forEach items="${services}" var="item">
                                                <option value="${item.id}">${item.name} have
                                                    price ${item.price}/1 ${item.unit}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="service_id" class="form-label">Service Booking</label>
                                        <form:errors path="service_id" cssClass="error"/>

                                    </div>

                                </div>

                            </div>
                            <div class="col-12">
                                <div class="col-md-12 mb-4">
                                    <input type="date" name="date_begin" id="date_begin" class="form-control">
                                    <label for="date_begin" class="form-label">Date begin</label>
                                    <form:errors path="date_begin" cssClass="error"/>
                                </div>
                            </div>

                            <div class="col-md-12">
                                <input type="time" name="time_begin" id="time_begin" class="form-control">
                                <label for="time_begin" class="form-label">Time Begin</label>
                                <form:errors path="time_begin" cssClass="error"/>
                            </div>

                            <div class="row mb-4 pb-2 pb-md-0 mb-md-5">
                                <div class="col-md-12">

                                    <div class="form-outline">
                                        <input type="text" id="amount" name="amount" class="form-control"/>
                                        <label class="form-label" for="amount">Amount</label>
                                    </div>
                                    <form:errors path="amount" cssClass="error"/>

                                </div>
                            </div>
                            <button type="submit" class="btn btn-success btn-lg mb-1">Submit</button>
                            <a href="${pageContext.request.contextPath}/managerService">
                                <button type="button" class="btn btn-info btn-lg mb-1">Back List</button>
                            </a>
                        </form:form>

                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<%@include file="../footer.jsp" %>
</body>
</html>
