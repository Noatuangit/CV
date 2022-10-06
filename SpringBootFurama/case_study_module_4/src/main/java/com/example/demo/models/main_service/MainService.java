package com.example.demo.models.main_service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.dto.MainServiceDTO;
import com.example.demo.models.employee.Division;
import com.example.demo.models.employee.EducationDegree;
import com.example.demo.models.employee.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "service")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Integer area;

    Double service_cost;

    Integer max_people;

    String standard_room;

    String description_other_convenience;

    Double pool_area;

    Integer number_of_floors;

    String facility_text;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    ServiceType serviceType;

    String status;

    public MainService(MainServiceDTO mainServiceDTO) {
        RentType rentType = new RentType();
        rentType.setId(mainServiceDTO.getRentType());
        ServiceType serviceType = new ServiceType();
        serviceType.setId(mainServiceDTO.getServiceType());
        this.id = null;
        this.name = mainServiceDTO.getName();
        this.area = mainServiceDTO.getArea();
        this.service_cost = mainServiceDTO.getService_cost();
        this.max_people = mainServiceDTO.getMax_people();
        this.standard_room = mainServiceDTO.getStandard_room();
        this.description_other_convenience = mainServiceDTO.getDescription_other_convenience();
        this.pool_area = mainServiceDTO.getPool_area();
        this.number_of_floors = mainServiceDTO.getNumber_of_floors();
        this.facility_text = mainServiceDTO.getFacility_text();
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.status = "on";
    }
}
