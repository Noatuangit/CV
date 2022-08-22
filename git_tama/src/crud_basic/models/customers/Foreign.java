package crud_basic.models.customers;

import java.util.List;

public class Foreign extends Customer {
    public String nation;

    public Foreign(List<String> list) {
        super(list.get(0), list.get(1));
        this.nation = (list.get(2));
    }

    public static String getProps() {
        return "idCustomer,fullName,nation";
    }

    public String getData() {
        return String.format("%s,%s,empty,empty,%s", getIdCustomer(), getFullName(), nation);
    }

    @Override
    public String toString() {
        return "Foreign{" +
                "idCustomer='" + idCustomer + '\'' +
                ", fullName='" + fullName + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }

    @Override
    public String toStringInBill() {
        return "Foreign{" +
                "fullName='" + fullName + '\'' +
                ", nation='" + nation + '\'' +
                '}';
    }
}


