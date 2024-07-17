package org.example.practice.repositories.impl;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.example.practice.repositories.ClientRepositoryJPA;
import org.example.practice.repositories.interfaces.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements ClientRepository {
    @Autowired
    ClientRepositoryJPA clientJpaRepository;


    @Override
    public Client save(Client client) {
        return clientJpaRepository.save(client);
    }

    @Override
    public List<Client> findAll() {
        return clientJpaRepository.findAll();
    }

    @Override
    public Optional<Client> findById(int id){
        return clientJpaRepository.findById(id);
    }
    @Override
    public Client getWhereAutos(Auto auto){
        return clientJpaRepository.getWhereAutos(auto);
    }
}
