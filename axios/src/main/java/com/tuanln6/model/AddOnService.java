package com.tuanln6.model;

import com.tuanln6.dto.service.ServiceDTO;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service")
public class AddOnService {
    @Id
    @GeneratedValue(generator = "auto-generator")
    @GenericGenerator(name = "auto-generator", parameters = @Parameter(name = "prefix", value = "SV"), strategy = "com.tuanln6.utils.AutoGeneration")
    String id;
    String name;
    String unit;
    Long price;
    String status;

    public AddOnService() {
    }

    public AddOnService(String id) {
        this.id = id;
    }

    public AddOnService(String id, String name, String unit, Long price, String status) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
        this.status = status;
    }

    public AddOnService(ServiceDTO serviceDTO) {
        this.id = serviceDTO.getId();
        this.name = serviceDTO.getName();
        this.price = (serviceDTO.getPrice());
        this.status = "on";
        this.unit = serviceDTO.getUnit();
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
}
