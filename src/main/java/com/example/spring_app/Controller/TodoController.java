package com.example.spring_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import java.util.List;

import com.example.spring_app.entity.Todo;
import com.example.spring_app.service.TodoService;

@Controller
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public String todo(Model model) {
        List<Todo> incompleteTodos = todoService.getIncompleteTodos();
        List<Todo> completeTodos = todoService.getCompleteTodos();
        model.addAttribute("incompleteTodos", incompleteTodos);
        model.addAttribute("completeTodos", completeTodos);
        return "pages/todo/list";
    }
}
