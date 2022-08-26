package controller;

import lombok.SneakyThrows;
import models.person.Customer;
import models.type.TypeCustomer;
import reposition.impl.customer.CustomerRepository;
import service.IBaseService;
import service.ITypeService;
import service.impl.customer.CustomerService;
import service.impl.customer.TypeCustomerService;
import utils.CreateCustomer;
import utils.FindAmountPage;
import utils.TypeOfCustomerAddOn;

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

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    IBaseService<Customer> customerService = new CustomerService();
    ITypeService<TypeCustomer> typeService = new TypeCustomerService();


    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "insertCustomer": {
                insertCustomer(request, response);
                break;
            }
            case "updateCustomer": {
                updateCustomer(request, response);
                break;
            }
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = CreateCustomer.createCustomer(request);
        Map<String, String> error = customerService.update(customer, id);
        if (error.isEmpty()) {
            request.setAttribute("message", "Edit is success");
            updateCustomerForm(request, response);
            return;
        }
        request.setAttribute("error", error);
        updateCustomerForm(request, response);
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Customer customer = CreateCustomer.createCustomer(request);
        Map<String, String> error = customerService.save(customer);
        if (error.isEmpty()) {
            request.setAttribute("message", "Create new is success");
            formCreateCustomer(request, response);
            return;
        }
        request.setAttribute("error", error);
        formCreateCustomer(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("displayCustomer");
        switch (action) {
            case "displayCustomer": {
                displayCustomer(request, response);
                break;
            }
            case "searchNameCustomer": {
                displaySearchCustomer(request, response);
                break;
            }
            case "listCustomerHaveContract": {
                listCustomerHaveContract(request, response);
                break;
            }
            case "insertCustomer": {
                formCreateCustomer(request, response);
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
        }
    }

    private void listCustomerHaveContract(HttpServletRequest request, HttpServletResponse response) {
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        List<Customer> customers = customerService.getListHaveContract(offset);
        int max_page = FindAmountPage.findAmountPage(CustomerRepository.count_list_have_contract, CustomerRepository.MAX_LIMIT_DISPLAY);
        request.setAttribute("customers", customers);
        request.setAttribute("max_page", max_page);
        TypeOfCustomerAddOn.transTypeOfCustomer(typeService, request, "listCustomerHaveContract");
        try {
            request.getRequestDispatcher("views/customer/CustomerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void displayCustomer(HttpServletRequest request, HttpServletResponse response) {
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        List<Customer> customers = customerService.getList(offset);
        int max_page = customerService.countAmountFindAll();
        request.setAttribute("customers", customers);
        request.setAttribute("max_page", max_page);
        TypeOfCustomerAddOn.transTypeOfCustomer(typeService, request, "displayCustomer");
        try {
            request.getRequestDispatcher("views/customer/CustomerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displaySearchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name_search = request.getParameter("name_search");
        List<Customer> customers = customerService.findByName(name_search);
        List<TypeCustomer> typeCustomerList = typeService.getList();
        request.setAttribute("customers", customers);
        request.setAttribute("typeCustomerList", typeCustomerList);
        try {
            request.getRequestDispatcher("views/customer/CustomerList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreateCustomer(HttpServletRequest request, HttpServletResponse response) {
        Customer customer = new Customer();
        List<TypeCustomer> listType = typeService.getList();
        request.setAttribute("customer", customer);
        request.setAttribute("listType", listType);
        try {
            request.getRequestDispatcher("views/customer/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.removeById(id);
        displayCustomer(request, response);
    }

    private void updateCustomerForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<TypeCustomer> listType = typeService.getList();
        Customer customer = customerService.findById(id);
        request.setAttribute("customer", customer);
        request.setAttribute("listType", listType);
        try {
            request.getRequestDispatcher("views/customer/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
