package models.professional;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainService {
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
    int rent_type;
    int service_type;

    public MainService(String name, int area, double cost, int max_people, String standard_room, String description_other_convenience, double pool_area, int number_of_floors, String facility_text, int rent_type, int service_type) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.number_of_floors = number_of_floors;
        this.facility_text = facility_text;
        this.rent_type = rent_type;
        this.service_type = service_type;
    }
}
