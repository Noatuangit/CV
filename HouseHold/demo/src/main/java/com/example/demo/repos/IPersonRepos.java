package com.example.demo.repos;

import com.example.demo.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IPersonRepos extends JpaRepository<Person, Long> {
    @Modifying
    @Transactional
    @Query(value = "insert people_live_house values(:idHouseHold,:id)", nativeQuery = true)
    void savePersonInHouseHold(@Param("id") Long id, @Param("idHouseHold") String idHouseHold);
}
