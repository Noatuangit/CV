package com.example.demo.DTO;

import com.example.demo.models.HouseHold;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HouseHoldDTO {
    String id;

    String name;

    Date dateCreate;

    String address;
    
    Integer numberPeople;

    public HouseHoldDTO(HouseHold houseHold) {
        this.id = houseHold.getId();
        this.name = houseHold.getName();
        this.dateCreate = houseHold.getDateCreate();
        this.address = houseHold.getAddress();
        this.numberPeople = houseHold.getPersonSet().size();
    }
}
