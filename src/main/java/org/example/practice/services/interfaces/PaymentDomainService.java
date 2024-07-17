package org.example.practice.services.interfaces;

import org.example.practice.DTO.PaymentToCreateDTO;
import org.example.practice.exceptions.InvalidPaymentDateException;


public interface AddPaymentDomainService {
    public int addPayment(PaymentToCreateDTO paymentToCreateDTO) throws InvalidPaymentDateException;
}
