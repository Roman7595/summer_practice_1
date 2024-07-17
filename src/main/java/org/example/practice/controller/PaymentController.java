package org.example.practice.controller;

import org.example.practice.DTO.ContractDTO;
import org.example.practice.DTO.PaymentDTO;
import org.example.practice.DTO.toAdd.PaymentToAddDTO;
import org.example.practice.exceptions.InvalidPaymentDateException;
import org.example.practice.services.interfaces.PaymentDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    PaymentDomainService paymentDomainService;

    @PostMapping("/")
    PaymentDTO add(@RequestBody PaymentToAddDTO payment) throws InvalidPaymentDateException {
        return paymentDomainService.addPayment(payment);
    }
    @GetMapping("/")
    List<PaymentDTO> getAll(){
        return paymentDomainService.getAll();
    }

    @GetMapping("/{id}")
    PaymentDTO one(@PathVariable Integer id){
        return paymentDomainService.getById(id);
    }


}
