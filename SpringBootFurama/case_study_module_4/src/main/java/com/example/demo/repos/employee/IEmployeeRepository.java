package com.example.demo.repos.employee;

import com.example.demo.models.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from employee where status = 'on' and name like concat('%',:name,'%')",
            nativeQuery = true,
            countQuery = "select count(*) from (select * from employee where name like concat('%',:name,'%') and status = 'on') employee")
    Page<Employee> findAllByName(@Param("name") String name_search, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update Employee e set e.status = 'off' where e.id = :id_delete")
    void updateById(@Param("id_delete") Integer id_delete);

    @Query("select e from Employee e where e.employeeAccount.username = ?1")
    Optional<Employee> findAllByUsername(String username);
}
