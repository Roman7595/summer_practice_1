package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomNotFoundException;

public class AutoNotFoundException  extends CustomNotFoundException {
    public AutoNotFoundException(){
        super("This Auto is not found");
    }
}
