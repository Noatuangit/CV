package models.person;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    int id;
    String name;
    Date birthday;
    String id_card;
    double salary;
    String phone;
    String email;
    String address;
    String positions;
    String education_degree;
    String division;
}
