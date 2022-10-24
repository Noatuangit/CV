package com.example.demo.models.contract;

import com.example.demo.dto.ContractDTO;
import com.example.demo.models.customer.Customer;
import com.example.demo.models.employee.Employee;
import com.example.demo.models.main_service.MainService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "contract")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "start_date")
    Date start_date;

    @Column(name = "end_date")
    Date end_date;

    @Column(name = "deposit")
    Double deposit;

    @Column(name = "total_money")
    Double total_money;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false, referencedColumnName = "id")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false, referencedColumnName = "id")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    Employee employee;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false, referencedColumnName = "id")
    @Cascade(value = {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    MainService mainService;

    @OneToMany(mappedBy = "contract")
    private Set<ContractDetails> contractDetailSet;

    @Column(name = "status")
    String status;

    public Contract(ContractDTO contractDTO) {
        Customer customerTemp = new Customer();
        Employee employeeTemp = new Employee();
        MainService mainServiceTemp = new MainService();
        customerTemp.setId(Integer.parseInt(contractDTO.getCustomer()));
        employeeTemp.setId(Integer.parseInt(contractDTO.getEmployee()));
        mainServiceTemp.setId(Integer.parseInt(contractDTO.getMainService()));

        this.start_date = contractDTO.getStart_date();
        this.end_date = contractDTO.getEnd_date();
        this.deposit = contractDTO.getDeposit();
        this.total_money = contractDTO.getTotal_money();
        this.customer = customerTemp;
        this.employee = employeeTemp;
        this.mainService = mainServiceTemp;
        this.status = "on";
    }

    public Contract(String idContract) {
        this.id = Integer.parseInt(idContract);
    }
}
