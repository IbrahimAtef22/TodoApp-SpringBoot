package org.jobhacker.springboot.app.service;

import org.jobhacker.springboot.app.entity.Todo;
import org.jobhacker.springboot.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    @Autowired
    private TodoRepository repo;

    // create new todo
    public Todo createTodo(Todo todo) {
        return repo.save(todo);
    }

    // return all todos
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    // return specific todo by id
    public Todo getTodo(int id) {
        return repo.findById(id).orElse(null);
    }

    // return updated todo
    public Todo editTodo(Todo todo, int id) {
        Todo oldTodo = repo.findById(id).orElse(null);

        oldTodo.setId(todo.getId());
        oldTodo.setTitle(todo.getTitle());
        oldTodo.setDescription(todo.getDescription());
        oldTodo.setTimestamp(todo.getTimestamp());

        repo.save(oldTodo);
        return oldTodo;
    }

    // delete todo by id
    public void deleteTodo(int id){
        repo.deleteById(id);
    }


}
