package utils;

import models.type.Division;
import models.type.Education;
import models.type.Position;
import service.ITypeService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class TypeOfEmployeeAddOn {
    public static void transTypeOfEmployee(ITypeService<Division> divisionService, ITypeService<Education>  educationService, ITypeService<Position>  positionService, HttpServletRequest request){
        List<Division> divisions = divisionService.getList();
        List<Education> educations = educationService.getList();
        List<Position> positions = positionService.getList();
        request.setAttribute("divisions", divisions);
        request.setAttribute("educations", educations);
        request.setAttribute("positions", positions);
    }
}
