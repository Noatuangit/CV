package com.tuanln6.dto.customer;

import com.tuanln6.utils.EmailExists;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class CustomerDTO {

    @NotBlank
    String name;

    @NotBlank
    @Pattern(regexp = "^((\\(84\\)\\+)|0)9[1|0][0-9]{7}$",
    message = " must something and correct type!")
    String phone;

    @NotBlank
    @EmailExists
    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email not correct type.")
    String email;

    @NotBlank
    String address;

    public CustomerDTO() {
    }

    public CustomerDTO(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
