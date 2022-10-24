package com.example.demo.repos.contract;

import com.example.demo.models.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select * from contract where status = 'on' order by id ", nativeQuery = true,
            countQuery = "select count(*) from contract where status = 'on'")
    Page<Contract> findAllByName(@Param("name") String name_search, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update Contract c set c.status = 'off' where c.id = :id_delete")
    void updateById(@Param("id_delete") Integer id_delete);

    @Modifying
    @Transactional
    @Query(value = "update contract set total_money = total_money_service(:id) where id = :id", nativeQuery = true)
    void updateMoneyById(@Param("id") Integer id);
}
