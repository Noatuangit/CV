<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.person.Customer" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="utils.Query" %><%--
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
    <link rel="stylesheet" href="FormList.css">


</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
    <jsp:include page="include/header.jsp"></jsp:include>
    <form method="get" action="/list">
        <label>
            <input type="hidden" name="action" value="searchNameCustomer">
            <input type="text" placeholder="search by name" name="name_search" required>
            <button type="submit" class="btn btn-dark">Search</button>
        </label>
    </form>
</nav>
<div class="insert">
    <a href="/list?action=insertCustomer" style="text-decoration: none">
        <button class="btn btn-secondary">Create new customer</button>
    </a>
    <a href="/list?action=displayCustomer" style="text-decoration: none">
        <button class="btn btn-success">Refresh</button>
    </a>
</div>
<table class="table table-striped-columns">
    <tr>
        <td>Stt</td>
        <td>Name</td>
        <td>Birthday</td>
        <td>Gender</td>
        <td>Id Card</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Address</td>
        <td>Type Customer</td>
        <td>Action</td>
    </tr>

    <%
        List<Customer> list = (List<Customer>) request.getAttribute("list");
    %>
    <c:forEach items="<%=list%>" var="item">
        <tr>
            <td><c:out value="${item.id}"></c:out></td>
            <td><c:out value="${item.name}"></c:out></td>
                <%--            <td><c:out value="${item.birthday}"></c:out></td>       --%>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.birthday}"/></td>
            <td><c:out value="${item.gender}"></c:out></td>
            <td><c:out value="${item.id_card}"></c:out></td>
            <td><c:out value="${item.phone}"></c:out></td>
            <td><c:out value="${item.email}"></c:out></td>
            <td><c:out value="${item.address}"></c:out></td>
            <td><c:out value="${item.customer_type}"></c:out></td>
            <td>
                <a href="#" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-customer-id=${item.id}>
                    <i class="fa-solid fa-eraser"></i></a>
                <a href="/list?action=updateCustomer&&id=${item.id}"><i class="fa-solid fa-wrench"></i></a>
            </td>
        </tr>
    </c:forEach>

    <%-- page jump --%>
    <div>
        <% int max_page = (int) request.getAttribute("max_page");%>
        <% String link_action = (String) request.getAttribute("link"); %>
        <ul class="pagination justify-content-center">
            <c:forEach begin="1" end="<%=max_page%>" var="item">
                <li class="page-item"><a class="page-link"
                                         href="/list?action=<%=link_action%>&&offset=${item-1}">${item}</a></li>
            </c:forEach>
        </ul>
    </div>
</table>


<%-- delete modal --%>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Do you want to delete this customer?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <button id="button-confirm-delete" type="button" class="btn btn-danger" data-customer-id=""
                        onclick="handleClickToDeleteCustomer(event)">Delete
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    const handleClickToDeleteCustomer = (event) => {
        const id = event.target.getAttribute("data-customer-id");
        window.location.href = "/list?action=deleteCustomer&&id=" + id;
    }

    const exampleModal = document.getElementById('exampleModal');
    exampleModal.addEventListener('show.bs.modal', event => {
        const id = event.relatedTarget.getAttribute('data-bs-customer-id');
        const modalTitle = document.querySelector('#exampleModalLabel');
        modalTitle.textContent = "Delete the customer with id: " + id;
        const btnConfirmDelete = document.getElementById('button-confirm-delete');
        btnConfirmDelete.setAttribute("data-customer-id", id);
    })

</script>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
        integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js"
        integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK"
        crossorigin="anonymous"></script>
</body>
</html>