package crud_basic.models.customers;

import crud_basic.controller.TypeCustomerController;
import crud_basic.models.TypeCustomer;

import java.util.List;

public class Domestic extends Customer {
    public TypeCustomer typeCustomer;

    public int electricNorm;

    public Domestic(List<String> list) {
        super(list.get(0), list.get(1));
        this.typeCustomer = TypeCustomerController.searchByString(list.get(2));
        this.electricNorm = Integer.parseInt(list.get(3));
    }

    public static String getProps() {
        return "idCustomer,fullName,typeCustomer,Number_electricNorm";
    }

    public String getData() {
        return String.format("%s,%s,%s,%d,empty", getIdCustomer(), getFullName(), typeCustomer.typeId, electricNorm);
    }

    @Override
    public String toString() {
        return "Domestic{" +
                "idCustomer='" + idCustomer + '\'' +
                ", fullName='" + fullName + '\'' +
                ", typeCustomer=" + typeCustomer +
                ", electricNorm=" + electricNorm +
                '}';
    }

    @Override
    public String toStringInBill() {
        return "Domestic{" +
                "fullName='" + fullName + '\'' +
                ", typeCustomer=" + typeCustomer +
                ", electricNorm=" + electricNorm +
                '}';
    }
}
