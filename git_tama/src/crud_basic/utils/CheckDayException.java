package crud_basic.utils;

public class CheckDayException extends Exception{
    public CheckDayException(String errorLine){
        super(errorLine);
    }

    public static boolean isNotCorrectDay(String dateStr){
        String FORMAT_DAY = "^(([0-2]\\d|)|(3)[0-1])([/\\-.])(((0)[1-9])|((1)[0-2]))([/\\-.])(((19)[3-9]\\d)|((20)\\d{2}))$";
//        return !Pattern.matches(FORMAT_DAY, dateStr);
        return !dateStr.matches(FORMAT_DAY);
    }

    public static void checkCorrectDay(String dateStr) throws CheckDayException {
        if (isNotCorrectDay(dateStr)) throw new CheckDayException("Not Correct type day dd-mm-yyyy");
    }
}
