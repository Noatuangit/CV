package models.person;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    int id;
    int customer_type;
    String name;
    Date birthday;
    int gender;
    String id_card;
    String phone;
    String email;
    String address;

    public Customer(int customer_type, String name, Date birthday, int gender, String id_card, String phone, String email, String address) {
        this.customer_type = customer_type;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.id_card = id_card;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }
}
