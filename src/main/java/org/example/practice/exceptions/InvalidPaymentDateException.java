package org.example.practice.exceptions;

public class InvalidPaymentDateException extends RuntimeException{
    public InvalidPaymentDateException(){
        super("Payment happened not during Contract");
    }

}
