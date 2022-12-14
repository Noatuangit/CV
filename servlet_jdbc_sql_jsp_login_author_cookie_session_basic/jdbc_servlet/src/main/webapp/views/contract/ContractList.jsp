<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
</head>
<body>
<nav class="nav nav-pills flex-column flex-sm-row">
    <a class="flex-sm-fill text-sm-center nav-link active" aria-current="page" href="../index.jsp">Home</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/customer?action=displayCustomer">Customer</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/employee?action=displayEmployee">Employee</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/service?action=displayService">Service</a>
    <a class="flex-sm-fill text-sm-center nav-link" href="/contract?action=displayContract">Contract</a>
</nav>
<div class="insert">
    <a href="/contract?action=insertContract" style="text-decoration: none" class="me-3">
        <button class="btn btn-secondary">Create new contract</button>
    </a>
    <a href="/customer?action=listCustomerHaveContract" style="text-decoration: none" class="me-3">
        <button class="btn btn-info">List Customer Have Contract</button>
    </a>
    <a href="/contract?action=listContractDetails" style="text-decoration: none" class="me-3">
        <button class="btn btn-dark">List Contract Details</button>
    </a>
</div>
<table class="table table-striped">
    <tr>
        <td>Stt</td>
        <td>Start Day</td>
        <td>End Day</td>
        <td>Deposit</td>
        <td>Employee service</td>
        <td>Customer rent</td>
        <td>Service bonus</td>
        <td>Total</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${contracts}" var="item" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${item.start_day}"/></td>
            <td><fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${item.end_day}"/></td>
            <td>${item.deposit}</td>
            <c:forEach items="${employees}" var="check">
                <c:if test="${item.employee_id == check.id}">
                    <td>${check.name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${customers}" var="check">
                <c:if test="${item.customer_id == check.id}">
                    <td>${check.name}</td>
                </c:if>
            </c:forEach>
            <c:forEach items="${services}" var="check">
                <c:if test="${item.service_id == check.id}">
                    <td>${check.name}</td>
                </c:if>
            </c:forEach>
            <td>${item.total_money}</td>
            <td>
                <a href="/contract?action=infoContractAllService&&id=${item.id}" style="text-decoration: none">
                    <i class="fa-solid fa-info"></i>
                </a>
                <a href="/contract?action=createContractDetails&&id=${item.id}" style="text-decoration: none">
                    <i class="fa-solid fa-circle-plus"></i>
                </a>
                <a href="#" style="text-decoration: none" data-bs-toggle="modal" data-bs-target="#exampleModal"
                   data-bs-contract-id=${item.id}>
                    <i class="fa-solid fa-trash-can"></i>
                </a>
                <a href="/contract?action=updateContract&&id=${item.id}" style="text-decoration: none"><i
                        class="fa-solid fa-wrench"></i></a>
            </td>
        </tr>
    </c:forEach>
</table>
<%-- page jump not change --%>
<c:if test="${max_page != null}">
    <div>
        <ul class="pagination justify-content-center">
            <c:choose>
                <c:when test="${offset == 0}">
                    <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Previous</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="/contract?action=${link}&&offset=${offset - 1}">Previous</a></li>
                </c:otherwise>
            </c:choose>
            <c:forEach begin="1" end="${max_page}" var="item">
                <li class="page-item"><a class="page-link"
                                         href="/contract?action=${link}&&offset=${item-1}">${item}</a></li>
            </c:forEach>
            <c:choose>
                <c:when test="${offset == max_page - 1}">
                    <li class="page-item"><a class="page-link" href="#" style="color: darkgray">Next</a></li>
                </c:when>
                <c:otherwise>
                    <li class="page-item"><a class="page-link"
                                             href="/contract?action=${link}&&offset=${offset  + 1}">Next</a></li>
                </c:otherwise>
            </c:choose>
        </ul>
    </div>
</c:if>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Delete Contract</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Do you want to delete this Contract?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <button id="button-confirm-delete" type="button" class="btn btn-danger" data-contract-id=""
                        onclick="handleClickToDeleteContract(event)">Delete
                </button>
            </div>
        </div>
    </div>
</div>

<script>
    const handleClickToDeleteContract = (event) => {
        const id = event.target.getAttribute("data-contract-id")
        console.log(id);
        window.location.href = "/contract?action=deleteContract&&id=" + id;
    }

    const exampleModal = document.getElementById('exampleModal')
    exampleModal.addEventListener('show.bs.modal', event => {
        const button = event.relatedTarget
        const id = button.getAttribute('data-bs-contract-id')
        const modalTitle = document.querySelector('#exampleModalLabel')
        modalTitle.textContent = "Delete the contract with id: " + id
        const btnConfirmDelete = document.getElementById('button-confirm-delete');
        btnConfirmDelete.setAttribute("data-contract-id", id);
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