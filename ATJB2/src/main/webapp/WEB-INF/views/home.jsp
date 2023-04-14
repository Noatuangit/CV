<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
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
    <link rel="stylesheet" type="text/css" href="resources/style.css"/>
</head>
<body>
<%@include file="header.jsp" %>
<div style="display: flex; justify-content: center">
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="https://5.imimg.com/data5/FX/LN/FF/SELLER-82436190/all-in-one-computer-500x500.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Book computer</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="${pageContext.request.contextPath }/managerComputer" class="btn btn-primary">Book computer</a>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="https://5.imimg.com/data5/XK/WG/MY-249789/desktop-computer-500x500.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Book Service</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="${pageContext.request.contextPath }/managerService" class="btn btn-primary">Book Service</a>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="https://cdn-amz.woka.io/images/I/81AoV5-pZLL.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">Total Service</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="${pageContext.request.contextPath }/managerTotal" class="btn btn-primary">Total service</a>
        </div>
    </div>
    <div class="card" style="width: 18rem;">
        <img class="card-img-top" src="https://5.imimg.com/data5/LP/FA/MY-50363679/computer-world-1000x1000.jpg" alt="Card image cap">
        <div class="card-body">
            <h5 class="card-title">CuMeo Info</h5>
            <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
            <a href="https://github.com/Noatuangit/CV" class="btn btn-primary">Go Info</a>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>

</body>
</html>
