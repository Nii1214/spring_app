package com.example.spring_app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_app.entity.Todo;
import com.example.spring_app.entity.Todo.Status;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByStatus(Status status);
    List<Todo> findByStatusNot(Status status);
}
