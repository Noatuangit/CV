package com.tuanln6.dto.computer;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ComputerDTO {
    String id;
    @NotBlank
    @Size(max = 200, message = " not bigger 200 digits.")
    String position;

    @NotBlank
    @Pattern(regexp = "^on|off|pending|waiting$", message = " not correct option.")
    String status;

    public ComputerDTO() {
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
