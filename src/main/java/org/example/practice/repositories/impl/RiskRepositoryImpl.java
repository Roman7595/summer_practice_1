package org.example.practice.repositories.impl;

import org.example.practice.entities.Risk;
import org.example.practice.repositories.RiskRepositoryJPA;
import org.example.practice.repositories.baseRepositories.GetRepository;
import org.example.practice.repositories.customRepositories.RiskCustomRepository;
import org.example.practice.repositories.interfaces.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class RiskRepositoryImpl implements RiskRepository {
    @Autowired
    RiskCustomRepository riskCustomRepository;

    @Autowired
    GetRepository<Risk> getRepository;

    @Override
    public Optional<Risk> getById(int id) {
        return getRepository.findById(id, Risk.class);
    }

    @Override
    public List<Risk> getAll() {
        return getRepository.findAll(Risk.class);
    }

    @Override
    public Set<Risk> getAllByIds(List<Integer> ids) {
        return riskCustomRepository.getAllByIds(ids);
    }
}
