<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer</title>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
    <link rel="stylesheet" type="text/css" href="resources/style.css" />
    <style>
        .errorPage{
            display: flex;
            justify-content: center;
            text-align: center;
        }
    </style>
</head>
<body>
<%@include file="../header.jsp" %>
<div class="errorPage">
    <h1>Server in maintenance by error ${error}. Comeback soon please!!!</h1>
</div>
<div class="errorPage">
    <a href="${pageContext.request.contextPath}/">
        <img style="height: 500px" alt=""
             src="${image}">
    </a>
</div>
<div class="errorPage" style="width: 100%">
    <a href="${pageContext.request.contextPath}/">
        <button class="btn btn-info">goHome</button>
    </a>
</div>
<%@include file="../footer.jsp" %>

</body>
</html>