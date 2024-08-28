package org.example.practice.repositories.impl;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.example.practice.repositories.CRUDRepositories.GetRepository;
import org.example.practice.repositories.CRUDRepositories.SaveRepository;
import org.example.practice.repositories.CustomRepositories.ClientCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements org.example.practice.repositories.interfaces.ClientRepository {
    @Autowired
    GetRepository<Client> getRepository;

    @Autowired
    SaveRepository<Client> saveRepository;

    @Autowired
    ClientCustomRepository clientCustomRepository;


    @Override
    public Client save(Client client) {
        return saveRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return getRepository.findAll("Client");
    }

    @Override
    public Optional<Client> findById(int id){
        return getRepository.findById(id,"Client");
    }
    @Override
    public Client getWhereAutos(Auto auto){
        return clientCustomRepository.getWhereAutos(auto);
    }
}
