package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomNotFoundException;

public class ClientNotFoundException extends CustomNotFoundException {
    public ClientNotFoundException(){
        super("This Client is not found");
    }
}
