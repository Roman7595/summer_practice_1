package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomBadRequestException;

public class InvalidLiabilityLimitException  extends CustomBadRequestException {
    public InvalidLiabilityLimitException(){
        super("Can't insure more than 100% of auto");
    }
}
