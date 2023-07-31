package org.jobhacker.springboot.app.exception;

/**
 * That can be thrown when user tries to add a todo that already exists
 */
public class TodoAlreadyExistsException extends RuntimeException{
    public TodoAlreadyExistsException(String message) {
        super(message);
    }
}
