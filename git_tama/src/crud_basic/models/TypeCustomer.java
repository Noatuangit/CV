package crud_basic.models;

public class TypeCustomer {
    public static String getAllProps = "Type ID, Full Name Service";

    public String typeId;
    public String fullName;

    public TypeCustomer(String typeId, String fullName) {
        this.typeId = typeId;
        this.fullName = fullName;
    }
    public String getData() {
        return String.format("%s,%s", typeId, fullName);
    }

    @Override
    public String toString() {
        return "TypeCustomer{" +
                "typeId='" + typeId + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
