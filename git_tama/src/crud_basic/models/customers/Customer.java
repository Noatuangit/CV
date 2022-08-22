package crud_basic.models.customers;


public abstract class Customer {
    public String idCustomer;
    public String fullName;

    public static String  getAllProps = "idCustomer,fullName,typeCustomer,electricNorm,nation";

    public Customer(String idCustomer, String fullName) {
        this.idCustomer = idCustomer;
        this.fullName = fullName;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public Customer setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public abstract String getData();

    public abstract String toString();

    public abstract String toStringInBill();
}
