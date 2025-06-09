package com.example.spring_app.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.spring_app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByUserName(String userName);
}
