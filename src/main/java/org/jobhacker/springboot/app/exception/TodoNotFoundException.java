package org.jobhacker.springboot.app.exception;
/**
 * That can be thrown when user tries to update, delete or get a todo that does not exist
 */
public class TodoNotFoundException extends RuntimeException{

    public TodoNotFoundException(String message) {
        super(message);
    }

}
