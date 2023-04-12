package crud_basic.controller;

import crud_basic.models.bill.Bill;
import crud_basic.utils.RegexCheck;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BillController {
    static List<Bill> billList  = new ArrayList<>();

    static final String COMMA_DELIMITER = ",";

    static String fileName = "src\\crud_basic\\data\\Bill.csv";

    static {
       readAndUpdateList();
    }


    public static void addNewBill(Bill bill) {
        if (isNotExistByBillId(bill) && CustomerController.isExistByCustomerId(bill.customerId)) {
            billList.add(bill);
        }
    }

    public static boolean isNotExistByBillId(Bill bill) {
        return billList.stream().noneMatch(x -> x.billId.equalsIgnoreCase(bill.billId));
    }

    public static void editBill(String id, String newId) {
        searchBillById(id).setCustomerId(newId).setTotal(searchBillById(id).calculatorTotal(CustomerController.searchCustomerById(newId)));
    }

    public static void displayBillList() {

        if (billList.isEmpty()) {
            System.out.println("Empty! Update please!");
            return;
        }

        billList.forEach(x -> System.out.println(x.toString()));
    }

    public static void displayNotShowCustomerIdList() {

        if (billList.isEmpty()) {
            System.out.println("Empty! Update please!");
            return;
        }

        billList.forEach(x -> System.out.println(x.toStringInBill()));
    }

    public static Bill searchBillById(String id) {
        return billList.stream().filter(x -> x.billId.equalsIgnoreCase(id))
                .findFirst().orElse(null);
    }

    public static boolean isNotExistCustomerById(String id) {
        return billList.stream().noneMatch(x -> x.billId.equalsIgnoreCase(id));
    }

    public static void saveCSV() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(Bill.allProps);
            bufferedWriter.newLine();
            for (Bill bill : billList) {
                bufferedWriter.write(bill.getData());
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
        String idBill = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                boolean flagId = true;

                if (line.trim().isEmpty()) continue;

                if (flag) {
                    flag = false;
                    continue;
                }

                String[] currentArray = line.split(COMMA_DELIMITER);
                List<String> tempList = new ArrayList<>();
                for (String element : currentArray) {

                    if (flagId) {
                        idBill = currentArray[0];
                        flagId = false;
                        if (RegexCheck.isNotCorrectIdBill(idBill)) {
                            continue;
                        }
                        continue;
                    }

                    tempList.add(element);
                }
                BillController.addNewBill(new Bill(idBill, tempList));
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
        Bill.autoIncrement = Integer.parseInt(idBill.substring(4));
    }
}