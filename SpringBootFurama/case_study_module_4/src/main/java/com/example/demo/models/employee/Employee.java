package com.example.demo.models.employee;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.models.customer.CustomerType;
import com.example.demo.models.employee.roles.EmployeeAccount;
import javafx.geometry.Pos;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "birthday")
    Date birthday;

    @Column(name = "id_card")
    String id_card;

    @Column(name = "salary")
    Double salary;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "address")
    String address;

    @ManyToOne
    @JoinColumn(name = "position_id")
    Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id")
    EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id")
    Division division;

    @ManyToOne
    @JoinColumn(name = "username")
    EmployeeAccount employeeAccount;

    @Column(name = "status")
    String status;

    public Employee(EmployeeDTO employeeDTO) {
        Division division = new Division();
        division.setId(employeeDTO.getDivision());
        EducationDegree educationDegree = new EducationDegree();
        educationDegree.setId(employeeDTO.getEducationDegree());
        Position position = new Position();
        position.setId(employeeDTO.getPosition());
        this.id = null;
        this.name = employeeDTO.getName();
        this.birthday = Date.valueOf(employeeDTO.getBirthday());
        this.id_card = employeeDTO.getId_card();
        this.salary = employeeDTO.getSalary();
        this.phone = employeeDTO.getPhone();
        this.email = employeeDTO.getEmail();
        this.address = employeeDTO.getAddress();
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.status = "on";
    }

}
