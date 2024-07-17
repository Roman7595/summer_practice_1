package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomBadRequestException;

public class InvalidPaymentSumException extends CustomBadRequestException {
    public InvalidPaymentSumException(String message){
        super("This Payment has invalid sum: " + message);
    }
}
