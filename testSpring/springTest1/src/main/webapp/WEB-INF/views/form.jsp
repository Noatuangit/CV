<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order</title>
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
    <link rel="stylesheet" type="text/css" href="resources/layout.css"/>
    <script src="resources/controller.js"></script>
</head>
<body>
<div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-body">
            <section class="h-70">
                <div class="container">
                    <div class="col-lg-12 col-xl-12">
                        <div class="card rounded-3">
                            <div class="card-body p-12 p-md-12">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Form Information</h3>
                                <form:form class="px-md-2" style="text-align: left"
                                           action="${pageContext.request.contextPath}/${action}" method="post"
                                           modelAttribute="order">
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="name">
                                                Name Customer <span class="error" id="nameError">
                                            </span> </label>
                                            <form:input type="hidden" path='id'/>
                                            <form:input type="text" path='name' id="name" class="form-control"
                                                        onblur="change(event)"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="typeId">
                                                Type Customer <span class="error">
                                                <form:errors path="typeId" id="typeIdExists">

                                                </form:errors>
                                                    </span>
                                                <span class="error" id="typeIdError">
                                            </span> </label>
                                            <form:input type="text" path='typeId' id="typeId" class="form-control"
                                                        onblur="change(event)" readonly="${ action == 'edit'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <label class="form-label" for="persons">
                                                    Persons
                                                    <span class="error" id="personsError">
                                            </span>

                                                </label>
                                                <form:input type="number" path='persons' id="persons" min="1"
                                                            onblur="change(event)" class="form-control"
                                                        />
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <label class="form-label" for="children">
                                                    Children <span class="error">
                                                    <span class="error" id="children_Error">
                                                       <form:errors path="children">
                                                       </form:errors>
                                                    </span>
                                                    <span class="error" id="childrenError">
                                                    </span>
                                                </span> </label>
                                                <form:input type="number" path='children' id="children"
                                                            onblur="change(event)"
                                                            onchange="checkValid()"
                                                            class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-4 ">
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <label class="form-label" for="dateOrder">
                                                    Day begin
                                                    <span class="error" id="dateOrderError">
                                                    </span> </label>
                                                <form:input type="date" path='dateOrder' id="dateOrder" onblur="change(event)"
                                                            readonly="${action == 'edit'}"
                                                            class="form-control"/>

                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <div class="form-outline">
                                                <label class="form-label" for="timeIn">
                                                    Time Begin <span class="error" id="timeInError">
                                                    </span> </label>
                                                <form:input onblur="change(event)" type="time" path='timeIn' id="timeIn"
                                                            class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row mb-4">
                                        <label class="form-label" for="phone">
                                            Phone <span class="error">
                                               <span class="error" id="phoneError">
                                                    </span>  </span>
                                        </label>
                                        <form:input type="text" path='phone' id="phone" class="form-control"
                                                    onblur="change(event)"
                                                    readonly="${ action == 'edit'}"/>
                                    </div>
                                    <c:if test="${message != null}">
                                        <p style="color: red">${message}</p>
                                    </c:if>
                                    <div class="modal-footer">
                                        <a href="${pageContext.request.contextPath}/">
                                            <button type="button" id="closeButton" class="btn btn-warning">Close
                                            </button>
                                        </a>
                                        <button id="button-submit" type="submit" class="btn btn-primary" disabled>Save
                                            changes
                                        </button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>
</body>

</html>
