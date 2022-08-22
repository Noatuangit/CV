package utils;

import models.extra.Division;
import models.extra.Education;
import models.extra.Position;
import models.extra.TypeCustomer;
import models.professional_furama.AttachService;
import models.professional_furama.Service;
import models.person.Customer;
import models.person.Employee;
import repository.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DivertUrl {
    public static void divertContractNextLink(HttpServletRequest request, HttpServletResponse response, String link) {
        CustomerService customerService = new CustomerService();
        ServiceControl serviceControl = new ServiceControl();
        EmployeeService employeeService = new EmployeeService();
        List<Customer> customers = customerService.getList();
        List<Service> services = serviceControl.getList();
        List<Employee> employees = employeeService.getList();
        request.setAttribute("customers", customers);
        request.setAttribute("services", services);
        request.setAttribute("employees", employees);
        try {
            request.getRequestDispatcher(link).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void divertEmployeeNextLink(HttpServletRequest request, HttpServletResponse response, String link) {
        PositionService positionService = new PositionService();
        DivisionService divisionService = new DivisionService();
        EducationService educationService = new EducationService();
        List<Position> positions = positionService.getList("positions");
        List<Division> divisions = divisionService.getList("division");
        List<Education> educations = educationService.getList("education_degree");
        request.setAttribute("positions", positions);
        request.setAttribute("divisions", divisions);
        request.setAttribute("educations", educations);
        try {
            request.getRequestDispatcher(link).forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void divertCustomerNextLink(HttpServletRequest request, HttpServletResponse response, String link) {
        TypeCustomerService typeCustomerService = new TypeCustomerService();
        List<TypeCustomer> listType = typeCustomerService.getList("type_customer");
        request.setAttribute("listType", listType);
        try {
            request.getRequestDispatcher(link).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void divertServiceNextLink(HttpServletRequest request, HttpServletResponse response, String link) {
        RentService rentService = new RentService();
        TypeServiceControl typeServiceControl = new TypeServiceControl();
        request.setAttribute("listRent", rentService.getList("rent_type"));
        request.setAttribute("listService", typeServiceControl.getList("service_type"));
        try {
            request.getRequestDispatcher(link).forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void divertContractDetailsNextLink(HttpServletRequest request, HttpServletResponse response, String link, int id) {
        ContractService contractService = new ContractService();
        AttachServiceControl control = new AttachServiceControl();
        List<AttachService> list = control.getList("attach_service");
        request.setAttribute("list", list);
        request.setAttribute("contract", contractService.searchDTO(id, Query.search_contract_to_show_info));
        try {
            request.getRequestDispatcher(link).forward(request, response);
        } catch (ServletException | IOException e) {
            request.setAttribute("error", e);
            request.getRequestDispatcher("error_check/ErrorId.jsp");
        }
    }
}