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
    String customer_type;
    String name;
    Date birthday;
    String gender;
    String id_card;
    String phone;
    String email;
    String address;
}
