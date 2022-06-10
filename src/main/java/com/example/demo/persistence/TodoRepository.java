package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, String> {
    // SELECT * FROM TodoRepository WHERE userId = {userId}
    // List<TodoEntity> findByUserId(String userId);

    @Query("select * from Todo t where t.userId = ?1")
    List<TodoEntity> findByUserId(String userId);



}
