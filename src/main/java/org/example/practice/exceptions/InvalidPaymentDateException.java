package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomBadRequestException;

public class InvalidPaymentDateException extends CustomBadRequestException {
    public InvalidPaymentDateException(){
        super("Payment happened not during Contract");
    }

}
