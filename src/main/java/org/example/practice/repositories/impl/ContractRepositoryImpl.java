package org.example.practice.repositories.impl;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Risk;
import org.example.practice.repositories.ContractRepositoryJPA;
import org.example.practice.repositories.interfaces.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class ContractRepositoryImpl implements ContractRepository {
    @Autowired
    ContractRepositoryJPA contractRepositoryJPA;


    @Override
    public Set<Contract> getWhereClient(Client client) {
        return contractRepositoryJPA.getWhereClient(client);
    }

    @Override
    public Optional<Contract> findById(int id) {
        return contractRepositoryJPA.findById(id);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepositoryJPA.save(contract);
    }

    @Override
    public List<Contract> getAll(){
        return contractRepositoryJPA.findAll();
    }

    @Override
    public Optional<Contract> getById(int id){
        return contractRepositoryJPA.findById(id);
    }

    @Override
    public Set<Contract> getWhereRisk(Risk risk) {
        return contractRepositoryJPA.getWhereRisk(risk);
    }

}
