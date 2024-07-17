package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomBadRequestException;

public class InvalidPassportException extends CustomBadRequestException {
    public InvalidPassportException(){
        super("Invalid passport number or series");
    }
}
