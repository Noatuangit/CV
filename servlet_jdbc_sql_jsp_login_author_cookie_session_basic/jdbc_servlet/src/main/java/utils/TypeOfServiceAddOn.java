package utils;

import models.type.RentType;
import models.type.ServiceType;
import service.ITypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TypeOfServiceAddOn {
    public static void TypeOfService(ITypeService<RentType> rentType, ITypeService<ServiceType> serviceType, HttpServletRequest request) {
        List<RentType> rentTypeList = rentType.getList();
        List<ServiceType> serviceTypes = serviceType.getList();
        request.setAttribute("listRent",rentTypeList);
        request.setAttribute("listService",serviceTypes);

    }
}
