package org.jobhacker.springboot.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TodoExceptionHandler {

    @ExceptionHandler(value = {TodoNotFoundException.class})
    public ResponseEntity<Object> handleTodoNotFoundException(TodoNotFoundException todoNotFoundException){
        TodoException todoException = new TodoException(
                todoNotFoundException.getMessage(),
                todoNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(todoException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {TodoAlreadyExistsException.class})
    public ResponseEntity<Object> handleTodoNotFoundException(TodoAlreadyExistsException todoAlreadyExistsException){
        TodoException todoException = new TodoException(
                todoAlreadyExistsException.getMessage(),
                todoAlreadyExistsException.getCause(),
                HttpStatus.CONFLICT
        );
        return new ResponseEntity<>(todoException, HttpStatus.CONFLICT);
    }


}
