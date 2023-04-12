package com.tuanln6.repos;

import com.tuanln6.model.AddOnService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IServiceRepos extends JpaRepository<AddOnService, String> {
    @Query("select c from AddOnService c where c.status = :status and (c.name like concat('%',:name,'%') or c.unit like concat('%',:unit,'%') )")
    Page<AddOnService> findAllByStatusAndNameContainingOrUnitContaining(
            @Param("status") String status,
            @Param("name") String name,
            @Param("unit") String unit,
            Pageable pageable);

    @Modifying
    @Transactional
    @Query("update AddOnService s set s.status = 'off' where s.id = :id")
    Integer updateStatusById(@Param("id") String id);

    List<AddOnService> findAllByStatusNot(String status);
}
