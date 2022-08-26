<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Service List</title>
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
    <form>
        <label>
            <input type="hidden" name="action" value="searchNameService">
            <input type="text" placeholder="search by name" name="name_search" required>
            <button type="submit" class="btn btn-light">Search</button>
        </label>
    </form>
</nav>
<div class="insert">
    <a href="/service?action=insertService" style="text-decoration: none">
        <button class="btn btn-secondary">Create new service</button>
    </a>
    <a href="/service?action=displayService" style="text-decoration: none">
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
    <c:forEach items="${services}" var="item" varStatus="status">
        <tr>
            <td><c:out value="${status.count}"></c:out></td>
            <td><c:out value="${item.name}"></c:out></td>
            <td><c:out value="${item.area}"></c:out></td>
            <td><c:out value="${item.cost}"></c:out></td>
            <td><c:out value="${item.max_people}"></c:out></td>
            <td><c:out value="${item.standard_room}"></c:out></td>
            <td><c:out value="${item.description_other_convenience}"></c:out></td>
            <td><c:out value="${item.pool_area}"></c:out></td>
            <td><c:out value="${item.number_of_floors}"></c:out></td>
            <td><c:out value="${item.facility_text}"></c:out></td>
            <c:forEach items="${listRent}" var="check">
                <c:if test="${item.rent_type == check.id}">
                    <td>${check.name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${listService}" var="check">
                <c:if test="${item.service_type == check.id}">
                    <td>${check.name}</td>
                </c:if>
            </c:forEach>
            <td>
                <a onclick="showInfoDelete('${item.id}','${item.name}')"
                   data-bs-toggle="modal" data-bs-target="#delete">
                    <i class="fa-solid fa-eraser"></i>
                </a>
                <a href="/service?action=updateService&&id=${item.id}"><i class="fa-solid fa-wrench"></i></a>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${max_page != null}">
    <div>
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="${max_page}" var="item">
                <li class="page-item"><a class="page-link"
                                         href="/service?action=${link}&&offset=${item-1}">${item}</a></li>
            </c:forEach>
        </ul>
    </div>
</c:if>

<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/service?action=deleteService" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Service</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="id">
                    <span>Are you delete service </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>


<script>
    function showInfoDelete(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>