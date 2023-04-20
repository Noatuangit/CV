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
<%@include file="header.jsp" %>

<div class="modal-dialog modal-lg">
    <div class="modal-content">
        <div class="modal-body">
            <section class="h-70">
                <div class="container">
                    <div class="col-lg-12 col-xl-12">
                        <div class="card rounded-3">
                            <div class="card-body p-12 p-md-12">
                                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5 px-md-2">Form Information</h3>
                                <form:form class="px-md-2" style="text-align: left" id="form"
                                           action="${pageContext.request.contextPath}/${action}" method="post"
                                           modelAttribute="item">
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="idCard">
                                                Căn cước công dân <span class="error" id="idCardError">
                                                 </span>
                                                <form:errors path="idCard" cssClass="error" id="existsIdCard">

                                                </form:errors> </label>
                                            <form:input type="text" path='idCard' id="idCard" class="form-control"
                                                        readonly="${action =='update'}"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="name">
                                                Họ tên <span class="error"
                                                             id="nameError">
                                                  </span> </label>
                                            <form:input type="text" path="name" id="name" class="form-control"
                                                        onblur="change(event)"
                                                        readonly="${ action == 'update'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="birthday">
                                                Ngày sinh <span class="error" id="birthdayError">

                                                 </span>
                                            </label>
                                            <form:input type="date" path='birthday' id="birthday" class="form-control"
                                                        readonly="${ action == 'update'}"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="gender">
                                                Giới tính <span class="error"
                                                                id="genderError">
                                                  </span> </label>
                                            <form:input type="gender" path="gender" id="gender" class="form-control"
                                                        onblur="change(event)"
                                                        readonly="${ action == 'update'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="phone">
                                                Số điện thoại <span class="error" id="phoneError">

                                                 </span>
                                                <form:errors path="phone" cssClass="error" id="existsPhone">

                                                </form:errors>
                                            </label>
                                            <form:input type="text" path='phone' id="phone" class="form-control"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="status">
                                                Trạng thái tiêm <span class="error"
                                                                      id="statusError">
                                                  </span> </label>
                                            <select name="status" id="status" class="form-control"
                                                    onblur="change(event)">
                                                <option value="">Choice Something!</option>
                                                <c:forEach items="${statusList}" var="check">
                                                    <option value="${check}" ${check == item.status ? "selected": ""}>${check}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="result">
                                                Kết quả tiêm <span class="error" id="resultError">

                                                 </span>
                                            </label>
                                            <form:input type="text" path='result' id="result" class="form-control"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="dayTest">
                                                Ngày xét nghiệm <span class="error"
                                                                      id="dayTestError">
                                                  </span> </label>
                                            <form:input type="date" path="dayTest" id="dayTest" class="form-control"
                                                        onblur="change(event)"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="dayOrder">
                                                Ngày đặt vé <span class="error" id="dayOrderError">

                                                 </span>
                                            </label>
                                            <form:input type="date" path='dayOrder' id="dayOrder" class="form-control"
                                                        readonly="${ action == 'update'}"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="dayBegin">
                                                Ngày xuất phát <span class="error"
                                                                     id="dayBeginError">
                                                  </span> </label>
                                            <form:input type="date" path="dayBegin" id="dayBegin" class="form-control"
                                                        onblur="change(event)"
                                                        readonly="${ action == 'update'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="placeIn">
                                                Điểm xuất phát <span class="error" id="placeInError">

                                                 </span>
                                            </label>
                                            <form:input type="text" path='placeIn' id="placeIn" class="form-control"
                                                        readonly="${ action == 'update'}"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="placeOut">
                                                Điểm đến <span class="error"
                                                               id="placeOutError">
                                                  </span> </label>
                                            <form:input type="text" path="placeOut" id="placeOut" class="form-control"
                                                        onblur="change(event)"
                                                        readonly="${ action == 'update'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12 mb-12">
                                            <label class="form-label" for="carId">
                                                Biển số xe <span class="error" id="carIdError">

                                                 </span>
                                                <form:errors path="carId" cssClass="error" id="existsCarId">

                                                </form:errors>
                                            </label>
                                            <form:input type="text" path='carId' id="carId" class="form-control"
                                                        readonly="${ action == 'update'}"
                                                        onblur="change(event)"/>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                        <a href="${pageContext.request.contextPath}/">
                                            <button type="button" id="closeButton" class="btn btn-warning">Close
                                            </button>
                                        </a>
                                        <button type="submit" class="btn btn-primary" id="button-submit" disabled>Save
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
<%@include file="footer.jsp" %>
</body>
</html>
