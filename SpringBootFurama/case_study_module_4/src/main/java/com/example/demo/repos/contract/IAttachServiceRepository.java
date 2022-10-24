package com.example.demo.repos.contract;

import com.example.demo.models.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {

    @Query("select c from AttachService c where c.id = :id")
    Optional<AttachService> findById(@Param("id") Integer id);

}
