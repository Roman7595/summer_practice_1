package org.example.practice.repositories.impl;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.ContractRisk;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.ContractRiskRepositoryJPA;
import org.example.practice.repositories.interfaces.ContractRiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ContractRiskRepositoryImpl implements ContractRiskRepository {
    @Autowired
    ContractRiskRepositoryJPA contractRiskRepositoryJPA;


    @Override
    public ContractRisk getWhereContractAndRisk(Contract contract, Risk risk) {
        return contractRiskRepositoryJPA.getWhereContractAndRisk(contract, risk);
    }

    @Override
    public Set<ContractRisk> getWhereClientAndRisk(Client client, Risk risk) {
        return contractRiskRepositoryJPA.getWhereClientAndRisk(client,risk);
    }

    @Override
    public ContractRisk save(ContractRisk contractRisk) {
        return contractRiskRepositoryJPA.save(contractRisk);
    }
    @Override
    public Set<ContractRisk> getWhereContractAndRisk(Set<Contract> contracts, Risk risk){
        return contractRiskRepositoryJPA.getWhereContractAndRisk(contracts, risk);
    }
}
