package org.example.practice.exceptions.baseExceptions;

public class CustomBadRequestException extends RuntimeException{
    protected CustomBadRequestException(String message){
        super(message);
    }
}
