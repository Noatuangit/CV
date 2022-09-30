package controller;

import lombok.SneakyThrows;
import models.person.Customer;
import models.person.Employee;
import models.professional.AttachServiceAddOn;
import models.professional.Contract;
import models.professional.ContractDetail;
import models.professional.MainService;
import service.IBaseService;
import service.IContractDetailService;
import service.ITypeService;
import service.impl.Contract.AttachServiceService;
import service.impl.Contract.ContractDetailService;
import service.impl.Contract.ContractService;
import service.impl.customer.CustomerService;
import service.impl.employee.EmployeeService;
import service.impl.service.MainServiceService;
import utils.CreateContract;
import utils.DataAddOnContract;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    IBaseService<Contract> contractIBaseService = new ContractService();
    IBaseService<Customer> customerIBaseService = new CustomerService();
    IBaseService<MainService> serviceIBaseService = new MainServiceService();
    IBaseService<Employee> employeeIBaseService = new EmployeeService();
    IContractDetailService<ContractDetail> contractDetailIBaseService = new ContractDetailService();
    ITypeService<AttachServiceAddOn> serviceAddOnITypeService = new AttachServiceService();

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "insertContract": {
                insertContract(request, response);
                break;
            }

            case "updateContract": {
                updateContract(request, response);
                break;
            }
            case "createContractDetails": {
                createDetails(request, response);
                break;
            }
        }
    }

    private void createDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id_contract = Integer.parseInt(request.getParameter("id"));
        int id_attach_service = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        contractDetailIBaseService.insertDetail(new ContractDetail(id_contract, id_attach_service, quantity));
        request.setAttribute("message", "Create new is success");
        createContractDetails(request, response);
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Contract contract = CreateContract.createContract(request);
        Map<String, String> error = contractIBaseService.save(contract);
        if (error.isEmpty()) {
            request.setAttribute("message", "Create new is success");
            formCreateContract(request, response);
            return;
        }
        request.setAttribute("error", error);
        formCreateContract(request, response);
    }


    private void updateContract(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = CreateContract.createContract(request);
        Map<String, String> error = contractIBaseService.update(contract, id);
        if (error.isEmpty()) {
            request.setAttribute("message", "Edit is success");
            updateContractForm(request, response);
            return;
        }
        request.setAttribute("error", error);
        updateContractForm(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("displayContract");
        switch (action) {
            case "displayContract": {
                displayContract(request, response);
                break;
            }
            case "insertContract": {
                formCreateContract(request, response);
                break;
            }

            case "updateContract": {
                updateContractForm(request, response);
                break;
            }
            case "deleteContract": {
                deleteContract(request, response);
                break;
            }
            case "listContractDetails": {
                listContractDetails(request, response);
                break;
            }
            case "createContractDetails": {
                createContractDetails(request, response);
                break;
            }
            case "infoContractAllService": {
                infoContractAllService(request, response);
                break;
            }

        }
    }

    private void infoContractAllService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<ContractDetail> details = contractDetailIBaseService.searchListContractDetailById(id);
        request.setAttribute("contracts", contractIBaseService.findById(id));
        request.setAttribute("details", details);
        DataAddOnContract.transDataAddOnContract(serviceAddOnITypeService, customerIBaseService, employeeIBaseService, serviceIBaseService, request);
        request.getRequestDispatcher("views/contract/InfoContract.jsp").forward(request, response);
    }

    private void createContractDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("contracts", contractIBaseService.findById(id));
        DataAddOnContract.transDataAddOnContract(serviceAddOnITypeService, customerIBaseService, employeeIBaseService, serviceIBaseService, request);
        request.getRequestDispatcher("views/contract/CreateContractDetails.jsp").forward(request, response);
    }

    private void listContractDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContractDetail> list = contractDetailIBaseService.getList();
        request.setAttribute("listDetail", list);
        DataAddOnContract.transDataAddOnContract(serviceAddOnITypeService, customerIBaseService, employeeIBaseService, serviceIBaseService, request);
        request.getRequestDispatcher("views/contract/ContractDetail.jsp").forward(request, response);
    }


    private void updateContractForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("contracts", contractIBaseService.findById(id));
        DataAddOnContract.transDataAddOnContract(serviceAddOnITypeService, customerIBaseService, employeeIBaseService, serviceIBaseService, request);
        try {
            request.getRequestDispatcher("views/contract/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        contractIBaseService.removeById(id);
        displayContract(request, response);
    }

    private void formCreateContract(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contracts", new Contract());
        DataAddOnContract.transDataAddOnContract(serviceAddOnITypeService, customerIBaseService, employeeIBaseService, serviceIBaseService, request);
        try {
            request.getRequestDispatcher("views/contract/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayContract(HttpServletRequest request, HttpServletResponse response) {
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        String link = "displayContract";
        int max_page = contractIBaseService.countAmountFindAll();
        List<Contract> contracts = contractIBaseService.getList(offset);
        request.setAttribute("contracts", contracts);
        request.setAttribute("link", link);
        request.setAttribute("max_page", max_page);
        request.setAttribute("offset", offset);
        DataAddOnContract.transDataAddOnContract(serviceAddOnITypeService, customerIBaseService, employeeIBaseService, serviceIBaseService, request);
        try {
            request.getRequestDispatcher("views/contract/ContractList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
