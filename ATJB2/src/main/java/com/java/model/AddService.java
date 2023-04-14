package com.java.model;

import com.java.dto.ServiceDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class AddService {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator", parameters = @Parameter(name = "prefix", value = "SV"), strategy = "com.java.utils.AutoGeneration")
    String id;

    String name;

    String unit;

    Long price;

    String status;

    public AddService() {
    }

    public AddService(String id) {
        this.id = id;
    }

    public AddService(ServiceDTO serviceDto) {
        this.id = serviceDto.getId();
        this.name = serviceDto.getName();
        this.price = serviceDto.getPrice();
        this.unit = serviceDto.getUnit();
        this.status = "on";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AddService{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}
