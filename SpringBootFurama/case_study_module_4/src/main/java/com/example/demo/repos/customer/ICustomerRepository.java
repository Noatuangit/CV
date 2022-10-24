package com.example.demo.repos.customer;

import com.example.demo.models.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    @Query(value = "select * from customer where status = 'on' and name like concat('%',:name,'%')",
    nativeQuery = true,
    countQuery = "select count(*) from (select * from customer where name like concat('%',:name,'%') and status = 'on') customer")
    Page<Customer> findAllByName(@Param("name") String name_search, Pageable pageable);

    @Query(value = "select c from Customer c where c.status = 'on'")
    List<Customer> findAll();

    @Modifying
    @Transactional
    @Query(value = "update Customer c set c.status = 'off' where c.id = :id_delete")
    void updateById(@Param("id_delete") Integer id_delete);

}
