package org.example.practice.exceptions.baseExceptions;

public class CustomNotFoundException extends RuntimeException{
    protected CustomNotFoundException(String message){
        super(message);
    }
}
