package com.example.spring_app.controller.api;

import com.example.spring_app.entity.Note;
import com.example.spring_app.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteApiController {
    @Autowired
    private NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes(@RequestParam Long userId) {
        return noteService.findAllByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id, @RequestParam Long userId) {
        return noteService.findByIdAndUserId(id, userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return noteService.save(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestParam Long userId, @RequestBody Note note) {
        return noteService.findByIdAndUserId(id, userId)
                .map(existingNote -> {
                    note.setId(id);
                    note.setUserId(userId);
                    return ResponseEntity.ok(noteService.save(note));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id, @RequestParam Long userId) {
        return noteService.findByIdAndUserId(id, userId)
                .map(note -> {
                    noteService.deleteByIdAndUserId(id, userId);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
} 