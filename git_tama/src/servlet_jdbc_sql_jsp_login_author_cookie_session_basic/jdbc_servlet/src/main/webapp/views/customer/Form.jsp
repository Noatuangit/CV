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

<section class="h-100 h-custom gradient-custom-2">
    <form method="post">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12">
                    <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                        <div class="card-body p-0">
                            <div class="row g-0">
                                <div class="col-lg-6">
                                    <div class="p-5">
                                        <h3 class="fw-normal mb-5" style="color: #4835d4;">Customer Information</h3>
                                        <c:if test="${message != null}">
                                            <h3 style="color:red;">${message}</h3>
                                        </c:if>
                                        <div class="row">
                                            <input type="hidden" name="id" placeholder="id"
                                                   value="${customer.id}"
                                                   class="form-control form-control-lg"/>
                                            <div class="col-md-12 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="name" placeholder="Name"
                                                           value="${customer.name}"
                                                           class="form-control form-control-lg" required/>
                                                    <label class="form-label">Name</label>
                                                    <c:if test="${error != null}">
                                                        <h3 style="color:red;">${error.get('name')}</h3>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mb-4 pb-2">
                                            <p>Gender</p>
                                            <label>
                                                <select class="select" name="gender">
                                                    <c:choose>
                                                        <c:when test="${customer.gender == 1}">
                                                            <option value="1" selected>Male</option>
                                                            <option value="0">Female</option>
                                                        </c:when>
                                                        <c:when test="${customer.gender == 0}">
                                                            <option value="1">Male</option>
                                                            <option value="0" selected>Female</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="1">Male</option>
                                                            <option value="0">Female</option>
                                                        </c:otherwise>
                                                    </c:choose>

                                                </select>
                                            </label>
                                        </div>

                                        <div class="mb-4 pb-2">
                                            <div class="form-outline">
                                                <input type="text" id="form3Examplev4" name="id_card"
                                                       placeholder="Id Card CT-xxxx number" value="${customer.id_card}"
                                                       class="form-control form-control-lg" required />
                                                <label class="form-label" for="form3Examplev4">Id Card</label>
                                            </div>
                                            <c:if test="${error != null}">
                                                <h3 style="color:red;">${error.get("id_card")}</h3>
                                            </c:if>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2 mb-md-0 pb-md-0">

                                                <div class="form-outline">
                                                    <input type="date" name="birthday"
                                                           value="${customer.birthday}"
                                                           class="form-control form-control-lg" required/>
                                                    <label class="form-label">Birth Day</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <label>
                                                    <label class="form-label">Type Customer</label>
                                                    <select class="select" name="customer_type" required>
                                                        <c:forEach items="${listType}" var="item">
                                                            <c:choose>
                                                                <c:when test="${service.re == item.id}">
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
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 bg-indigo text-white">
                                    <div class="p-5">
                                        <div class="row">
                                            <div class="col-md-5 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="address" placeholder="Address" required
                                                         value="${customer.address}"  class="form-control form-control-lg"/>
                                                    <label style="color: black">Address</label>
                                                </div>
                                            </div>
                                            <div class="col-md-7 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="phone" placeholder="Phone Number"
                                                           value="${customer.phone}"
                                                           class="form-control form-control-lg" required />
                                                    <label style="color: black">Phone Number</label>
                                                    <c:if test="${error != null}">
                                                        <h3 style="color:red;">${error.get("phone")}</h3>
                                                    </c:if>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mb-4">
                                            <div class="form-outline">
                                                <input type="text" name="email" placeholder="Your Email"
                                                       value="${customer.email}"
                                                       class="form-control form-control-lg" required/>
                                                <label style="color: black">Your Email</label>
                                                <c:if test="${error != null}">
                                                    <h3 style="color:red;">${error.get("email")}</h3>
                                                </c:if>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-success"
                                                data-mdb-ripple-color="dark"> Submit
                                        </button>
                                        <button type="reset" class="btn btn-warning"> Reset
                                        </button>
                                        <a href="/customer?action=displayCustomer">
                                            <button type="button" class="btn btn-info">Back List</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</section>
</body>
</html>
