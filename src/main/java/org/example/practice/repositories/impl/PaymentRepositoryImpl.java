package org.example.practice.repositories.impl;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.PaymentRepositoryJPA;
import org.example.practice.repositories.interfaces.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    @Autowired
    PaymentRepositoryJPA paymentRepositoryJPA;
    @Override
    public Set<Payment> getWhereContract(Contract contract) {
        return paymentRepositoryJPA.getWhereContract(contract);
    }
    @Override
    public Payment save(Payment payment) {
        return paymentRepositoryJPA.save(payment);
    }
    @Override
    public Set<Payment> getWhereClientAndRisk(Client client, Risk risk) {
        return paymentRepositoryJPA.getWhereClientAndRisk(client, risk);
    }
    @Override
    public Set<Payment> getWhereRisk(Risk risk) {
        return paymentRepositoryJPA.getWhereRisk(risk);
    }
    @Override
    public List<Payment> getAll(){
        return paymentRepositoryJPA.findAll();
    }
    @Override
    public Optional<Payment> getById(int id){
        return paymentRepositoryJPA.findById(id);
    }
}
