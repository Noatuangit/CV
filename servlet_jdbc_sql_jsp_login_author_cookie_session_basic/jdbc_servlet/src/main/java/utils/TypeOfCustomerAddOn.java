package utils;

import models.type.TypeCustomer;
import service.ITypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TypeOfCustomerAddOn {
public static void transTypeOfCustomer(ITypeService<TypeCustomer> typeService, HttpServletRequest request,String link){
    List<TypeCustomer> typeCustomerList = typeService.getList();
    request.setAttribute("typeCustomerList", typeCustomerList);
    request.setAttribute("link", link);
}
}
