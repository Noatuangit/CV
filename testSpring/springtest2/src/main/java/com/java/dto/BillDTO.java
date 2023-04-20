package com.java.dto;

import com.java.model.Bill;
import com.java.utils.ValidBuilding;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

 import java.time.LocalDate;

public class BillDTO  implements Validator {
    String id;

    String idPlate;

    @ValidBuilding
    String building;

    Long area;

    String name;
     String phone;

    String monthJoin;

    Long numberMonth;

    String dayEnd;

    Double total;

    public BillDTO() {
        this.monthJoin = LocalDate.now().toString();
        this.dayEnd = LocalDate.now().toString();
    }

    public BillDTO(Bill bill) {
        this.id = bill.getId();
        this.area = bill.getArea();
        this.building = bill.getBuilding().getId();
        this.dayEnd = bill.getDayEnd().toString();
        this.monthJoin = bill.getMonthJoin().toString();
        this.numberMonth = bill.getNumberMonth();
        this.phone = bill.getPhone();
        this.name = bill.getName();
        this.idPlate = bill.getIdPlate();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPlate() {
        return idPlate;
    }

    public void setIdPlate(String idPlate) {
        this.idPlate = idPlate;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMonthJoin() {
        return monthJoin;
    }

    public void setMonthJoin(String monthJoin) {
        this.monthJoin = monthJoin;
    }

    public Long getNumberMonth() {
        return numberMonth;
    }

    public void setNumberMonth(Long numberMonth) {
        this.numberMonth = numberMonth;
    }

    public String getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(String dayEnd) {
        this.dayEnd = dayEnd;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BillDTO billDTO = (BillDTO) target;
        if(billDTO.getDayEnd().compareTo(billDTO.getMonthJoin()) < 0){
            errors.rejectValue("dayEnd","dayEnd","day end must bigger day join");
        }
    }
}
