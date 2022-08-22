package models.professional_furama;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service {
    int id;
    String name;
    int area;
    double cost;
    int max_people;
    String standard_room;
    String description_other_convenience;
    double pool_area;
    int number_of_floors;
    String facility_text;
    String rent_type;
    String service_type;
}
