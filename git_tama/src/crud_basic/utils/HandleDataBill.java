package crud_basic.utils;

import crud_basic.controller.CustomerController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HandleDataBill {
    static Scanner scanner = new Scanner(System.in);

    public static String COMMA_DELIMITER = ",";


    public static List<String> collectDataBill(String props) {
        String[] properties = props.split(COMMA_DELIMITER);
        List<String> list = new ArrayList<>();
        for (String line : properties) {
            if (line.equalsIgnoreCase("CustomerId")) {
                list.add(getCustomerId(line));
                continue;
            }

            if (line.equalsIgnoreCase("Date")) {
                list.add(getDateTimeValue(line));
                continue;
            }

            list.add(getNumberValue(line));
        }
        return list;
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

    public static String getCustomerId(String line) {
        while (true) {
            String customerId = inputData(line);

            if (CustomerController.searchCustomerById(customerId) == null) {
                System.out.println(customerId + " Not found again");
                continue;
            }

            return customerId;
        }
    }

    public static String getDateTimeValue(String line) {
        String data;
        while (true) {
            try {
                System.out.println("Input " + line);
                data = scanner.nextLine();
                CheckDayException.checkCorrectDay(data);
                break;
            } catch (CheckDayException e) {
                System.out.println(e.getMessage());
            }
        }
        return data;
    }

    public static String changeFromLocalDateToString(LocalDate localDate) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatters);
    }

    public static LocalDate changeFromStringToLocalDate(String str) {
        return LocalDate.parse(str, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String inputData(String line) {
        System.out.println("Input " + line);
        return scanner.nextLine();
    }
}
