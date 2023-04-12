package com.tuanln6.utils;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateConverter {
    public static String converterDateToString(Date date) {
        String[] dateArray = date.toString().split("-");
        return String.format("%s-%s-%s", dateArray[2], dateArray[1], dateArray[0]);
    }

    public static Date converterStringToDate(String date){
         String[] dateArray = date.split("-");
        return Date.valueOf(String.format("%s-%s-%s", dateArray[2], dateArray[1], dateArray[0]));
    }

    public static String converterSecondToString(String second){

        // Chuyển đổi sang kiểu dữ liệu Instant
        Instant instant = Instant.ofEpochMilli(Long.parseLong(second));

        // Chuyển đổi sang kiểu dữ liệu LocalDate
        LocalDateTime localDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

        // Định dạng LocalDate sang chuỗi theo định dạng dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }
}
