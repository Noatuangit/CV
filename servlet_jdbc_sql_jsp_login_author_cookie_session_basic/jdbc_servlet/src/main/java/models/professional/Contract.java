package models.professional;

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
    int employee_id;
    int customer_id;
    int service_id;
    double total_money;

    public Contract(Timestamp start_day, Timestamp end_day, double deposit, int employee_id, int customer_id, int service_id) {
        this.start_day = start_day;
        this.end_day = end_day;
        this.deposit = deposit;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
        this.service_id = service_id;
    }
}
