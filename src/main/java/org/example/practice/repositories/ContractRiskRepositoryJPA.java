package org.example.practice.repositories;

import org.example.practice.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Set;


public interface ContractRiskRepository extends JpaRepository<ContractRisk,Integer> {
    @Query(value = "select cr from ContractRisk cr where cr.contract = :contract and cr.risk = :risk")
    ContractRisk getWhereContractAndRisk(@Param(value = "contract") Contract contract, @Param(value = "risk") Risk risk);

    @Query(value = "select cr from ContractRisk cr where cr.contract in :contracts and cr.risk = :risk")
    Set<ContractRisk> getWhereContractAndRisk(@Param(value = "contracts") Set<Contract> contracts, @Param(value = "risk") Risk risk);

    @Query(value = "select cr from ContractRisk cr join cr.contract con join con.auto a join a.client cl where cl = :client and cr.risk = :risk")
    Set<ContractRisk> getWhereClientAndRisk(@Param(value = "client") Client client, @Param(value = "risk") Risk risk);

}
