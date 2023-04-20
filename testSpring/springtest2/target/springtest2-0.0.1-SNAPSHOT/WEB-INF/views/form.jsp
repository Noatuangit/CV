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
                                           modelAttribute="bill">
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="idPlate">
                                                Id Plate <span class="error" id="idPlateError">

                                                 </span> </label>
                                            <form:input type="hidden" path='id'/>
                                            <form:input type="text" path='idPlate' id="idPlate" class="form-control"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="building">
                                                Building id <span class="error"
                                                                  id="buildingError">
                                                  </span> </label>
                                            <form:input type="text" path='building' id="building" class="form-control"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="area">
                                                Area <span class="error" id="areaError">
                                              </span> </label>
                                            <form:input type="number" path='area' id="area" class="form-control"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="name">
                                                Name Customer <span class="error" id="nameError">
                                                </span> </label>
                                            <form:input type="text" path='name' id="name" class="form-control"
                                                        onblur="change(event.target.id)"
                                            />
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="phone">
                                                Phone <span class="error" id="phoneError">
                                                </span> </label>
                                            <form:input type="text" path='phone' id="phone" class="form-control"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="monthJoin">
                                                Month Join <span class="error" id="monthJoinError"
                                            >
                                                </span> </label>
                                            <form:input type="date" path='monthJoin' id="monthJoin" class="form-control"
                                                        readonly="${ action == 'edit'}"/>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="numberMonth">
                                                Number Month <span class="error" id="numberMonthError"
                                            >
                                               </span>
                                                <c:if test="${message != null}">
                                                    <span class="error">
                                                            ${message}
                                                    </span>
                                                </c:if>
                                            </label>
                                            <form:input type="number" path='numberMonth' id="numberMonth"
                                                        class="form-control"
                                            />
                                        </div>
                                        <div class="col-md-6 mb-4">
                                            <label class="form-label" for="dayEnd">
                                                Day End <span class="error" id="dayEndError">
                                            </span> </label>
                                            <form:input type="date" path='dayEnd' id="dayEnd" class="form-control"
                                            />
                                        </div>
                                    </div>
                                    <div class="modal-footer">

                                        <a href="${pageContext.request.contextPath}/">
                                            <button type="button" id="closeButton" class="btn btn-warning">Close
                                            </button>
                                        </a>

                                        <button type="submit" class="btn btn-primary">Save changes</button>
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
<script>
    let valid = new Map();
    document.getElementById("form").addEventListener("submit", function (e) {
        e.preventDefault();
        let formData = Object.fromEntries(new FormData(e.target));
        resetValid(valid);
        validForm(formData, valid);
        if (valid.size > 0) {
            renderMapError(valid);
            return;
        }
        document.getElementById("form").submit();
    })

    function renderMapError(valid) {
        for (const [key, value] of valid.entries()) {
            document.getElementById(key).innerText = value;
        }
    }

    function resetValid(valid) {
        for (const [key] of valid.entries()) {
            document.getElementById(key).innerText = "";
        }
        valid.clear();
    }

    function validForm(data, mapValid) {
        let currentValue = "";
        let idError = "";
        for (let i of Object.keys(data)) {
            currentValue = document.getElementById(i).value;
            idError = i + "Error";
            if (i === "id") continue;

            if (currentValue.trim() === "") {
                mapValid.set(idError, "Không được để trống");
                continue;
            }

            if (i === "phone") {
                if (!/^0[0-9]{9}$/.test(currentValue)) {
                    mapValid.set(idError, "Số điện thoại không phù hợp.");
                    continue;
                }
            }

            if (i === "numberMonth") {
                if (0 > +currentValue || 12 < +currentValue) {
                    mapValid.set(idError, "Số tháng không phù hợp");
                    continue;
                }
            }

            if (i === "area") {
                if (0 > +currentValue) {
                    mapValid.set(idError, "Số diện tích lớn hơn 0");
                    continue;
                }
            }

            if (document.getElementById("dayEnd").value < document.getElementById("monthJoin").value) {
                mapValid.set("dayEndError", "Ngày trả tiền sau ngày nhận phòng.");
            }
        }
    }
</script>
</body>
</html>
