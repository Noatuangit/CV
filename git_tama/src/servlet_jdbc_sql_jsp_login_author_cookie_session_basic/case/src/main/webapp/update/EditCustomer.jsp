<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.person.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="service.impl.CustomerService" %>
<%@ page import="utils.Query" %>
<%@ page import="models.extra.TypeCustomer" %><%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 7/23/2022
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Customer</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="../index.jsp">Home</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayCustomer">Customer</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayEmployee">Employee</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayService">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayContract">Contract</a>
</nav>
<div style="position: relative; left: 30%">
<section class="h-100 h-custom gradient-custom-2">
    <form method="post">
        <%Customer customer = (Customer) request.getAttribute("customer");%>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>ID</label>
                <input type="email" class="form-control" name="id" value="<%=customer.getId()%>" readonly>
            </div>
            <div class="form-group col-md-6">
                <label>Name</label>
                <input type="text" class="form-control" name="name" value="<%=customer.getName()%>" required
                       pattern="^[a-zA-Z ,.'-]+$">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label>Id Card</label>
            <input type="text" class="form-control" name="id_card" value="<%=customer.getId_card()%>" required
                   pattern="^CT-\d{4}$">
        </div>
        <div class="form-group col-md-6">
            <label>Phone</label>
            <input type="text" class="form-control" name="phone" value="<%=customer.getPhone()%>" required
                   pattern="^0\d{9}$">
        </div>
        <div class="mb-4 pb-2">
            <p>Gender</p>
            <label>
                <input type="radio" name="gender" value="1"
                       <%if(customer.getGender().equalsIgnoreCase("1")){%>checked<%}%>>Male
                <input type="radio" name="gender" value="0"
                       <%if(customer.getGender().equalsIgnoreCase("0")){%>checked<%}%>>Female
            </label>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label>Address</label>
                <input type="text" class="form-control" name="address" value="<%=customer.getAddress()%>"
                       required>
            </div>
            <div class="form-group col-md-6">
                <label>Email</label>
                <input type="email" class="form-control" name="email" value="<%=customer.getEmail()%>" required>
            </div>
            <div class="form-group col-md-4">
                <label for="inputState">Type Customer</label>
                <% List<TypeCustomer> list = (List<TypeCustomer>) request.getAttribute("listType");%>
                <select id="inputState" class="form-control" name="customer_type" required>
                    <c:forEach items="<%=list%>" var="item">
                        <option value="<c:out value="${item.id}"></c:out>">
                            Id: <c:out value="${item.id}"></c:out>
                            . Name: <c:out value="${item.name}"></c:out>
                        </option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label>Birthday</label>
                <input type="date" class="form-control" name="birthday" value="<%=customer.getBirthday()%>">
            </div>
        </div>
        <div class="form-group col-md-4">
            <button type="submit" class="btn btn-success">Update</button>
            <button type="reset" class="btn btn-warning">Reset</button>
            <a href="/list?action=displayCustomer">
                <button type="button" class="btn btn-primary">Back List</button>
            </a>
        </div>
    </form>
</section>
</div>
</body>
</html>