package com.example.spring_app.repository;

import com.example.spring_app.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByUserId(Long userId);
    Note findByIdAndUserId(Long id, Long userId);
} 