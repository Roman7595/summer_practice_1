package org.example.practice.controller.advices;

import org.example.practice.exceptions.InvalidPaymentDateException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class InvalidPaymentDateAdvice {
    @ResponseBody
    @ExceptionHandler(InvalidPaymentDateException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String invalidPaymentDateHandler(InvalidPaymentDateException ex) {
        return ex.getMessage();
    }
}
