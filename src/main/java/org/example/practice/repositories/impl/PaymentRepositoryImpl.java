package org.example.practice.repositories.impl;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.PaymentRepositoryJPA;
import org.example.practice.repositories.baseRepositories.GetRepository;
import org.example.practice.repositories.baseRepositories.SaveRepository;
import org.example.practice.repositories.customRepositories.PaymentCustomRepository;
import org.example.practice.repositories.interfaces.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {
    @Autowired
    PaymentCustomRepository paymentCustomRepository;

    @Autowired
    SaveRepository<Payment> saveRepository;

    @Autowired
    GetRepository<Payment> getRepository;

    @Override
    public Set<Payment> getWhereContract(Contract contract) {
        return paymentCustomRepository.getWhereContract(contract);
    }
    @Override
    public Payment save(Payment payment) {

        return saveRepository.save(payment);
    }
    @Override
    public Set<Payment> getWhereClientAndRisk(Client client, Risk risk) {
        return paymentCustomRepository.getWhereClientAndRisk(client, risk);
    }
    @Override
    public Set<Payment> getWhereRisk(Risk risk) {

        return paymentCustomRepository.getWhereRisk(risk);
    }
    @Override
    public List<Payment> getAll(){
        return getRepository.findAll(Payment.class);
    }
    @Override
    public Optional<Payment> getById(int id){
        return getRepository.findById(id, Payment.class);
    }
}
