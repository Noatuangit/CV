package com.example.demo.models.employee.roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_account")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeAccount {
    @Id
    String username;

    String password;

    @ManyToMany
    @JoinTable(name = "user_role_author", joinColumns = @JoinColumn(name = "username"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<EmployeeRoles> list;

}
