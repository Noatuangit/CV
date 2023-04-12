package com.tuanln6.dto.service;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ServiceDTO {
    String id;

    @NotBlank
    @Pattern(regexp = "^([A-Z]([a-z]+) *)+$", message = " not correct type.")
    String name;

    @NotNull
    @NotBlank
    String unit;

//    @Pattern(regexp = "^[1-9][0-9]*$", message = " bigger zero")
    @NotNull
    @Min(1)
    Long price;

    public ServiceDTO() {
    }

    public ServiceDTO(String id, String name, String unit, Long price) {
        this.id = id;
        this.name = name;
        this.unit = unit;
        this.price = price;
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
