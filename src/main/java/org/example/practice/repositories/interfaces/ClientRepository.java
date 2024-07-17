package org.example.practice.repositories.interfaces;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {
    public Client save(Client client);
    public List<Client> findAll();

    public Optional<Client> findById(int id);
    public Client getWhereAutos(Auto auto);


}
