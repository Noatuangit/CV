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
                        <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Service form controller</h3>
                        <form:form action="${pageContext.request.contextPath}/service"
                                   method="post" modelAttribute="service">
                            <div class="form-outline mb-4">
                                <form:input id="form3Example1q" class="form-control" path="name"/>
                                <form:input id="form3Example1q" cssStyle="display: none" class="form-control" path="id"/>
                                <form:label path="name" class="form-label" for="form3Example1q">Name</form:label>
                                <form:errors path="name" cssStyle="color: red">

                                </form:errors>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline">
                                        <div class="form-outline datepicker">
                                            <form:label path="unit" for="exampleDatepicker2"
                                                        cssClass="form-label form-check">Unit</form:label>
                                            <ul class="list-group">
                                                <c:forEach items="${units}" var="item">
                                                    <li class="list-group-item">
                                                        <label for="flexRadioDefault1"></label>
                                                        <input class="form-check-input"
                                                               value="${item}"
                                                            ${item == service.unit ? "checked": ""}
                                                               type="radio"
                                                               name="unit"
                                                               id="flexRadioDefault1">
                                                            ${item}
                                                    </li>
                                                </c:forEach>

                                            </ul>
                                            <form:errors path="unit" cssStyle="color: red">

                                            </form:errors>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6 mb-4">
                                    <div class="form-outline datepicker">
                                        <input type="number" class="form-control" id="exampleDatepicker3" name="price"
                                               value="${service.price}"
                                               min="1" required/>
                                        <label for="exampleDatepicker3" class="form-label">Price</label>
                                        <form:errors path="price" cssStyle="color: red">

                                        </form:errors>
                                    </div>
                                </div>
                            </div>

                            <button type="submit" class="btn btn-success mb-1">Submit</button>

                            <a href="${pageContext.request.contextPath}/service" style="margin-right: 5px">
                                <button type="button" class="btn btn-secondary">Back
                                    list
                                </button>
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