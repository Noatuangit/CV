<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.extra.TypeCustomer" %>
<%@ page import="java.util.List" %>
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
                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="number" name="id" placeholder="id" min="1"
                                                           class="form-control form-control-lg" required/>
                                                    <label class="form-label">Id</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="name" placeholder="Name"
                                                           class="form-control form-control-lg" required pattern="^[a-zA-Z ,.'-]+$"/>
                                                    <label class="form-label">Name</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mb-4 pb-2">
                                            <p>Gender</p>
                                            <label>
                                                <select class="select" name="gender">
                                                    <option value="1">Male</option>
                                                    <option value="0">Female</option>
                                                </select>
                                            </label>
                                        </div>

                                        <div class="mb-4 pb-2">
                                            <div class="form-outline">
                                                <input type="text" id="form3Examplev4" name="id_card"
                                                       placeholder="Id Card CT-xxxx number"
                                                       class="form-control form-control-lg" required pattern="^CT-\d{4}$"/>
                                                <label class="form-label" for="form3Examplev4">Id Card</label>
                                            </div>
                                        </div>

                                        <div class="row">
                                            <div class="col-md-6 mb-4 pb-2 mb-md-0 pb-md-0">

                                                <div class="form-outline">
                                                    <input type="date" name="birthday"
                                                           value="dd/MM/yyyy"
                                                            min="1900-01-01"
                                                           max="2022-09-01"
                                                           class="form-control form-control-lg" required/>
                                                    <label class="form-label" >Birth Day</label>
                                                </div>
                                            </div>
                                            <div class="mb-4 pb-2">
                                                <label>
                                                    <label class="form-label" >Type Customer</label>
                                                    <select class="select" name="customer_type" required>
                                                        <% List<TypeCustomer> list = (List<TypeCustomer>) request.getAttribute("listType");%>
                                                        <c:forEach items="${requestScope.listType}" var="item">
                                                            <option value="<c:out value="${item.id}"></c:out>">
                                                                <c:out value="${item.name}"></c:out>
                                                            </option>
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
                                                           class="form-control form-control-lg"/>
                                                    <label style="color: black">Address</label>
                                                </div>
                                            </div>
                                            <div class="col-md-7 mb-4 pb-2">
                                                <div class="form-outline">
                                                    <input type="text" name="phone" placeholder="Phone Number"
                                                           class="form-control form-control-lg" required pattern="^0\d{9}$"/>
                                                    <label style="color: black">Phone Number</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="mb-4">
                                            <div class="form-outline">
                                                <input type="email" name="email" placeholder="Your Email"
                                                       class="form-control form-control-lg" required/>
                                                <label style="color: black">Your Email</label>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-success"
                                                data-mdb-ripple-color="dark"> Register
                                        </button>
                                        <button type="reset" class="btn btn-warning"> Reset
                                        </button>
                                        <a href="/list?action=displayCustomer">
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
