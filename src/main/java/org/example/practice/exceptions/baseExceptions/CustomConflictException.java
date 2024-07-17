package org.example.practice.exceptions.baseExceptions;

public class CustomConflictException extends RuntimeException{
    protected CustomConflictException(String message){
        super(message);
    }
}
