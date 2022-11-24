package com.example.demo.repos;

import com.example.demo.models.HouseHold;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface IHouseHoldRepos extends JpaRepository<HouseHold, String> {
//    select * from household  where  name like concat('%','','%') and  address like concat('%','','%') and  date_create like concat('%','','%')
    @Query(value = "select * from household where  name like concat('%',:name,'%') and  address like concat('%',:address,'%') and  date_create like concat('%',:date,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from (select * from household where name like concat('%',:name,'%') and date_create like concat('%',:date,'%') and  address like concat('%',:address,'%')) household ")
    Page<HouseHold> findAll(@Param("name") String name, @Param("address") String address, @Param("date") String date_search, Pageable pageable);
}
