package com.java.model;


import com.java.dto.BillDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "managerBuilding")
public class Bill {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator",
            parameters = @Parameter(name = "prefix", value = "KH"),
            strategy = "com.java.utils.AutoGeneration")
    String id;

    @Column(name = "idPlate")
    String idPlate;

    @ManyToOne
    @JoinColumn(name = "buildingId", nullable = false, referencedColumnName = "id")
    Building building;

    Long area;

    String name;

    String phone;

    @Column(name = "monthJoin")
    Date monthJoin;

    @Column(name = "numberMonth")
    Long numberMonth;

    @Column(name = "dayEnd")
    Date dayEnd;

    Double total;

    public Bill() {
    }

    public Bill(BillDTO billDTO) {
        this.id = billDTO.getId();
        this.idPlate = billDTO.getIdPlate();
        this.building = new Building(billDTO.getBuilding());
        this.area = billDTO.getArea();
        this.name = billDTO.getName();
        this.phone = billDTO.getPhone();
        this.monthJoin = Date.valueOf(billDTO.getMonthJoin());
        this.numberMonth = billDTO.getNumberMonth();
        this.dayEnd = Date.valueOf(billDTO.getDayEnd());
        this.total = billDTO.getTotal();
    }

    public Bill(String id, String idPlate, Building building, Long area, String name, String phone, Date monthJoin, Long numberMonth, Date dayEnd, Double total) {
        this.id = id;
        this.idPlate = idPlate;
        this.building = building;
        this.area = area;
        this.name = name;
        this.phone = phone;
        this.monthJoin = monthJoin;
        this.numberMonth = numberMonth;
        this.dayEnd = dayEnd;
        this.total = total;
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

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
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

    public Date getMonthJoin() {
        return monthJoin;
    }

    public void setMonthJoin(Date monthJoin) {
        this.monthJoin = monthJoin;
    }

    public Long getNumberMonth() {
        return numberMonth;
    }

    public void setNumberMonth(Long numberMonth) {
        this.numberMonth = numberMonth;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
