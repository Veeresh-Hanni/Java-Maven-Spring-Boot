package com.todoapp.service;

import com.todoapp.entity.Todo;
import com.todoapp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    public void markAsComplete(String id) {
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            Todo updatedTodo = todo.get();
            updatedTodo.setCompleted(true);
            todoRepository.save(updatedTodo);
        }
    }

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(String id) {
        return todoRepository.findById(id);
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo updateTodo(String id, Todo todo) {
        todo.setId(id);
        return todoRepository.save(todo);
    }

    public void deleteTodo(String id) {
        todoRepository.deleteById(id);
    }
}
