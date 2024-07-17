package org.example.practice.exceptions;

import org.example.practice.exceptions.baseExceptions.CustomNotFoundException;

public class ContractRiskNotFoundException extends CustomNotFoundException {
    public ContractRiskNotFoundException(){
        super("This Contract do not insure this Risk");
    }
}
