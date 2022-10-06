package com.example.demo.models.contract;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "attach_service")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    Double attach_service_cost;

    String attach_service_unit;

    String attach_service_status;

    public AttachService(String id){
        this.id = Integer.parseInt(id);
    }
}
