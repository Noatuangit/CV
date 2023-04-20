package com.java.utils;

import com.java.model.Order;
import com.java.service.IOrderService;

public class CustomValid {
    public static boolean checkNumberTicket(IOrderService service, String idOrder, Long persons, Long children) {
        Order order = service.findById(idOrder);
        return (persons + children) < (order.getChildren() + order.getPersons());
    }
}
