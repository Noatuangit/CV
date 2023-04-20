package com.java.service.impl;

import com.java.dto.OrderDTO;
import com.java.model.Order;
import com.java.repos.IOrderRepos;
import com.java.service.IOrderService;
import com.java.service.ITypeCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    IOrderRepos orderRepos;

    @Override
    public Page<Order> findAll(String name, Pageable pageable) {
        return orderRepos.findAllByNameContaining(name, pageable);
    }

    @Override
    public Order save(ITypeCustomerService typeCustomerService, OrderDTO orderDTO) {
        orderDTO.setTotal(
                calculator(typeCustomerService,
                        orderDTO.getTypeId(),
                        orderDTO.getTimeIn(),
                        orderDTO.getPersons(),
                        orderDTO.getChildren(),
                        orderDTO.getDateOrder()));
        return orderRepos.save(new Order(orderDTO));
    }

    @Override
    public Order findById(String id) {

        return orderRepos.findById(id).orElse(null);
    }


    private double calculator(ITypeCustomerService typeCustomerService,
                              String typeCus,
                              String timeIn,
                              Long persons,
                              Long children,
                              String dateIn) {
        assert typeCustomerService.findById(typeCus).isPresent();
        DayOfWeek day = LocalDate.parse(dateIn).getDayOfWeek();
        double total = 0D;
        double discount = typeCustomerService.findById(typeCus).get().getDiscount() / 100d;
        switch (day) {
            case SUNDAY:
            case SATURDAY:
                total = timeIn.compareTo("14:00") < 0 ?
                        persons * 250000D + children * 200000D : persons * 300000D + children * 250000D;
                return total - total * discount;
            default:
                total = timeIn.compareTo("18:00") < 0 ?
                        persons * 200000D + children * 150000D : persons * 250000D + children * 200000D;
                return total - total * discount;
        }
    }
}
