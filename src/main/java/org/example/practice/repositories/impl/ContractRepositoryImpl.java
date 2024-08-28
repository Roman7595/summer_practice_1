package org.example.practice.repositories.impl;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.baseRepositories.GetRepository;
import org.example.practice.repositories.baseRepositories.SaveRepository;
import org.example.practice.repositories.customRepositories.ContractCustomRepository;
import org.example.practice.repositories.interfaces.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ContractRepositoryImpl implements ContractRepository {
    @Autowired
    ContractCustomRepository contractCustomRepository;

    @Autowired
    GetRepository<Contract> getRepository;

    @Autowired
    SaveRepository<Contract> saveRepository;

    @Override
    public Set<Contract> getWhereClient(Client client) {
        return contractCustomRepository.getWhereClient(client);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return getRepository.findById(id,Contract.class);
    }

    @Override
    public Contract save(Contract contract) {
        return saveRepository.save(contract);
    }

    @Override
    public List<Contract> getAll(){
        return getRepository.findAll(Contract.class);
    }

    @Override
    public Optional<Contract> getById(int id){
        return getRepository.findById(id,Contract.class);
    }

    @Override
    public Set<Contract> getWhereRisk(Risk risk) {
        return contractCustomRepository.getWhereRisk(risk);
    }

}
