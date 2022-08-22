package crud_basic.controller;

import crud_basic.models.customers.Customer;
import crud_basic.models.customers.Domestic;
import crud_basic.models.customers.Foreign;
import crud_basic.utils.RegexCheck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {
    static List<Customer> customerList = new ArrayList<>();

    static String empty = "empty";

    static final String COMMA_DELIMITER = ",";

    static String fileName = "src\\crud\\data\\Customer.csv";

    static {
        readAndUpdateList();
    }


    public static void addNewCustomer(Customer customer) {
        if (isNotExistByCustomerId(customer)) {
            customerList.add(customer);
        }
    }

    public static boolean isNotExistByCustomerId(Customer customer) {
        return customerList.stream().noneMatch(x -> x.idCustomer.equalsIgnoreCase(customer.idCustomer));
    }

    public static boolean isExistByCustomerId(String str) {
        return customerList.stream().anyMatch(x -> x.idCustomer.equalsIgnoreCase(str));
    }

    public static void displayCustomerList() {
        customerList.forEach(x -> System.out.println(x.toString()));
    }

    public static Customer searchCustomerById(String id) {
        return customerList.stream().filter(x -> x.idCustomer.equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    public static void saveCSV() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(Customer.getAllProps);
            bufferedWriter.newLine();
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getData());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
        System.out.println("Saving...");
    }

    public static void readAndUpdateList() {
        File file = new File(fileName);
        if(file.length() == 0) return;

        boolean flag = true;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (line.trim().isEmpty()) continue;

                if (flag) {
                    flag = false;
                    continue;
                }

                String[] currentArray = line.split(COMMA_DELIMITER);

                if (RegexCheck.isNotCorrectIdCustomerDomestic(currentArray[0]) && RegexCheck.isNotCorrectIdCustomerForeign(currentArray[0]))
                    continue;

                List<String> tempList = new ArrayList<>();
                for (String element : currentArray) {

                    if (element.equalsIgnoreCase(empty)) {
                        continue;
                    }

                    tempList.add(element);
                }

                if (tempList.size() == 4) {
                    CustomerController.addNewCustomer(new Domestic(tempList));
                } else {
                    CustomerController.addNewCustomer(new Foreign(tempList));
                }
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
    }
}
