package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomNotFoundException;

public class ContractNotFoundException extends CustomNotFoundException {
    public ContractNotFoundException(){
        super("This Contract is not found");
    }
}
