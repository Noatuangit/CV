package com.example.demo.dto;

import com.example.demo.models.main_service.MainService;
import com.example.demo.models.main_service.RentType;
import com.example.demo.models.main_service.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MainServiceDTO {
    Integer id;

    @NotBlank(message = "name should be something")
    String name;

    @Min(1000)
    Integer area;

    @Min(100000)
    Double service_cost;

    @Min(1)
    @Max(20)
    Integer max_people;

    @NotBlank(message = "standard room should be something")
    String standard_room;

    String description_other_convenience;

    Double pool_area;

    Integer number_of_floors;

    String facility_text;

    Integer rentType;

    Integer serviceType;

    public MainServiceDTO(MainService service) {
        this.id = service.getId();
        this.name = service.getName();
        this.area = service.getArea();
        this.service_cost = service.getService_cost();
        this.max_people = service.getMax_people();
        this.standard_room = service.getStandard_room();
        this.description_other_convenience = service.getDescription_other_convenience();
        this.pool_area = service.getPool_area();
        this.number_of_floors = service.getNumber_of_floors();
        this.facility_text = service.getFacility_text();
        this.rentType = service.getRentType().getId();
        this.serviceType = service.getServiceType().getId();
    }

}
