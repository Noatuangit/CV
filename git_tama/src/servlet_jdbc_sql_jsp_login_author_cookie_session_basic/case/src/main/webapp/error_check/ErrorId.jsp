<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.person.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="service.impl.CustomerService" %>
<%@ page import="utils.Query" %>
<%@ page import="java.sql.SQLException" %><%--
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
    <link rel="stylesheet" href="../FormList.css">
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="../index.jsp">Home</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayCustomer">Customer</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayEmployee">Employee</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayService">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/list?action=displayContract">Contract</a>
</nav>
<div class="container py-5 h-100">
    <%--    <%SQLException e = (SQLException) request.getAttribute("error");%>--%>
    <%--    <h1> <span class="badge badge-secondary"><%=e.getMessage()%></span></h1>--%>

    <% String str = request.getParameter("code"); %>
    <% String link = request.getParameter("link");%>
    <%--    <div class="row align-items-center py-3">--%>
    <%--        <div class="col-md-3 ps-5">--%>
    <%--            <h6 class="mb-0"><%=str%>--%>
    <%--            </h6>--%>
    <%--        </div>--%>
    <%--        <a href="<%=link%>">--%>
    <%--            <button type="button" class="btn btn-lg btn-danger"--%>
    <%--                    data-toggle="popover" title="Popover title"--%>
    <%--                    data-content="And here's some amazing content. It's very engaging. Right?">Back List--%>
    <%--            </button>--%>
    <%--        </a>--%>
    <%--    </div>--%>
    <div style="text-align: center">
        <div class="card">
            <div>
                <img src="../error.png" style=" width: 512px;height: 512px;" alt="noImg">
            </div>
            <%--            <div class="card-body"--%>
            <%--                 style="background-image:url('../error.png'); background-repeat: repeat; width: 512px;height: 512px;">--%>
            <%--            </div>--%>
            <h1 class="card-text" style="text-align: center"><%=str%>
            </h1>
            <a href="<%=link%>" class="btn btn-warning">Back Form</a>
        </div>
    </div>

</div>
</body>
</html>
