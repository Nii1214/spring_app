package com.example.spring_app.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.spring_app.entity.Todo;
import com.example.spring_app.servise.TodoService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {
    private final TodoService todoService;

    public TodoApiController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAllTodos());
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<Todo>> getIncompleteTodos() {
        return ResponseEntity.ok(todoService.getIncompleteTodos());
    }

    @GetMapping("/complete")
    public ResponseEntity<List<Todo>> getCompleteTodos() {
        return ResponseEntity.ok(todoService.getCompleteTodos());
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Map<String, String> todoData) {
        String title = todoData.get("title");
        String priority = todoData.get("priority");
        String status = todoData.get("status");
        
        todoService.createTodo(title, priority, status);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateTodoStatus(
            @PathVariable Integer id,
            @RequestBody boolean completed) {
        todoService.updateTodoStatus(id, completed);
        return ResponseEntity.ok().build();
    }
} 