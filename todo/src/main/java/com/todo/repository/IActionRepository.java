package com.todo.repository;

import com.todo.models.Action;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActionRepository extends JpaRepository<Action,Long> {
}
