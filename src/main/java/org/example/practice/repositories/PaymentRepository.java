package org.example.practice.repositories;

import org.example.practice.entities.Client;
import org.example.practice.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    @Query(value = "select p from Client cl join cl.autos a "
            + "join a.contracts con join con.contractRisks cr join cr.payments p where cl in :clients")
    Set<Payment> getWhereClients(@Param(value = "clients") Set<Client> clients);
}
