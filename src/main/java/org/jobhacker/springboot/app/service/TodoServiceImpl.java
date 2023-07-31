package org.jobhacker.springboot.app.service;

import org.jobhacker.springboot.app.entity.Todo;
import org.jobhacker.springboot.app.exception.TodoAlreadyExistsException;
import org.jobhacker.springboot.app.exception.TodoNotFoundException;
import org.jobhacker.springboot.app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService{

    public TodoServiceImpl(TodoRepository repo) {
        this.repo = repo;
    }

    @Autowired
    private TodoRepository repo;

    // create new todo
    public Todo createTodo(Todo todo) {
        Todo existingTodo = repo.findById(todo.getId()).orElse(null);

        if (existingTodo == null) {
            return repo.save(todo);
        } else {
            throw new TodoAlreadyExistsException("Todo already exists!!");
        }
    }

    // return all todos
    public List<Todo> getAllTodos() {
        return repo.findAll();
    }

    // return specific todo by id
    public Todo getTodo(int id) {
        if(repo.findById(id).isEmpty())
            throw new TodoNotFoundException("Requested Todo does not exist");
        return repo.findById(id).get();
    }

    // return updated todo
    public Todo editTodo(Todo todo, int id) {
        Todo oldTodo = repo.findById(id).orElse(null);

        if(oldTodo == null)
            throw new TodoNotFoundException("No Such Todo exists!!");
        else{
            oldTodo.setId(todo.getId());
            oldTodo.setTitle(todo.getTitle());
            oldTodo.setDescription(todo.getDescription());
            oldTodo.setTimestamp(todo.getTimestamp());

            repo.save(oldTodo);
            return oldTodo;
        }

    }

    // delete todo by id
    public void deleteTodo(int id){
        Todo requestedTodo = repo.findById(id).orElse(null);

        if(requestedTodo == null)
            throw new TodoNotFoundException("Requested Todo to be deleted does not exist!!");
        else
            repo.deleteById(id);
    }


}
