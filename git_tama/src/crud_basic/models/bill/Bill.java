package crud_basic.models.bill;

import crud_basic.controller.CustomerController;
import crud_basic.models.customers.Customer;
import crud_basic.models.customers.Domestic;
import crud_basic.utils.HandleDataBill;

import java.time.LocalDate;
import java.util.List;

public class Bill {
    public final static String allProps = "BillId,CustomerId,Date,Number_Amount,Number_Unit_Price,Total";

    public static String getProps = "CustomerId,Date,Number_Amount,Number_Unit_Price";

    public static int autoIncrement = 0;
    public String billId;
    public String customerId;
    public LocalDate date;
    public double amount;
    public double unitPrice;
    public double total;

    public Bill(List<String> list) {
        this.billId = controlIdBill(++autoIncrement);
        this.customerId = CustomerController.searchCustomerById(list.get(0)).idCustomer;
        this.date = HandleDataBill.changeFromStringToLocalDate(list.get(1));
        this.amount = Double.parseDouble(list.get(2));
        this.unitPrice = Double.parseDouble(list.get(3));
        this.total = calculatorTotal(CustomerController.searchCustomerById(list.get(0)));
    }

    public Bill(String billId, List<String> list) {
        this.billId = billId;
        this.customerId = (list.get(0));
        this.date = HandleDataBill.changeFromStringToLocalDate(list.get(1));
        this.amount = Double.parseDouble(list.get(2));
        this.unitPrice = Double.parseDouble(list.get(3));
        this.total = calculatorTotal(CustomerController.searchCustomerById(list.get(0)));
    }

    public double calculatorTotal(Customer customer) {
        if (customer instanceof Domestic) {
            if (((Domestic) customer).electricNorm > amount) return amount * unitPrice;
            if (((Domestic) customer).electricNorm < amount) return amount * unitPrice * 1.5d;
        }
        return amount * unitPrice;
    }

    public String getData() {
        return String.format("%s,%s,%s,%12.1f,%12.1f,%12.1f", billId, customerId,
                HandleDataBill.changeFromLocalDateToString(date), amount, unitPrice, total);
    }

    public String controlIdBill(int id) {
        if (id >= 100) return "MHD-" + id;
        if (id >= 10) return "MHD-0" + id;
        return "MHD-00" + id;
    }

    public Bill setCustomerId(String customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }


    public LocalDate getDate() {
        return date;
    }

    public Bill setDate(LocalDate date) {
        this.date = date;
        return this;

    }

    public double getAmount() {
        return amount;
    }

    public Bill setAmount(double amount) {
        this.amount = amount;
        return this;

    }

    public double getTotal() {
        return total;
    }

    public Bill setTotal(double total) {
        this.total = total;
        return this;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", customer='" + CustomerController.searchCustomerById(customerId).toString() + '\'' +
                ", date=" + HandleDataBill.changeFromLocalDateToString(date) +
                ", amount=" + amount +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                '}';
    }

    public String toStringInBill() {
        return "Bill{" +
                "billId='" + billId + '\'' +
                ", customer='" + CustomerController.searchCustomerById(customerId).toStringInBill() + '\'' +
                ", date=" + HandleDataBill.changeFromLocalDateToString(date) +
                ", amount=" + amount +
                ", unitPrice=" + unitPrice +
                ", total=" + total +
                '}';
    }
}
