package com.tuanln6.repos;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tuanln6.model.Customer;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepos extends JpaRepository<Customer, String> {
    @Query("select c from Customer c where c.status = :status and (c.name like concat('%',:name,'%') or c.address like concat('%',:address,'%') or c.email like concat('%',:email,'%')) order by c.name")
    Page<Customer> findAllByStatusAndNameContainingOrAddressContainingOrEmailContainingOrderByName(@Param("status") String status, @Param("name") String name, @Param("address") String address, @Param("email") String email, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Customer c set c.status = 'off' where  c.id = :id")
    Integer updateStatusById(@Param("id") String id);

    List<Customer> findAllByStatus(String status);

    Optional<Customer> findByEmail(String value);
}
