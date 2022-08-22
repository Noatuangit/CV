<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.impl.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="models.person.Employee" %>
<%@ page import="utils.Query" %>
<%@ page import="models.professional_furama.Contract" %>
<%@ page import="models.professional_furama.ContractDetail" %><%--
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
    <jsp:include page="include/header.jsp"></jsp:include>
</nav>
<div class="insert">
    <a href="/list?action=displayContract" style="text-decoration: none">
        <button class="btn btn-outline-primary" data-mdb-ripple-color="dark">Back Contract</button>
    </a>
</div>
<div  style="padding-top: 5px">
    <table class="table table-bordered">
        <tr>
            <td>ID</td>
            <td>Contract Id</td>
            <td>Attach Service</td>
            <td>Quantity</td>
        </tr>
        <% List<ContractDetail> list = (List<ContractDetail>) request.getAttribute("list");%>
        <c:forEach items="<%=list%>" var="item">
            <tr>
                <td><c:out value="${item.id_details}"></c:out></td>
                <td><c:out value="${item.id_contract}"></c:out></td>
                <td><c:out value="${item.id_attach_service}"></c:out></td>
                <td><c:out value="${item.quantity}"></c:out></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
