package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomNotFoundException;

public class RiskNotFoundException extends CustomNotFoundException {
    public RiskNotFoundException(){
        super("This Risk is not found");
    }
}
