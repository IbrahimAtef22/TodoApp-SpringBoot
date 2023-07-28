package org.jobhacker.springboot.app.controller;

import org.jobhacker.springboot.app.entity.Todo;
import org.jobhacker.springboot.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Todo> saveTodo(@Validated @RequestBody Todo todo){
        Todo result = todoService.createTodo(todo);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping(value = {"", "/"})
    public ResponseEntity<List<Todo>> findAllTodos(){
        List<Todo> result = todoService.getAllTodos();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable int id){
        Todo result = todoService.getTodo(id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody Todo updatedTodo){
        Todo result = todoService.editTodo(updatedTodo, id);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable int id){
        todoService.deleteTodo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
