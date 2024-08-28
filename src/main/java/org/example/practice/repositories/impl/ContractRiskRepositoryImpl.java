package org.example.practice.repositories.impl;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.ContractRisk;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.baseRepositories.SaveRepository;
import org.example.practice.repositories.customRepositories.ContractRiskCustomRepository;
import org.example.practice.repositories.interfaces.ContractRiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class ContractRiskRepositoryImpl implements ContractRiskRepository {
    @Autowired
    ContractRiskCustomRepository contractRiskCustomRepository;

    @Autowired
    SaveRepository<ContractRisk> saveRepository;

    @Override
    public ContractRisk getWhereContractAndRisk(Contract contract, Risk risk) {
        return contractRiskCustomRepository.getWhereContractAndRisk(contract, risk);
    }

    @Override
    public Set<ContractRisk> getWhereClientAndRisk(Client client, Risk risk) {
        return contractRiskCustomRepository.getWhereClientAndRisk(client,risk);
    }

    @Override
    public ContractRisk save(ContractRisk contractRisk) {

        return saveRepository.save(contractRisk);
    }
    @Override
    public Set<ContractRisk> getWhereContractAndRisk(Set<Contract> contracts, Risk risk){
        return contractRiskCustomRepository.getWhereContractAndRisk(contracts, risk);
    }
}
