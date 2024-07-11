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
    @Query(value = "select c from Contract c where c.id in :ids")
    Set<Contract> getAllByIds(@Param(value = "ids") Set<Integer> ids);

    @Query(value = "select con from Client cl join cl.autos a join a.contracts con where cl in :clients")
    Set<Contract> getWhereClients(@Param(value = "clients") Set<Client> clients);
}
