package com.java.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;

public class ServiceDTO {
    String id;

    @NotBlank
    String name;

    @NotBlank
    String unit;

    @Min(1)
    Long price;

    public ServiceDTO() {
        super();
    }

    public ServiceDTO(String id, String name, String unit, Long price) {
        super();
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ServiceDTO [id=" + id + ", name=" + name + ", unit=" + unit + ", price=" + price + "]";
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


}
