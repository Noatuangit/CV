package crud_basic.view;

import crud_basic.controller.BillController;
import crud_basic.controller.CustomerController;
import crud_basic.controller.TypeCustomerController;
import crud_basic.models.bill.Bill;
import crud_basic.models.customers.Customer;
import crud_basic.models.customers.Domestic;
import crud_basic.models.customers.Foreign;
import crud_basic.utils.DisplayEnum;
import crud_basic.utils.HandleDataBill;
import crud_basic.utils.HandleDataCustomer;
import crud_basic.utils.enum_choice.CustomerChoice;
import crud_basic.utils.enum_choice.MainMenuChoice;

import java.util.Scanner;


public class Solution {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            TypeCustomerController.readAndUpdateList();
            MainMenuChoice option = optionMain();
            switch (option) {
                case ADD_NEW_CUSTOMER: {
                    displayAddNewCustomer();
                    break;
                }
                case DISPLAY_CUSTOMER: {
                    displayListCustomer();
                    break;
                }
                case SEARCH_CUSTOMER: {
                    displaySearchCustomer();
                    break;
                }
                case ADD_NEW_BILL: {
                    displayAddNewBill();
                    break;
                }
                case EDIT_BILL: {
                    displayEditBill();
                    break;
                }
                case DISPLAY_BILL: {
                    displayBillList();
                    break;
                }
                case QUIT:
                    return;
            }
        }
    }


    private static void displayAddNewCustomer() {
        CustomerChoice customerChoice = optionNewCustomer();
        switch (customerChoice) {
            case DOMESTIC: {
                CustomerController.addNewCustomer(new Domestic(HandleDataCustomer.collectDataCustomerFromUserInput(Domestic.getProps(), "VN")));
                CustomerController.saveCSV();
                break;
            }
            case FOREIGN: {
                CustomerController.addNewCustomer(new Foreign(HandleDataCustomer.collectDataCustomerFromUserInput(Foreign.getProps(), null)));
                CustomerController.saveCSV();
                break;
            }
            case BACK_MAIN_MENU:
                break;
        }
    }

    private static void displaySearchCustomer() {
        String idSearch = HandleDataCustomer.inputData("Id want search ");
        Customer customer = CustomerController.searchCustomerById(idSearch);
        if (customer == null) {
            System.out.printf("%s not exist in list\n", idSearch);
            return;
        }
        System.out.println(customer);
    }

    private static void displayListCustomer() {
        CustomerController.displayCustomerList();
    }

    private static void displayAddNewBill() {
        CustomerController.displayCustomerList();
        BillController.addNewBill(new Bill(HandleDataBill.collectDataBill(Bill.getProps)));
        BillController.saveCSV();
    }

    private static void displayBillList() {
        BillController.displayNotShowCustomerIdList();
    }

    private static void displayEditBill() {
        BillController.displayBillList();

        String idBill = HandleDataBill.inputData("Id bill want edit ");

        if (BillController.isNotExistCustomerById(idBill)) {
            System.out.println("Id Not Found");
            return;
        }

        System.out.println(BillController.searchBillById(idBill).toString());
        String newIdCustomer = HandleDataBill.getCustomerId("New ID Customer");
        BillController.editBill(idBill, newIdCustomer);
        BillController.saveCSV();
    }


    private static CustomerChoice optionNewCustomer() {
        return DisplayEnum.selectMenuOption(scanner, CustomerChoice.class);
    }

    private static MainMenuChoice optionMain() {
        return DisplayEnum.selectMenuOption(scanner, MainMenuChoice.class);
    }
}
