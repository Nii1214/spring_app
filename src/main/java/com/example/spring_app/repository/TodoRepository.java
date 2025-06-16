package com.example.spring_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_app.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
    
}
