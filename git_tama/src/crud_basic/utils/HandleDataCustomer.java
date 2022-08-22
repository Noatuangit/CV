package crud_basic.utils;

import crud_basic.controller.TypeCustomerController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleDataCustomer {
    public static Scanner scanner = new Scanner(System.in);

    public static String COMMA_DELIMITER = ",";

    public static List<String> collectDataCustomerFromUserInput(String props, String nation) {
        String[] properties = props.split(COMMA_DELIMITER);
        List<String> result = new ArrayList<>();
        for (String line : properties) {
            if (line.equalsIgnoreCase("typeCustomer")) {
                result.add(getTypeCustomer(line));
                continue;
            }

            if (line.contains("Number")) {
                result.add(getNumberValue(line));
                continue;
            }

            if (line.equalsIgnoreCase("idCustomer")) {
                if (nation.equalsIgnoreCase("VN")) {
                    result.add(getCustomerIdDomestic(line));
                    continue;
                }
                result.add(getCustomerIdForeign(line));
                continue;
            }

            result.add(inputData(line));
        }
        return result;
    }

    private static String getCustomerIdForeign(String line) {
        String customerId;
        while (true) {
            System.out.println("Input " + line);
            customerId = (scanner.nextLine());
            if (RegexCheck.isNotCorrectIdCustomerForeign(customerId)) {
                System.out.println("Type KHNN-1234");
                continue;
            }
            return customerId.toUpperCase();
        }
    }

    private static String getCustomerIdDomestic(String line) {
        String customerId;
        while (true) {
            System.out.println("Input " + line);
            customerId = (scanner.nextLine());
            if (RegexCheck.isNotCorrectIdCustomerDomestic(customerId)) {
                System.out.println("Type KHVN-1234");
                continue;
            }
            return customerId.toUpperCase();
        }
    }
    private static String getTypeCustomer(String line) {
        String typeCustomer;
        while (true) {
            TypeCustomerController.displayList();
            System.out.println("Input " + line);
            typeCustomer = (scanner.nextLine()).toUpperCase();
            if (TypeCustomerController.isNotExistId(typeCustomer)) {
                System.out.println(TypeCustomerController.allChoiceInTypeCustomer());
                continue;
            }
            return typeCustomer.toUpperCase();
        }
    }

    public static String getNumberValue(String line) {
        int number;
        while (true) {
            try {
                System.out.println("Input " + line);
                number = Integer.parseInt(scanner.nextLine());

                if (number < 0) {
                    System.out.println(line + " BIGGER ZERO");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println(line + " MUST NUMBER");
            }
        }
        return String.valueOf(number);
    }

    public static String inputData(String line) {
        boolean flagAgain = false;
        while (true) {
            String currentLine = flagAgain ? String.format("Input %s Again",line) : String.format("Input %s",line);
            System.out.println(currentLine);
            String str = scanner.nextLine();
            if(!str.trim().isEmpty()){
                return str;
            }
            flagAgain = true;
        }
    }

}
