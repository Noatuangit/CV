package com.tuanln6.repos;

import com.tuanln6.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
 import java.util.List;

public interface IComputerRepos extends JpaRepository<Computer, String> {
    Page<Computer> findAllByPositionContainingOrderByPosition(String condition, Pageable pageable);

    @Modifying
    @Transactional
    @Query("update Computer c set c.status = :status where c.id = :id")
    Integer updateStatusById(@Param("id") String id, @Param("status")String status);

    List<Computer> findAllByStatusNotIn(List<String> status);

    List<Computer> findAllByStatusNotInOrId(List<String> status,String id);
}
