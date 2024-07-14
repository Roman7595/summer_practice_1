package org.example.practice.repositories;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    @Query(value = "select con from Client cl join cl.autos a join a.contracts con where cl in :client")
    Set<Contract> getWhereClients(@Param(value = "client") Client client);
}
