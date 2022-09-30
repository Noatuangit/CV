package com.example.demo.dto;

import com.example.demo.annotation_custom.ValidDayBirthBigger18;
import com.example.demo.models.employee.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    Integer id;

    @NotBlank(message = "name should be something")
    String name;

    @NotBlank(message = "birthday should be something")
    @ValidDayBirthBigger18
    String birthday;

    @NotBlank(message = "id_card should be something")
    @Pattern(regexp = "^\\d{9}$", message = "id card should be correct type 9 number")
    String id_card;

    @Min(0)
    Double salary;


    @NotBlank(message = "email should be something")
    @Pattern(regexp = "^(0|84|\\+84)\\d{9}$", message = "phone should be correct type in Viet Nam (0xxxxxxxxx or +84xxxxxxxx or 84xxxxxxxx)")
    String phone;

    @NotBlank(message = "email should be something")
    @Email(message = "email should be input correct type")
    String email;

    @NotBlank(message = "address should be something")
    String address;

    Integer position;
    Integer educationDegree;
    Integer division;

    public EmployeeDTO(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.birthday = employee.getBirthday().toString();
        this.id_card = employee.getId_card();
        this.salary = employee.getSalary();
        this.phone = employee.getPhone();
        this.email = employee.getEmail();
        this.address = employee.getAddress();
        this.position = employee.getPosition().getId();
        this.educationDegree = employee.getEducationDegree().getId();
        this.division = employee.getDivision().getId();
    }
}
