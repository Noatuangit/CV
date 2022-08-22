<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="models.person.Employee" %>
<%@ page import="models.extra.Division" %>
<%@ page import="models.extra.Education" %>
<%@ page import="models.extra.Position" %><%--
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
<%--    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="../index.jsp">Home</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayCustomer">Customer</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayEmployee">Employee</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayService">Service</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayContract">Contract</a>--%>
    <jsp:include page="?/header.jsp"></jsp:include>
</nav>
<form method="post">
    <% Employee employee = (Employee) request.getAttribute("employee");%>
    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label>ID</label>
            <input type="number" class="form-control is-valid" name="id"
                   value="<%=employee.getId()%>" readonly>
        </div>

        <div class="col-md-4 mb-3">
            <label for="validationServer02">Name</label>
            <input type="text" class="form-control is-valid" id="validationServer02" name="name"
                   value="<%=employee.getName()%>" required pattern="^[a-zA-Z ,.'-]+$">
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationServer02">Id Card</label>
            <input type="text" class="form-control is-valid" name="id_card"
                   value="<%=employee.getId_card()%>" required pattern="^NV-\d{3}$">
        </div>

    </div>
    <div class="form-group col-md-4">
        <label>Division</label>
        <% List<Division> divisionList = (List<Division>) request.getAttribute("divisions");%>
        <select class="form-control" name="divisions" required>
            <c:forEach items="<%=divisionList%>" var="item">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group col-md-4">
        <label>Education</label>
        <% List<Education> educations = (List<Education>) request.getAttribute("educations");%>
        <select class="form-control" name="educations">
            <c:forEach items="<%=educations%>" var="item">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group col-md-4">
        <label>Position</label>
        <% List<Position> positions = (List<Position>) request.getAttribute("positions");%>
        <select class="form-control" name="positions">
            <c:forEach items="<%=positions%>" var="item">
                <option value="${item.id}">${item.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-row">
        <div class="col-md-4 mb-3">
            <label for="validationServer02">Birthday</label>
            <input type="date" class="form-control is-valid" name="birthday"
                   value="<%=employee.getBirthday()%>" required>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationServer02">Salary</label>
            <input type="text" class="form-control is-valid" name="salary" min="0"
                   value="<%=employee.getSalary()%>" required>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationServer02">Phone</label>
            <input type="text" class="form-control is-valid" name="phone"
                   value="<%=employee.getPhone()%>" required>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationServer02">Email</label>
            <input type="text" class="form-control is-valid" name="email"
                   value="<%=employee.getEmail()%>" required>
        </div>
        <div class="col-md-4 mb-3">
            <label for="validationServer02">Address</label>
            <input type="text" class="form-control is-valid" name="address"
                   value="<%=employee.getAddress()%>" required>
        </div>
    </div>
    <button class="btn btn-success" type="submit">Submit form</button>
    <button class="btn btn-warning" type="reset">Reset</button>
    <a href="/list?action=displayEmployee">
        <button class="btn btn-primary" type="button">Back List</button>
    </a>
</form>
</body>
</html>
