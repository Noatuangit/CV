package utils;

import models.person.Customer;
import models.person.Employee;
import models.professional.Contract;
import models.professional.MainService;

import java.util.HashMap;
import java.util.Map;

public class ValidData {
    public static Map<String, String> validData(Customer customer) {
        Map<String, String> mapError = new HashMap<>();
        if (!customer.getName().matches("^[a-zA-Z ,.'-]+$")) {
            mapError.put("name", "Name Only text case");
        }
        if (!customer.getId_card().matches("^CT-\\d{4}$")) {
            mapError.put("id_card", "Id card Must CT-1124");
        }
        if (!customer.getPhone().matches("^0\\d{9}$")) {
            mapError.put("phone", "Phone Must 0123456789");
        }
        if (!customer.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            mapError.put("email", "Email not correct type");
        }
        return mapError;
    }

    public static Map<String, String> validData(Employee employee) {
        Map<String, String> mapError = new HashMap<>();
        if (!employee.getName().matches("^[a-zA-Z ,.'-]+$")) {
            mapError.put("name", "Name Only text case");
        }
//        if (employee.getSalary() <= 0) {
//            mapError.put("salary", "salary Must Bigger 0");
//        }
        checkBiggerZero(employee.getSalary(), mapError, "salary", "salary Must Bigger 0");
        if (!employee.getId_card().matches("^NV-\\d{3}$")) {
            mapError.put("id_card", "Id card Must NV-123");
        }
        if (!employee.getPhone().matches("^0\\d{9}$")) {
            mapError.put("phone", "Phone Must 0123456789");
        }
        if (!employee.getEmail().matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            mapError.put("email", "Email not correct type");
        }
        return mapError;
    }

    public static Map<String, String> validData(MainService mainService) {
        Map<String, String> mapError = new HashMap<>();
        checkBiggerZero(mainService.getArea(), mapError, "area", "area Must Bigger 0");
        checkBiggerZero(mainService.getCost(), mapError, "cost", "cost Must Bigger 0");
        checkBiggerZero(mainService.getMax_people(), mapError, "max_people", "Max people Must Bigger 0");
        checkBiggerZero(mainService.getPool_area(), mapError, "pool_area", "Pool area Must Bigger 0");
        checkBiggerZero(mainService.getNumber_of_floors(), mapError, "number_of_floors", "Number Of Floors Must Bigger 0");
        return mapError;
    }
    public static Map<String, String> validData(Contract contract) {
        Map<String, String> mapError = new HashMap<>();
        if (contract.getEnd_day().before(contract.getStart_day())) {
            mapError.put("end_date", "DAY END MUST AFTER DAY BEGIN");
        }
        checkBiggerZero(contract.getDeposit(), mapError, "deposit", "Deposit Must Bigger 0");
        return mapError;
    }

    public static void checkBiggerZero(int target, Map<String, String> map, String key, String nameOutPut) {
        if (target <= 0) {
            map.put(key, nameOutPut);
        }
    }

    public static void checkBiggerZero(double target, Map<String, String> map, String key, String nameOutPut) {
        if (target <= 0) {
            map.put(key, nameOutPut);
        }
    }
}

