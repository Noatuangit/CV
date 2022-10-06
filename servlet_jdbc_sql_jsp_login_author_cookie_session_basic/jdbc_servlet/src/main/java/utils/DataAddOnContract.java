package utils;

import models.person.Customer;
import models.person.Employee;
import models.professional.AttachServiceAddOn;
import models.professional.MainService;
import service.IBaseService;
import service.ITypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DataAddOnContract {
    public static void transDataAddOnContract(ITypeService<AttachServiceAddOn> addOnITypeService, IBaseService<Customer> customerITypeService, IBaseService<Employee> employeeITypeService, IBaseService<MainService> mainServiceIBaseService, HttpServletRequest request) {
        List<Customer> customers = customerITypeService.getList();
        List<Employee> employees = employeeITypeService.getList();
        List<MainService> services = mainServiceIBaseService.getList();
        List<AttachServiceAddOn> addOnList = addOnITypeService.getList();
        request.setAttribute("customers", customers);
        request.setAttribute("employees", employees);
        request.setAttribute("services", services);
        request.setAttribute("addOnList", addOnList);

    }
}
