package org.example.practice.repositories.interfaces;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface PaymentRepository {
    public Set<Payment> getWhereContract(Contract contract);
    public Payment save(Payment payment);
    public Set<Payment> getWhereClientAndRisk(Client client, Risk risk);
    public Set<Payment> getWhereRisk(Risk risk);

    public List<Payment> getAll();
    public Optional<Payment> getById(int id);
}
