package controller;

import lombok.SneakyThrows;
import models.person.Employee;
import models.professional.MainService;
import models.type.RentType;
import models.type.ServiceType;
import service.IBaseService;
import service.ITypeService;
import service.impl.service.MainServiceService;
import service.impl.service.RentTypeService;
import service.impl.service.ServiceTypeService;
import utils.CreateEmployee;
import utils.CreateService;
import utils.TypeOfEmployeeAddOn;
import utils.TypeOfServiceAddOn;

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

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    IBaseService<MainService> mainServices = new MainServiceService();
    ITypeService<RentType> rentTypeITypeService = new RentTypeService();
    ITypeService<ServiceType> typeService = new ServiceTypeService();

    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("");
        switch (action) {
            case "insertService": {
                insertService(request, response);
                break;
            }
            case "deleteService": {
                deleteService(request, response);
                break;
            }
            case "updateService": {
                updateService(request, response);
                break;
            }
        }
    }

    private void insertService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        MainService mainService = CreateService.createService(request);
        Map<String, String> error = mainServices.save(mainService);
        if (error.isEmpty()) {
            request.setAttribute("message", "Create new is success");
            formCreateService(request, response);
            return;
        }
        request.setAttribute("error", error);
        formCreateService(request, response);
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        mainServices.removeById(id);
        displayService(request, response);
    }

    private void updateService(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        MainService mainService = CreateService.createService(request);
        Map<String, String> error = mainServices.update(mainService, id);
        if (error.isEmpty()) {
            request.setAttribute("message", "Edit is success");
            updateServiceForm(request, response);
            return;
        }
        request.setAttribute("error", error);
        updateServiceForm(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = Optional.ofNullable(request.getParameter("action")).orElse("displayCustomer");
        switch (action) {
            case "displayService": {
                displayService(request, response);
                break;
            }
            case "searchNameService": {
                displaySearchService(request, response);
                break;
            }
            case "insertService": {
                formCreateService(request, response);
                break;
            }

            case "updateService": {
                updateServiceForm(request, response);
                break;
            }
        }
    }

    private void updateServiceForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("service", mainServices.findById(id));
        TypeOfServiceAddOn.TypeOfService(rentTypeITypeService, typeService, request);
        try {
            request.getRequestDispatcher("views/service/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void formCreateService(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("service", new MainService());
        TypeOfServiceAddOn.TypeOfService(rentTypeITypeService, typeService, request);
        try {
            request.getRequestDispatcher("views/service/Form.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displaySearchService(HttpServletRequest request, HttpServletResponse response) {
        String name_search = request.getParameter("name_search");
        List<MainService> services = mainServices.findByName(name_search);
        TypeOfServiceAddOn.TypeOfService(rentTypeITypeService, typeService, request);
        request.setAttribute("services", services);
        try {
            request.getRequestDispatcher("views/service/ServiceList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void displayService(HttpServletRequest request, HttpServletResponse response) {
        int offset = Integer.parseInt(Optional.ofNullable(request.getParameter("offset")).orElse("0"));
        String link = "displayService";
        int max_page = mainServices.countAmountFindAll();
        List<MainService> services = mainServices.getList(offset);
        request.setAttribute("services", services);
        request.setAttribute("link", link);
        request.setAttribute("max_page", max_page);
        TypeOfServiceAddOn.TypeOfService(rentTypeITypeService, typeService, request);
        try {
            request.getRequestDispatcher("views/service/ServiceList.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
