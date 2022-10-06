<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="index.jsp">Home</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/customer?action=displayCustomer">Customer</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/employee?action=displayEmployee">Employee</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/service?action=displayService">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/contract?action=displayContract">Contract</a>
</nav>
<div class="insert">
    <a href="/contract?action=displayContract" style="text-decoration: none">
        <button class="btn btn-outline-primary" data-mdb-ripple-color="dark">Back Contract</button>
    </a>
</div>
<div  style="padding-top: 5px">
    <table class="table table-bordered">
        <tr>
            <td>ID</td>
            <td>Contract Id</td>
            <td>Name Add On</td>
            <td>Add On Cost</td>
            <td>Unit Add On</td>
            <td>Quantity</td>
        </tr>
        <c:forEach items="${listDetail}" var="item">
            <tr>
                <td>${item.id_details}</td>
                <td>${item.id_contract}</td>
                <c:forEach items="${addOnList}" var="check">
                    <c:if test="${item.id_attach_service == check.id}">
                        <td>${check.name}</td>
                        <td>${check.cost}</td>
                        <td>${check.unit}</td>
                    </c:if>
                </c:forEach>
                <td>${item.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
