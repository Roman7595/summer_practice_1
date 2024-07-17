package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomBadRequestException;

public class InvalidAutoNumberException extends CustomBadRequestException {
    public InvalidAutoNumberException(){
        super("This Auto has invalid number");
    }
}
