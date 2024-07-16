package org.example.practice.controller;

import org.example.practice.DTO.PaymentToCreateDTO;
import org.example.practice.exceptions.InvalidPaymentDateException;
import org.example.practice.services.interfaces.AddPaymentDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    AddPaymentDomainService addPaymentDomainService;

    @PostMapping("/add")
    int add(@RequestBody PaymentToCreateDTO payment) throws InvalidPaymentDateException {
        return addPaymentDomainService.addPayment(payment);
    }


}
