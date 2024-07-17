package org.example.practice.services.interfaces;

import org.example.practice.DTO.PaymentDTO;
import org.example.practice.DTO.toAdd.PaymentToAddDTO;
import org.example.practice.exceptions.InvalidPaymentDateException;

import java.util.List;


public interface PaymentDomainService {
    public PaymentDTO addPayment(PaymentToAddDTO paymentToAddDTO) throws InvalidPaymentDateException;
    public List<PaymentDTO> getAll();
    public PaymentDTO getById(int id);
}
