package org.jobhacker.springboot.app.service;

import org.jobhacker.springboot.app.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {

    Todo createTodo(Todo todo);
    List<Todo> getAllTodos();
    Todo getTodo(int id);
    Todo editTodo(Todo todo, int id);
    void deleteTodo(int id);
}
