package com.tuanln6.repos;

import com.tuanln6.model.ComputerDetails;
import com.tuanln6.model.id.ComputerDetailsID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IComputerDetailsRepos extends JpaRepository<ComputerDetails, ComputerDetailsID> {
    @Query("from ComputerDetails c where c.computerDetailsID.customer.name like concat('%',:condition,'%') or c.computerDetailsID.computer.id like concat('%',:condition,'%') ")
    Page<ComputerDetails> findAllByCustomerNameOrIdComputer(@Param("condition") String condition, Pageable pageable);

    @Transactional
    @Modifying
    @Query("delete from ComputerDetails c where c.computerDetailsID.customer.id = :id")
    void deleteByCustomerId(@Param("id") String id);

    @Transactional
    @Modifying
    @Query("delete from ComputerDetails c where c.computerDetailsID.computer.id = :id")
    void deleteByComputerId(@Param("id") String id);
}
