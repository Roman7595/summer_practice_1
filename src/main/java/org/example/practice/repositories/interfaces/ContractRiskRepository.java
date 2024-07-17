package org.example.practice.repositories.interfaces;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.ContractRisk;
import org.example.practice.entities.Risk;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface ContractRiskRepository {
    ContractRisk getWhereContractAndRisk(Contract contract, Risk risk);

    Set<ContractRisk> getWhereClientAndRisk(Client client, Risk risk);

    Set<ContractRisk> getWhereContractAndRisk(Set<Contract> contracts, Risk risk);

    ContractRisk save(ContractRisk contractRisk);

}
