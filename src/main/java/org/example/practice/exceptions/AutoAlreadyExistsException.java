package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomConflictException;

public class AutoAlreadyExistsException extends CustomConflictException {
    public AutoAlreadyExistsException(){
        super("This Auto already exists");
    }
}
