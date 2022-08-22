<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="models.extra.TypeCustomer" %>
<%@ page import="java.util.List" %>
<%@ page import="models.person.Customer" %>
<%@ page import="models.person.Employee" %>
<%@ page import="models.professional_furama.Service" %>
<%@ page import="models.professional_furama.Contract" %>
<%@ page import="models.professional_furama.AttachService" %>
<%@ page import="repository.DetailsService" %>
<%@ page import="models.professional_furama.ContractDetail" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
</head>
<body>

<nav class="nav nav-pills flex-column flex-sm-row">
    <jsp:include page="include/header.jsp"></jsp:include>
</nav>

<section class="h-100 h-custom gradient-custom-2">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12">
                <div class="card card-registration card-registration-2" style="border-radius: 15px;">
                    <div class="card-body p-0">
                        <div class="row g-0">
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <h3 class="fw-normal mb-5" style="color: #4835d4;">Contact Info</h3>
                                    <% Contract contract = (Contract) request.getAttribute("contract");%>
                                    <div class="mb-4 pb-2">
                                        <h3>Id = <%=contract.getId()%>
                                        </h3>
                                        <input type="hidden" name="id_contract" value="<%=contract.getId()%>">
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4 pb-2">
                                            <div class="form-outline">
                                                <input type="text" id="form3Examplev2"
                                                       value="<%=contract.getStart_day()%>"
                                                       class="form-control form-control-lg" readonly/>
                                                <label class="form-label" for="form3Examplev2">Start Date</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">
                                            <div class="form-outline">
                                                <input type="text" id="form3Examplev3"
                                                       value="<%=contract.getEnd_day()%>"
                                                       class="form-control form-control-lg" readonly/>
                                                <label class="form-label" for="form3Examplev3">End date</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4 pb-2">
                                            <div class="form-outline">
                                                <input type="text" id="form3Examplev1"
                                                       value="<%=contract.getDeposit()%>"
                                                       class="form-control form-control-lg" readonly/>
                                                <label class="form-label" for="form3Examplev1">Deposit</label>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <input type="text" id="form3Examplev0"
                                                       value="<%=contract.getTotal_money()%>"
                                                       class="form-control form-control-lg" readonly/>
                                                <label class="form-label" for="form3Examplev0">Total Money</label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 mb-4 pb-2">
                                            <div class="form-outline">
                                                <label class="form-label" for="form3Examplev5">Customer</label>
                                                <input type="text" id="form3Examplev5"
                                                       value="<%=contract.getCustomer_id()%>"
                                                       class="form-control form-control-lg" readonly/>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <label class="form-label" for="form3Examplev6">Service </label>
                                                <input type="text" id="form3Examplev6"
                                                       value="<%=contract.getService_id()%>"
                                                       class="form-control form-control-lg" readonly/>
                                            </div>
                                        </div>
                                        <div class="col-md-6 mb-4 pb-2">

                                            <div class="form-outline">
                                                <label class="form-label" for="form3Examplev7">Employee</label>
                                                <input type="text" id="form3Examplev7"
                                                       value="<%=contract.getEmployee_id()%>"
                                                       class="form-control form-control-lg" readonly/>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6 bg-indigo text-white">
                                <div class="p-5">
                                <%List<ContractDetail> details = (List<ContractDetail>) request.getAttribute("details");%>
                                <% for (ContractDetail detail : details) {%>

                                    <h3 class="fw-normal mb-5" style="color: black">Contact Details</h3>
                                    <div class="mb-2 pb-2">
                                        <div class="form-outline form-white">
                                            <input type="number" id="form3Examplea2" name="id_details"
                                                   value="<%=detail.getId_details()%>"
                                                   class="form-control form-control-lg" readonly required/>
                                            <label class="form-label" for="form3Examplea2" style="color: black">ID
                                                Contact Details </label>
                                        </div>
                                    </div>
                                    <div class="mb-2 pb-2">
                                        <%List<AttachService> list = (List<AttachService>) request.getAttribute("list");%>
                                        <label class="form-label" for="form3Examplev7" style="color: black">Attach
                                            Service</label>
                                        <% for (AttachService as : list) {
                                            if (as.getId() == detail.getId_attach_service())%>
                                        <input type="text" id="form3Examplea10" name="quantity"
                                               value="ID: <%=as.getId()%>, Name: <%=as.getName()%>,Cost: <%=as.getCost()%>"
                                               class="form-control form-control-lg" readonly required/>
                                        <%
                                                break;
                                            }%>
                                    </div>
                                    <div class="mb-2 pb-2">
                                        <div class="form-outline form-white">
                                            <label class="form-label" for="form3Examplea11" style="color: black">
                                                Quantity </label>
                                            <input type="number" id="form3Examplea11" name="quantity"
                                                   value="<%=detail.getQuantity()%>"
                                                   class="form-control form-control-lg" readonly required/>
                                        </div>
                                    </div>
                                    <% }%>
                                    <a href="/list?action=displayContract">
                                        <button type="button" class="btn btn-primary btn-lg ms-2">Back List</button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
