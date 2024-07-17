package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomBadRequestException;

public class InvalidContractTimePeriodException extends CustomBadRequestException {
    public InvalidContractTimePeriodException(){
        super("Start time of contract after or equal to End time");
    }
}
