package crud_basic.controller;

import crud_basic.models.TypeCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TypeCustomerController {
    static List<TypeCustomer> list = new ArrayList<>();

    static final String COMMA_DELIMITER = ",";

    static String fileName = "src\\crud\\data\\TypeCustomer.csv";

    static {
        readAndUpdateList();
    }

    public static void addNewTypeCustomer(TypeCustomer typeCustomer) {
        if (isNotExistType(typeCustomer)) {
            list.add(typeCustomer);
        }
    }

    public static boolean isNotExistType(TypeCustomer typeCustomer) {
        return list.stream().noneMatch(x -> x.typeId.equalsIgnoreCase(typeCustomer.typeId));
    }

    public static TypeCustomer searchByString(String id) {
        return list.stream().filter(x -> x.typeId.equalsIgnoreCase(id) || x.fullName.equalsIgnoreCase(id)).findFirst().orElse(null);
    }

    public static boolean isNotExistId(String id) {
        return list.stream().noneMatch(x -> x.typeId.equalsIgnoreCase(id));
    }

    public static String allChoiceInTypeCustomer() {
        StringBuilder builder = new StringBuilder();
        builder.append("Only choice in Type Customer\n");
        list.forEach(x -> builder.append(x.typeId).append("-").append(x.fullName).append("  "));
        return builder.toString().trim();
    }

    public static void displayList() {
        list.forEach(System.out::println);
    }

    public static void saveCSV() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.write(TypeCustomer.getAllProps);
            bufferedWriter.newLine();
            for (TypeCustomer typeCustomer : list) {
                bufferedWriter.write(typeCustomer.getData());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
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
                TypeCustomerController.addNewTypeCustomer(new TypeCustomer(currentArray[0], currentArray[1]));
            }
        } catch (IOException e) {
            System.out.println("File NOT FOUND");
        }
    }
}
