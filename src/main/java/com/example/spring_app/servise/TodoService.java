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

    // 未完了のTodoを取得
    public List<Todo> getIncompleteTodos() {
        return todoRepository.findByStatusNot(Todo.Status.完了);
    }

    // 完了済みのTodoを取得
    public List<Todo> getCompleteTodos() {
        return todoRepository.findByStatus(Todo.Status.完了);
    }

    // Todoのステータスを更新
    public void updateTodoStatus(Integer id, boolean completed) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setStatus(completed ? Todo.Status.完了 : Todo.Status.未着手);
        todoRepository.save(todo);
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

    // タスクの削除メソッド
    public void deleteTodo(Integer id) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Todo not found"));
        todoRepository.delete(todo);
    }

    // タスクのタイトル更新メソッド
    public void updateTodoTitle(Integer id, String title) {
        Todo todo = todoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(title);
        todoRepository.save(todo);
    }
}
