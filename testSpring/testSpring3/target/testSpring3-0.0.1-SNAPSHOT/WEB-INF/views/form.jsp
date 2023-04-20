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
                                            <label class="form-label" for="customer">
                                                Mã khách hàng <span class="error" id="customerError">

                                                 </span>
                                                <form:errors path="customer" cssClass="error">

                                                </form:errors> </label>
                                            <form:input type="hidden" path='id'/>
                                            <form:input type="hidden" path='idDetails'/>
                                            <form:input type="text" path='customer' id="customer" class="form-control"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="dateOrder">
                                                Ngày đặt may <span class="error"
                                                                   id="dateOrderError">
                                                  </span> </label>
                                            <form:input type="date" path="dateOrder" id="dateOrder" class="form-control"
                                                        onblur="change(event)"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="statusCheckOut">
                                                Trạng thái thanh toán <span class="error" id="statusCheckOutError">

                                                 </span> </label>
                                            <form:input type="text" path='statusCheckOut' id="statusCheckOut"
                                                        onblur="change(event)"
                                                        class="form-control"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="dateEnd">
                                                Ngày hẹn trả <span class="error"
                                                                   id="dateEndError">
                                                  </span> </label>
                                            <form:input type="date" path="dateEnd" id="dateEnd" class="form-control"
                                                        onblur="change(event)"/>
                                        </div>
                                    </div>
                                    <c:if test="${action == 'update'}">
                                        <div class="row">
                                            <div class="col-md-6 mb-4">
                                                <label class="form-label" for="statusOrder">
                                                    Trạng thái giao hàng
                                                    <span class="error" id="statusOrderError">
                                                 </span>
                                                </label>
                                                <form:input type="text" path='statusOrder' id="statusOrder"
                                                            class="form-control"
                                                            onblur="change(event)"/>
                                            </div>
                                            <div class="col-md-6 mb-4">
                                                <label class="form-label" for="datePay">
                                                    Ngày trả <span class="error"
                                                                   id="datePayError">
                                                  </span> </label>
                                                <form:input type="date" path="datePay" id="datePay"
                                                            class="form-control"
                                                            onblur="change(event)"/>
                                            </div>
                                        </div>
                                    </c:if>
                                    <br>
                                    <h3>Chi tiết đơn hàng</h3>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="name">
                                                Tên sản phẩm <span class="error" id="nameError">

                                                 </span> </label>
                                            <form:input type="text" path='name' id="name" class="form-control"
                                                        onblur="change(event)"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="money">
                                                Tiền <span class="error"
                                                           id="moneyError">
                                                  </span> </label>
                                            <form:errors path="money" cssClass="error">

                                            </form:errors>
                                            <form:input type="number" path="money" id="money" class="form-control"
                                                        onblur="change(event)"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12 mb-12">
                                            <label class="form-label" for="note">
                                                Ghi chú <span class="error"
                                                              id="noteError">
                                                  </span> </label>
                                            <form:input type="text" path="note" id="note" class="form-control"
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
