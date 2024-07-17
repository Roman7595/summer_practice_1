package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomBadRequestException;

public class TooExpansiveException extends CustomBadRequestException {
    public TooExpansiveException(){
        super("Insurance Premium will be more than Liability Limit");
    }
}
