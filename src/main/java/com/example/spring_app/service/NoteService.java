package com.example.spring_app.service;

import com.example.spring_app.entity.Note;
import com.example.spring_app.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    public List<Note> findAllByUserId(Long userId) {
        return noteRepository.findByUserId(userId);
    }

    public Optional<Note> findByIdAndUserId(Long id, Long userId) {
        return Optional.ofNullable(noteRepository.findByIdAndUserId(id, userId));
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public void deleteByIdAndUserId(Long id, Long userId) {
        Note note = noteRepository.findByIdAndUserId(id, userId);
        if (note != null) {
            noteRepository.delete(note);
        }
    }
} 