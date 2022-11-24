package com.example.demo.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDAO {
    @Pattern(regexp = "^[\\d]{7}$",message = "cmnd must 7 number random")
    String cmnd;

    @NotBlank(message = "name should be something! input please!")
    String name;

    @NotNull
    @PastOrPresent(message = "Birthday must be a date in the present or in the past")
    Date birthday;
}

