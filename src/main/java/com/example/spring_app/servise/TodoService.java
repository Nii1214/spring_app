package com.example.spring_app.servise;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_app.entity.Todo;
import com.example.spring_app.repository.TodoRepository;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    //コンストラクタ
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //新規タスクの登録メソッド
    public void createTodo(String title, String priority, String status) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setPriority(Todo.Priority.valueOf(priority));
        todo.setStatus(Todo.Status.valueOf(status));
        todoRepository.save(todo);
    }

    //タスクの一覧取得メソッド
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}
