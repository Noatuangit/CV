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
    int positions;
    int education_degree;
    int division;

    public Employee(String name, Date birthday, String id_card, double salary, String phone, String email, String address, int positions, int education_degree, int division) {
        this.name = name;
        this.birthday = birthday;
        this.id_card = id_card;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positions = positions;
        this.education_degree = education_degree;
        this.division = division;
    }
}
