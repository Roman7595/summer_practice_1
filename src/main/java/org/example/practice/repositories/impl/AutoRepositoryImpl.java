package org.example.practice.repositories.impl;

import org.example.practice.entities.Auto;
import org.example.practice.repositories.CRUDRepositories.GetRepository;
import org.example.practice.repositories.CRUDRepositories.SaveRepository;
import org.example.practice.repositories.interfaces.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AutoRepositoryImpl implements AutoRepository {
    @Autowired
    private SaveRepository<Auto> saveRepository;
    @Autowired
    private GetRepository<Auto> getRepository;

    @Override
    public Auto save(Auto auto) {
        return saveRepository.save(auto);
    }

    @Override
    public Optional<Auto> findById(int id){
        return getRepository.findById(id, "Auto");
    }

    @Override
    public List<Auto> getAll(){
        return getRepository.findAll("Auto");
    }
}
