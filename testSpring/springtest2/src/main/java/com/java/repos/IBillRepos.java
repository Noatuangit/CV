package com.java.repos;

import com.java.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBillRepos extends JpaRepository<Bill, String> {
    @Query("from Bill b where b.name like concat('%',:name,'%') and  b.building.id like concat('%',:id,'%') ")
    List<Bill> findAllByNameAndBuildId(@Param("name") String name, @Param("id") String id);
}
