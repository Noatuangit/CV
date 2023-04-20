package com.java.utils;

import com.java.model.Bill;
import com.java.service.IBillService;

public class CustomValid {
    public static boolean  validMonth(IBillService billService, String idBill, Long newMonth) {
        Bill bill = billService.findById(idBill);
        return bill.getNumberMonth() > newMonth;
    }
}
