package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomConflictException;

public class ContractPeriodOfTimeCollisionException extends CustomConflictException {
    public ContractPeriodOfTimeCollisionException(){
        super("This auto already insure for this time");
    }
}
