package com.tuanln6.repos;

import com.tuanln6.model.ServiceDetails;
import com.tuanln6.model.id.ServiceDetailsID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IServiceDetailsRepos extends JpaRepository<ServiceDetails, ServiceDetailsID> {
    @Transactional
    @Modifying
    @Query("delete from ServiceDetails a where a.serviceDetailsID.customer.id = :id ")
    void deleteByCustomerId(@Param("id") String id);

    @Transactional
    @Modifying
    @Query("delete from ServiceDetails a where a.serviceDetailsID.service.id = :id ")
    void removeByServiceId(@Param("id") String id);

    @Query(value = "select cus.id customerId, cus.name customerName,com.id computerId,position,com.status,cd.date_begin dateComputer,cd.time_begin timeComputer,cd.time_use timeUseComputer ,s.name serviceName, sd.date_use dateService,sd.time_begin timeService,sd.amount, sd.amount* s.price total from computer_detail cd full join service_detail sd on sd.customer_id = cd.customer_id left join service s on s.id = sd.service_id left join computer com on com.id = cd.computer_id left join customer cus on cus.id = sd.customer_id or cus.id = cd.customer_id  order by cus.id",
            nativeQuery = true,
            countQuery = "select COUNT(*) from computer_detail cd full join service_detail sd on sd.customer_id = cd.customer_id left join service s on s.id = sd.service_id left join computer com on com.id = cd.computer_id left join customer cus on cus.id = sd.customer_id or cus.id = cd.customer_id ")
    Page<String[]> findAllTotal(Pageable pageable);

    @Query("select s from ServiceDetails s where s.serviceDetailsID.customer.name like concat('%',:condition, '%') or s.serviceDetailsID.service.id like concat('%',:condition, '%')")
    Page<ServiceDetails> findAllByCondition(@Param("condition") String condition, Pageable pageable);
}
