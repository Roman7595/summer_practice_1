package org.example.practice.repositories.interfaces;

import org.example.practice.entities.Client;
import org.example.practice.entities.Contract;
import org.example.practice.entities.Risk;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ContractRepository {
    public Set<Contract> getWhereClient(Client client);
    public Optional<Contract> findById(int id);
    public Contract save(Contract contract);
    public List<Contract> getAll();
    public Optional<Contract> getById(int id);

    public Set<Contract> getWhereRisk(Risk risk);
}
