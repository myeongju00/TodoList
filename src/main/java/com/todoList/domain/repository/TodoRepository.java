package com.todoList.domain.repository;

import com.todoList.domain.entity.TodoEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    @Query("SELECT p FROM TodoEntity p ORDER BY p.id DESC ")
    List<TodoEntity> findAllDesc();
}
