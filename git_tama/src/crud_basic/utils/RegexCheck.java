package crud_basic.utils;

public class RegexCheck {
    public static boolean isNotCorrectIdCustomerDomestic(String str) {
        String FORMAT_ID_CUSTOMER = "^[Kk][hH][Vv][Nn]-\\d{4}$";
        return !str.matches(FORMAT_ID_CUSTOMER);
    }

    public static boolean isNotCorrectIdCustomerForeign(String str) {
        String FORMAT_ID_CUSTOMER = "^[Kk][hH][Nn]{2}-\\d{4}$";
        return !str.matches(FORMAT_ID_CUSTOMER);
    }
    public static boolean isNotCorrectIdBill(String str){
        String FORMAT_ID_BILL= "^MHD-\\d{3}$";
        return !str.toUpperCase().matches(FORMAT_ID_BILL);
    }
}
