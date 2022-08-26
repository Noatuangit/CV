package controller;

import lombok.SneakyThrows;
import models.person.Employee;
import models.type.Division;
import models.type.Education;
import models.type.Position;
import service.IBaseService;
import service.ITypeService;
import service.impl.employee.DivisionService;
import service.impl.employee.EducationService;
import service.impl.employee.EmployeeService;
import service.impl.employee.PositionService;
import utils.CreateEmployee;
import utils.TypeOfEmployeeAddOn;

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

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    IBaseService<Employee> employeeService = new EmployeeService();
    ITypeService<Division> divisionService = new DivisionService();
    ITypeService<Position> positionService = new PositionService();
    ITypeService<Education> educationService = new EducationService();

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "insertEmployee": {
                insertEmployee(request, response);
                break;
            }
            case "deleteEmployee": {
                deleteEmployee(request, response);
                break;
            }
            case "updateEmployee": {
                updateEmployee(request, response);
                break;
            }
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = CreateEmployee.createEmployee(request);
        Map<String, String> error = employeeService.update(employee, id);
        if (error.isEmpty()) {
            request.setAttribute("message", "Edit is success");
            updateEmployeeForm(request, response);
            return;
        }
        request.setAttribute("error", error);
        updateEmployeeForm(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.removeById(id);
        displayEmployee(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Employee employee = CreateEmployee.createEmployee(request);
        Map<String, String> error = employeeService.save(employee);
        if (error.isEmpty()) {
            request.setAttribute("message", "Create new is success");
            formCreateEmployee(request, response);
            return;
        }
        request.setAttribute("error", error);
        formCreateEmployee(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("displayCustomer");
        switch (action) {
            case "displayEmployee": {
                displayEmployee(request, response);
                break;
            }
            case "searchNameEmployee": {
                displaySearchEmployee(request, response);
                break;
            }
            case "insertEmployee": {
                formCreateEmployee(request, response);
                break;
            }

            case "updateEmployee": {
                updateEmployeeForm(request, response);
                break;
            }
        }
    }

    private void displayEmployee(HttpServletRequest request, HttpServletResponse response) {
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        String link = "displayEmployee";
        int max_page = employeeService.countAmountFindAll();
        List<Employee> employees = employeeService.getList(offset);
        request.setAttribute("employees", employees);
        request.setAttribute("link", link);
        request.setAttribute("max_page", max_page);
        TypeOfEmployeeAddOn.transTypeOfEmployee(divisionService, educationService, positionService, request);
        try {
            request.getRequestDispatcher("views/employee/EmployeeList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreateEmployee(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("employee", new Employee());
        TypeOfEmployeeAddOn.transTypeOfEmployee(divisionService, educationService, positionService, request);
        try {
            request.getRequestDispatcher("views/employee/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displaySearchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name_search = request.getParameter("name_search");
        List<Employee> employees = employeeService.findByName(name_search);
        request.setAttribute("employees", employees);
        TypeOfEmployeeAddOn.transTypeOfEmployee(divisionService, educationService, positionService, request);
        try {
            request.getRequestDispatcher("views/employee/EmployeeList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployeeForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("employee", employeeService.findById(id));
        TypeOfEmployeeAddOn.transTypeOfEmployee(divisionService, educationService, positionService, request);
        try {
            request.getRequestDispatcher("views/employee/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
