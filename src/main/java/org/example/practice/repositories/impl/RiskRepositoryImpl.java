package org.example.practice.repositories.impl;

import org.example.practice.entities.Risk;
import org.example.practice.repositories.RiskRepositoryJPA;
import org.example.practice.repositories.interfaces.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class RiskRepositoryImpl implements RiskRepository {
    @Autowired
    RiskRepositoryJPA riskRepositoryJPA;

    @Override
    public Optional<Risk> getById(int id) {
        return riskRepositoryJPA.findById(id);
    }

    @Override
    public List<Risk> getAll() {
        return riskRepositoryJPA.findAll();
    }

    @Override
    public Set<Risk> getAllByIds(List<Integer> ids) {
        return riskRepositoryJPA.getAllByIds(ids);
    }
}
