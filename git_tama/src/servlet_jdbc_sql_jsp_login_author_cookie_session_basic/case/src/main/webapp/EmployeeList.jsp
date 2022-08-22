<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.impl.EmployeeService" %>
<%@ page import="java.util.List" %>
<%@ page import="models.person.Employee" %>
<%@ page import="utils.Query" %>
<%@ page import="models.extra.Education" %>
<%@ page import="models.extra.Position" %>
<%@ page import="models.extra.Division" %><%--
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
    <form method="get" action="/list">
        <label>
            <input type="hidden" name="action" value="searchNameEmployee">
            <input type="text" placeholder="search by name" name="name_search" required>
            <button type="submit" class="btn btn-light">Search</button>
        </label>
    </form>
</nav>
<div class="insert">
    <a href="/list?action=insertEmployee" style="text-decoration: none">
        <button class="btn btn-secondary">Create new employee</button>
    </a>
    <a href="/list?action=displayEmployee" style="text-decoration: none">
        <button class="btn btn-success">Refresh</button>
    </a>
</div>
<table class="table table-striped table-hover">
    <tr>
        <td>Stt</td>
        <td>Name</td>
        <td>Birthday</td>
        <td>Id Card</td>
        <td>Salary</td>
        <td>Phone</td>
        <td>Email</td>
        <td>Address</td>
        <td>Position</td>
        <td>Education Degree</td>
        <td>Division</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${requestScope.list}" var="item">
        <tr>
            <td><c:out value="${item.id}"></c:out></td>
            <td><c:out value="${item.name}"></c:out></td>
                <%--            <td><c:out value="${item.birthday}"></c:out></td>--%>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${item.birthday}"/></td>
            <td><c:out value="${item.id_card}"></c:out></td>
            <td><c:out value="${item.salary}"></c:out></td>
            <td><c:out value="${item.phone}"></c:out></td>
            <td><c:out value="${item.email}"></c:out></td>
            <td><c:out value="${item.address}"></c:out></td>
            <td><c:out value="${item.positions}"></c:out></td>
            <td><c:out value="${item.education_degree}"></c:out></td>
            <td><c:out value="${item.division}"></c:out></td>
            <td>
                <a onclick="showInfoDelete('${item.id}','${item.name}')"
                   data-bs-toggle="modal" data-bs-target="#delete">
                    <i class="fa-solid fa-eraser"></i>
                </a>
                <a onclick="showInfoEdit('${item.id}','${item.name}','${item.id_card}','${item.birthday}','${item.salary}',
                    '${item.phone}','${item.email}','${item.address}','${item.positions}','${item.education_degree}','${item.division}')"
                   data-bs-toggle="modal" data-bs-target="#editEmployee">
                    <i class="fa-solid fa-wrench"></i></a>
            </td>
        </tr>
    </c:forEach>
</table>

<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/list?action=deleteEmployee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete Employee</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="deleteId" name="id">
                    <span>Are you delete employee </span><span id="deleteName"></span>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </div>
            </div>
        </form>
    </div>
</div>

<%-- edit --%>
<div class="modal fade" id="editEmployee" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/list?action=updateEmployee" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel4">Edit title</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <div class="col-md-12">
                        <label for="nameEdit" class="form-label">Id Employee</label>
                        <input type="text" class="form-control" id="id" name="id" readonly required>
                    </div>
                    <div class="col-md-12">
                        <label for="nameEdit" class="form-label">Name Employee</label>
                        <input type="text" class="form-control" id="nameEdit" name="name" required pattern="^[a-zA-Z ,.'-]+$">
                    </div>
                    <div class="col-md-12">
                        <label for="birthdayEdit" class="form-label">Birthday</label>
                        <input type="date" class="form-control" id="birthdayEdit" name="birthday" required>
                    </div>

                    <div class="col-md-12">
                        <label for="idCardEdit" class="form-label">Id Card </label>
                        <input type="text" class="form-control" id="idCardEdit" name="id_card" required pattern="^CT-\d{4}$">
                    </div>
                    <div class="col-md-12">
                        <label for="phoneEdit" class="form-label">Phone</label>
                        <input type="number" class="form-control" id="phoneEdit" name="phone" required pattern="^0\d{9}$">
                    </div>
                    <div class="col-md-12">
                        <label for="emailEdit" class="form-label">Email</label>
                        <input type="email" class="form-control" id="emailEdit" name="email" required>
                    </div>
                    <div class="col-md-12">
                        <label for="salaryEdit" class="form-label">Salary</label>
                        <input type="number" class="form-control" id="salaryEdit" name="salary" min="0" required>
                    </div>
                    <div class="col-md-12">
                        <label for="addressEdit" class="form-label">Address</label>
                        <input type="text" class="form-control" id="addressEdit" name="address" required>
                    </div>
                    <div class="col-md-12 ">
                        <label class="form-label">Education Degree Id</label>
                        <select class="form-control" name="educations" id="educationEdit" required>
                            <c:forEach items="${requestScope.educations}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-12 ">
                        <label class="form-label">Position</label>
                        <select class="form-control" name="positions" id="positionEdit" required>
                            <c:forEach items="${requestScope.positions}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-12 ">
                        <label class="form-label">Division</label>
                        <select class="form-control" name="divisions" id="divisionEdit" required>
                            <c:forEach items="${requestScope.divisions}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save changes</button>
                </div>

            </div>
        </form>
    </div>
</div>
<script>
    // function checkDelete(id){
    //     let choice = confirm("Are You delete?");
    //     if(choice === true){
    //         window.location.href = "/list?action=deleteEmployee&&id=" + id;
    //     }
    // }
    function showInfoDelete(id, name) {
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }

    function showInfoEdit(id, name, id_card, birth, salary, phone, email, address, position, education, division) {
        document.getElementById("id").value = id;
        document.getElementById("nameEdit").value = name;
        document.getElementById("birthdayEdit").value = birth;
        document.getElementById("idCardEdit").value = id_card;
        document.getElementById("phoneEdit").value = phone;
        document.getElementById("addressEdit").value = address;
        document.getElementById("emailEdit").value = email;
        document.getElementById("salaryEdit").value = salary;
        document.getElementById("educationEdit").value = education;
        document.getElementById("positionEdit").value = position;
        document.getElementById("divisionEdit").value = division;
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