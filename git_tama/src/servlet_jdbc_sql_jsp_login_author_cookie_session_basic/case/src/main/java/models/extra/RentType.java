package models.extra;

import lombok.*;

@AllArgsConstructor@Setter@Getter@NoArgsConstructor@Builder
public class RentType {
    int id;
    String name;
    double rent_type_cost;
}
