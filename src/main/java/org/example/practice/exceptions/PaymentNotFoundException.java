package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomNotFoundException;

public class PaymentNotFoundException extends CustomNotFoundException {
    public PaymentNotFoundException(){
        super("This Payment is not found");
    }
}