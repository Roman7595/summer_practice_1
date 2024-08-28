package org.example.practice.repositories.customRepositories;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Payment;
import org.example.practice.entities.Risk;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface PaymentCustomRepository extends Repository<Payment, Integer> {

    @Query(value = "select p from Client cl join cl.autos a "
            + "join a.contracts con join con.contractRisks cr join cr.payments p join cr.risk r where cl = :client and r = :risk")
    Set<Payment> getWhereClientAndRisk(@Param(value = "client") Client client, @Param(value = "risk") Risk risk);

    @Query(value = "select p from ContractRisk cr join cr.payments p join cr.risk r where r = :risk")
    Set<Payment> getWhereRisk(@Param(value = "risk") Risk risk);

    @Query(value = "select p from ContractRisk cr join cr.payments p join cr.contract con where con = :contract")
    Set<Payment> getWhereContract(@Param(value = "contract") Contract contract);
}
