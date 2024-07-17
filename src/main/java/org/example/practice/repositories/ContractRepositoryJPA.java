package org.example.practice.repositories;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ContractRepositoryJPA extends JpaRepository<Contract, Integer> {

    @Query(value = "select con from Client cl join cl.autos a join a.contracts con where cl in :client")
    Set<Contract> getWhereClient(@Param(value = "client") Client client);

    @Query(value = "select con from Client cl join cl.autos a join a.contracts con join con.contractRisks cr join cr.risk r where cl = :client and r = :risk")
    Set<Contract> getWhereClientAndRisk(@Param(value = "client") Client client, @Param(value = "risk") Risk risk);

    @Query(value = "select con from Contract con join con.contractRisks cr join cr.risk r where r = :risk")
    Set<Contract> getWhereRisk(@Param(value = "risk") Risk risk);
}
