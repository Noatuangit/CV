package com.java.service.impl;

import com.java.dto.BillDTO;
import com.java.model.Bill;
import com.java.repos.IBillRepos;
import com.java.service.IBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillServiceImpl implements IBillService {
    @Autowired
    IBillRepos billRepos;

    @Override
    public List<Bill> findAll(String name, String idBuilding) {
        return billRepos.findAllByNameAndBuildId(name, idBuilding);
    }

    @Override
    public void save(BillDTO billDTO) {
        billDTO.setTotal(calculatorTotal(billDTO));
        billRepos.save(new Bill(billDTO));
    }

    @Override
    public Bill findById(String id) {
        return billRepos.findById(id).orElse(null);
    }

    private double calculatorTotal(BillDTO billDTO) {
        double moneyPerMonth = 11000;
        double fine = 10000;
        double discountPercent = 0.1;
//         long monthDifference = ChronoUnit.MONTHS.between(LocalDate.parse(billDTO.getDayEnd()), LocalDate.parse(billDTO.getMonthJoin()));
        long monthDifference = LocalDate.parse(billDTO.getDayEnd()).getMonthValue() - LocalDate.parse(billDTO.getMonthJoin()).getMonthValue();
        if (monthDifference > 0) {
            return moneyPerMonth * billDTO.getNumberMonth() * billDTO.getArea() + (monthDifference * fine);
        }
        return billDTO.getNumberMonth() < 3 ?
                moneyPerMonth * billDTO.getNumberMonth() * billDTO.getArea() :
                moneyPerMonth * 3 * billDTO.getArea() + (billDTO.getNumberMonth() - 3) * moneyPerMonth * billDTO.getArea() * discountPercent;
    }
}
