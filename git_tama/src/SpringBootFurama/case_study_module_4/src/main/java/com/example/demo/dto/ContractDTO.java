package com.example.demo.dto;

import com.example.demo.models.contract.Contract;
import com.example.demo.utils.ConverterSetToStringHtml;
import lombok.*;

import javax.validation.constraints.Min;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractDTO {

    Integer id;


    Date start_date;

    Date end_date;

    @Min(0)
    Double deposit;

    Double total_money;

    String customer;

    String employee;

    String mainService;

    String listContractDetails;

    public ContractDTO(Contract contract) {
        id = contract.getId();
        start_date = contract.getStart_date();
        end_date = contract.getEnd_date();
        deposit = contract.getDeposit();
        total_money = contract.getTotal_money();
        employee = contract.getEmployee().getName();
        customer = contract.getCustomer().getName();
        mainService = contract.getMainService().getName();
        listContractDetails = ConverterSetToStringHtml.converterTable(contract.getContractDetailSet());
    }
}