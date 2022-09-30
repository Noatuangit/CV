package com.example.demo.service.interface_business;

import com.example.demo.models.contract.Contract;
import com.example.demo.models.main_service.MainService;
import com.example.demo.service.IBaseService;

public interface IMainService extends IBaseService<MainService> {
//    @Query(value = "insert into contract ('start_date','start_date','deposit','total_money','employee_id','customer_id','service_id') values " +
//            "(:statdate,:enddate,:deposit,getMoneyCreateContract(:serid,:deposit),:employee_id,:customer_id,:serid)", nativeQuery = true)
//    void save(Contract contract);
}
