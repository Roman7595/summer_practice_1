package org.example.practice.exceptions;

public class AutoNotFoundException  extends RuntimeException{
    public AutoNotFoundException(){
        super("No Auto");
    }
}
