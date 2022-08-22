package models.professional_furama;

import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contract {
    int id;
    Timestamp start_day;
    Timestamp end_day;
    double deposit;
    String employee_id;
    String customer_id;
    String service_id;
    double total_money;
}
