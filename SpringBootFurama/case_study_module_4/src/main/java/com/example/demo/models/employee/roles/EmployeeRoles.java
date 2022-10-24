package com.example.demo.models.employee.roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_roles")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    @ManyToMany(mappedBy = "list")
    List<EmployeeAccount> list;
}
