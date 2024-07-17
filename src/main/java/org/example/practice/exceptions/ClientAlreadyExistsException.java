package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomConflictException;

public class ClientAlreadyExistsException extends CustomConflictException {
    public ClientAlreadyExistsException(){
        super("This Client already exists");
    }
}
