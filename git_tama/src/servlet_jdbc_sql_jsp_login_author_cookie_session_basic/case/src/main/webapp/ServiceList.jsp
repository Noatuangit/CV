<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="models.professional_furama.Service" %>
<%@ page import="java.util.List" %><%--
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
    <title>JSP - Hello World</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" href="FormList.css">
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
<%--    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="index.jsp">Home</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayCustomer">Customer</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayEmployee">Employee</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayService">Service</a>--%>
<%--    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayContract">Contract</a>--%>
    <jsp:include page="include/header.jsp"></jsp:include>
    <form>
        <label>
            <input type="hidden" name="action" value="searchNameService">
            <input type="text" placeholder="search by name" name="name_search" required>
            <button type="submit" class="btn btn-light">Search</button>
        </label>
    </form>
</nav>
<div class="insert">
    <a href="/list?action=insertService" style="text-decoration: none">
        <button class="btn btn-secondary">Create new service</button>
    </a>
    <a href="/list?action=displayService" style="text-decoration: none">
        <button class="btn btn-success">Refresh</button>
    </a>
</div>
<table class="table table-bordered border-primary">
    <tr>
        <td>Stt</td>
        <td>Name</td>
        <td>Area</td>
        <td>Cost</td>
        <td>Max People</td>
        <td>Standard Room</td>
        <td>Description Other Convenience</td>
        <td>Pool Area</td>
        <td>Number of Floors</td>
        <td>Text</td>
        <td>Rent Type</td>
        <td>Service Type</td>
        <td>Action</td>
    </tr>
    <%
        List<Service> list = (List<Service>) request.getAttribute("list");
    %>
    <c:forEach items="<%=list%>" var="item">
        <tr>
            <td><c:out value="${item.id}"></c:out></td>
            <td><c:out value="${item.name}"></c:out></td>
            <td><c:out value="${item.area}"></c:out></td>
            <td><c:out value="${item.cost}"></c:out></td>
            <td><c:out value="${item.max_people}"></c:out></td>
            <td><c:out value="${item.standard_room}"></c:out></td>
            <td><c:out value="${item.description_other_convenience}"></c:out></td>
            <td><c:out value="${item.pool_area}"></c:out></td>
            <td><c:out value="${item.number_of_floors}"></c:out></td>
            <td><c:out value="${item.facility_text}"></c:out></td>
            <td><c:out value="${item.rent_type}"></c:out></td>
            <td><c:out value="${item.service_type}"></c:out></td>
            <td>
                <a href="#" onclick="checkDelete(${item.id})"><i class="fa-solid fa-eraser"></i></a>
                <a href="/list?action=updateService&&id=${item.id}"><i class="fa-solid fa-wrench"></i></a>
            </td>
        </tr>
    </c:forEach>
</table>
<script>
    function checkDelete(id) {
        let choice = confirm("Are You delete?");
        if (choice === true) {
            window.location.href = "/list?action=deleteService&&id=" + id;
        }
    }
</script>
</body>
</html>