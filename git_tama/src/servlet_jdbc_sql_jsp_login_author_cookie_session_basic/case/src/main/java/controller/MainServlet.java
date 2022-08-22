package controller;

import repository.DetailsService;
import models.professional_furama.Contract;
import models.person.Customer;
import models.person.Employee;
import models.professional_furama.ContractDetail;
import models.professional_furama.Service;
import service.impl.ContractService;
import service.impl.CustomerService;
import service.impl.EmployeeService;
import service.impl.ServiceControl;
import utils.DivertUrl;
import utils.Query;
import utils.Utils;

import java.io.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "mainServlet", value = "/list")
public class MainServlet extends HttpServlet {
    public static final int MAX_LIMIT_DISPLAY = 5;

    public void init() {
    }

    // sai lầm chia luồng để giảm tải, dễ tìm và đúng hơn
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("login");
        switch (action) {
            case "displayCustomer": {
                displayCustomer(request, response);
                break;
            }
            case "searchNameCustomer": {
                displaySearchCustomer(request, response);
                break;
            }
            case "insertCustomer": {
                formInsertCustomer(request, response);
                break;
            }
            case "deleteCustomer": {
                deleteCustomer(request, response);
                break;
            }
            case "updateCustomer": {
                updateCustomerForm(request, response);
                break;
            }
            case "displayEmployee": {
                displayEmployee(request, response);
                break;
            }
//            case "deleteEmployee": {
//                deleteEmployee(request, response);
//                break;
//            }

            case "searchNameEmployee": {
                displaySearchEmployee(request, response);
                break;
            }
            case "updateEmployee": {
                updateEmployeeForm(request, response);
                break;
            }
            case "insertEmployee": {
                formInsertEmployee(request, response);
                break;
            }
            case "displayService": {
                displayService(request, response);
                break;
            }
            case "deleteService": {
                deleteService(request, response);
                break;
            }
            case "insertService": {
                formInsertService(request, response);
                break;
            }
            case "searchNameService": {
                displaySearchNameService(request, response);
                break;
            }
            case "updateService": {
                updateServiceForm(request, response);
                break;
            }
            case "displayContract": {
                displayContract(request, response);
                break;
            }
            case "insertContract": {
                formInsertContract(request, response);
                break;
            }
            case "deleteContract": {
                deleteContract(request, response);
                break;
            }
            case "updateContract": {
                formUpdateContract(request, response);
                break;
            }
            case "createContractDetails": {
                formInsertContractDetails(request, response);
                break;
            }
            case "showInfo": {
                InfoContactSelect(request, response);
                break;
            }
            case "listContractDetails": {
                listContractDetails(request, response);
                break;
            }
            case "listCustomerHaveContract": {
                listCustomerHaveContract(request, response);
                break;
            }
        }
    }

    private void displaySearchCustomer(HttpServletRequest request, HttpServletResponse response) {
        CustomerService customerService = new CustomerService();
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String name_search = request.getParameter("name_search");
        List<Customer> list = customerService.searchDTOByName(name_search);
        int max_page = 1; // chỉ muốn hiện 1 trang
        String link = "searchNameCustomer";
        request.setAttribute("list", list);
        request.setAttribute("link", link);
        request.setAttribute("max_page", max_page);
        try {
            request.getRequestDispatcher("CustomerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("error_check/ErrorId.jsp");
        }
    }

    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) {
        CustomerService customerService = new CustomerService();
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        String link = "displayCustomer";
        List<Customer> list = customerService.getList(Query.list_customer, MAX_LIMIT_DISPLAY, offset);
        int max_page = (int) Math.ceil((float) customerService.get_all_customer(Query.all_customer) / MAX_LIMIT_DISPLAY);
        request.setAttribute("list", list);
        request.setAttribute("link", link);
        request.setAttribute("max_page", max_page);
        try {
            request.getRequestDispatcher("CustomerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        CustomerService customerService = new CustomerService();
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.deleteDTO(id);
        displayCustomer(request, response);
    }

    private void updateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        CustomerService service = new CustomerService();
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = service.searchDTO(id);
        request.setAttribute("customer", customer);
        DivertUrl.divertCustomerNextLink(request, response, "update/EditCustomer.jsp");
    }

    private void formInsertCustomer(HttpServletRequest request, HttpServletResponse response) {
        DivertUrl.divertCustomerNextLink(request, response, "create/CreateCustomer.jsp");
    }

    private void listContractDetails(HttpServletRequest request, HttpServletResponse response) {
        DetailsService detailsService = new DetailsService();
        List<ContractDetail> list = detailsService.getList("contract_details");
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("DetailsList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("error_check/ErrorId.jsp");
        }
    }

    private void InfoContactSelect(HttpServletRequest request, HttpServletResponse response) {
        DetailsService detailsService = new DetailsService();
        int id = Integer.parseInt(request.getParameter("id"));
        List<ContractDetail> contractDetail = detailsService.searchContractDetail(id);
        request.setAttribute("details", contractDetail);
        DivertUrl.divertContractDetailsNextLink(request, response, "InfoContractAllService.jsp", id);
    }

    private void formInsertContractDetails(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        DivertUrl.divertContractDetailsNextLink(request, response, "create/CreateContractDetails.jsp", id);
    }

    private void formUpdateContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ContractService contractService = new ContractService();
        Contract contract = contractService.searchDTO(id);
        request.setAttribute("contract", contract);
        DivertUrl.divertContractNextLink(request, response, "update/EditContract.jsp");
    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ContractService contractService = new ContractService();
        contractService.deleteDTO(id);
        displayContract(request, response);
    }

    private void formInsertContract(HttpServletRequest request, HttpServletResponse response) {
        DivertUrl.divertContractNextLink(request, response, "create/CreateContract.jsp");
    }


    private void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        EmployeeService employeeService = new EmployeeService();
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.searchDTO(id);
        request.setAttribute("employee", employee);
        DivertUrl.divertEmployeeNextLink(request, response, "update/EditEmployee.jsp");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        EmployeeService service = new EmployeeService();
        int id = Integer.parseInt(request.getParameter("id"));
        service.deleteDTO(id);
        displayEmployee(request, response);
    }

    private void formInsertEmployee(HttpServletRequest request, HttpServletResponse response) {
        DivertUrl.divertEmployeeNextLink(request, response, "create/CreateEmployee.jsp");
    }


    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) {
        EmployeeService employeeService = new EmployeeService();
        List<Employee> list = employeeService.getList(Query.list_employee);
        request.setAttribute("list", list);
        DivertUrl.divertEmployeeNextLink(request, response, "EmployeeList.jsp");
    }


    private void displayService(HttpServletRequest request, HttpServletResponse response) {
        ServiceControl serviceControl = new ServiceControl();
        List<Service> list = serviceControl.getList(Query.list_service);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("ServiceList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("error_check/ErrorId.jsp");
        }
    }

    private void displayContract(HttpServletRequest request, HttpServletResponse response) {
        ContractService contractService = new ContractService();
        List<Contract> list = contractService.getList(Query.list_contract);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("ContractList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("error_check/ErrorId.jsp");
        }
    }

    private void displaySearchNameService(HttpServletRequest request, HttpServletResponse response) {
        ServiceControl serviceControl = new ServiceControl();
        String name = request.getParameter("name_search");
        List<Service> list = serviceControl.searchDTOByName(name);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("ServiceList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("error_check/ErrorId.jsp");
        }
    }

    private void updateServiceForm(HttpServletRequest request, HttpServletResponse response) {
        ServiceControl serviceControl = new ServiceControl();
        int id = Integer.parseInt(request.getParameter("id"));
        Service service = serviceControl.searchDTO(id);
        request.setAttribute("service", service);
        DivertUrl.divertServiceNextLink(request, response, "update/EditService.jsp");

    }

    private void formInsertService(HttpServletRequest request, HttpServletResponse response) {
        DivertUrl.divertServiceNextLink(request, response, "create/CreateService.jsp");
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        ServiceControl serviceControl = new ServiceControl();
        int id = Integer.parseInt(request.getParameter("id"));
        serviceControl.deleteDTO(id);
        displayService(request, response);
    }


    private void displaySearchEmployee(HttpServletRequest request, HttpServletResponse response) {
        EmployeeService employeeService = new EmployeeService();
        String name = request.getParameter("name_search");
        List<Employee> list = employeeService.searchDTOByName(name);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("EmployeeList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("ErrorId.jsp");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("login");
        switch (action) {
            case "insertCustomer": {
                insertCustomer(request, response);
                break;
            }
            case "updateCustomer": {
                updateCustomer(request, response);
                break;
            }
            case "insertEmployee": {
                insertEmployee(request, response);
                break;
            }
            case "updateEmployee": {
                updateEmployee(request, response);
                break;
            }
            case "insertService": {
                insertService(request, response);
                break;
            }
            case "updateService": {
                updateService(request, response);
                break;
            }
            case "insertContract": {
                insertContract(request, response);
                break;
            }
            case "updateContract": {
                updateContract(request, response);
                break;
            }
            case "createContractDetails": {
                createContractDetails(request, response);
                break;
            }
            case "deleteEmployee": {
                deleteEmployee(request, response);
                break;
            }

        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CustomerService customerService = new CustomerService();
        try {
            customerService.insertDTO(Utils.createCustomer(request));
            displayCustomer(request, response);
        } catch (SQLException e) {
            response.sendRedirect(String.format("error_check/ErrorId.jsp?code=%s&&link=%s", e.getMessage(), "/list?action=insertCustomer"));
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        CustomerService customerService = new CustomerService();
        try {
            customerService.updateDTO(Utils.createCustomer(request));
            displayCustomer(request, response);
        } catch (SQLException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("error_check/ErrorId.jsp");
        }
    }

    private void createContractDetails(HttpServletRequest request, HttpServletResponse response) throws IOException {
        DetailsService detailsService = new DetailsService();
        try {
            detailsService.insertDTO(Utils.createContractDetails(request));
            displayContract(request, response);
        } catch (SQLException e) {
            response.sendRedirect(String.format("error_check/ErrorId.jsp?code=%s&&link=%s", e.getMessage(), "/list?action=displayContract"));
        }
    }

    private void insertContract(HttpServletRequest request, HttpServletResponse response) {
        Timestamp start_date = Timestamp.valueOf(request.getParameter("start_date").replace("T", " ").concat(":00"));
        Timestamp end_date = Timestamp.valueOf(request.getParameter("end_date").replace("T", " ").concat(":00"));
        double deposit = Double.parseDouble(request.getParameter("deposit"));
        String customers = request.getParameter("customers");
        String employees = request.getParameter("employees");
        String services = request.getParameter("services");
        if (end_date.before(start_date)) {
            request.setAttribute("message", "DAY END MUST AFTER DAY BEGIN");
            formInsertContract(request, response);
            return;
        }
        ContractService contractService = new ContractService();
        contractService.insertDTO(start_date, end_date, deposit, employees, customers, services);
        displayContract(request, response);
    }


    private void updateContract(HttpServletRequest request, HttpServletResponse response) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Timestamp start_date = Timestamp.valueOf(request.getParameter("start_date").replace("T", " ").concat(":00"));
            Timestamp end_date = Timestamp.valueOf(request.getParameter("end_date").replace("T", " ").concat(":00"));
            double deposit = Double.parseDouble(request.getParameter("deposit"));
            String customers = request.getParameter("customers");
            String employees = request.getParameter("employees");
            String services = request.getParameter("services");
            if (end_date.before(start_date)) {
                request.setAttribute("message", "DAY END MUST AFTER DAY BEGIN");
                formUpdateContract(request, response);
                return;
            }
            ContractService contractService = new ContractService();
            contractService.updateDTO(id, start_date, end_date, deposit, employees, customers, services);
            displayContract(request, response);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) {
        ServiceControl serviceControl = new ServiceControl();
        try {
            serviceControl.updateDTO(Utils.createService(request));
            displayService(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServiceControl serviceControl = new ServiceControl();
        try {
            serviceControl.insertDTO(Utils.createService(request));
            displayService(request, response);
        } catch (SQLException e) {
            response.sendRedirect(String.format("error_check/ErrorId.jsp?code=%s&&link=%s", e.getMessage(), "/list?action=insertService"));
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws RuntimeException, IOException {
        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.insertDTO(Utils.createEmployee(request));
            displayEmployee(request, response);
        } catch (SQLException e) {
            response.sendRedirect(String.format("error_check/ErrorId.jsp?code=%s&&link=%s", e.getMessage(), "/list?action=insertEmployee"));
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        EmployeeService employeeService = new EmployeeService();
        try {
            employeeService.updateDTO(Utils.createEmployee(request));
            displayEmployee(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void listCustomerHaveContract(HttpServletRequest request, HttpServletResponse response) {
        CustomerService customerService = new CustomerService();
        int max_page = (int) Math.ceil((float) customerService.get_all_customer(Query.all_customer_use_contract) / MAX_LIMIT_DISPLAY);
        String link = "listCustomerHaveContract";
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        List<Customer> list = customerService.getList(Query.list_customer_use_contract, MAX_LIMIT_DISPLAY, offset);
        request.setAttribute("link", link);
        request.setAttribute("max_page", max_page);
        request.setAttribute("list", list);
        try {
            request.getRequestDispatcher("CustomerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void destroy() {
    }
}