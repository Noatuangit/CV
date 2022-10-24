package com.example.demo.repos.main_service;

import com.example.demo.models.main_service.MainService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IMainServiceRepository extends JpaRepository<MainService, Integer> {
    @Query(value = "select * from service where status = 'on' and name like concat('%',:name,'%')",nativeQuery = true,
            countQuery = "select count(*) from (select * from service where name like concat('%',:name,'%') and status = 'on') service")
    Page<MainService> findAllByName(@Param("name") String name_search, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update MainService e set e.status = 'off' where e.id = :id_delete")
    void updateById(@Param("id_delete") Integer id_delete);
}
