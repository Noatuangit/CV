package com.example.demo.dto;

import com.example.demo.models.customer.Customer;
import com.example.demo.annotation_custom.ValidDayBirthBigger18;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {
    Integer id;

    Integer customerType;

    @NotBlank(message = "name should be something")
    String name;

    @NotBlank(message = "birthday should be something")
    @ValidDayBirthBigger18
    String birthday;

    @NotBlank(message = "id_card should be something")
    @Pattern(regexp = "^\\d{9}$",message = "id card should be correct type 9 number")
    String id_card;

    Integer gender;

    @NotBlank(message = "email should be something")
    @Pattern(regexp = "^(0|84|\\+84)\\d{9}$",message = "phone should be correct type in Viet Nam (0xxxxxxxxx or +84xxxxxxxx or 84xxxxxxxx)")
    String phone;

    @NotBlank(message = "email should be something")
    @Email(message = "email should be input correct type")
    String email;

    @NotBlank(message = "address should be something")
    String address;

    public CustomerDTO(Customer target) {
        this.id = target.getId();
        this.name = target.getName();
        this.customerType = target.getCustomerType().getId();
        this.birthday = target.getBirthday().toString();
        this.id_card = target.getId_card();
        this.gender = target.getGender() ? 1 : 0;
        this.phone = target.getPhone();
        this.email = target.getEmail();
        this.address = target.getAddress();
    }

}
