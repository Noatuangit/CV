package com.example.demo.DAO;

import com.example.demo.valid.NameNotDuplicate;
import com.example.demo.valid.ValidDifferenceDay;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
//@ValidDifferenceDay(
//        field = "start_date",
//        fieldMatch = "end_date"
//)
public class HouseHoldDAO {
    String id;

    @NotBlank(message = "Name should be something! input please!!!")
    @NameNotDuplicate
    String name;

    @PastOrPresent(message = "Day create must be a date in the present or in the past !!!")
    @NotNull(message = "Input something in date create !!!")
    Date dateCreate;

    @NotBlank(message = "Address so important! input please!")
    String address;
}
