package com.example.demo.models.contract;

import com.example.demo.dto.ContractDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "contract_details")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContractDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "contract_id")
    Contract contract;

    @ManyToOne
    @JoinColumn(name = "attach_service_id")
    AttachService attachService;

    Double quantity;

}
