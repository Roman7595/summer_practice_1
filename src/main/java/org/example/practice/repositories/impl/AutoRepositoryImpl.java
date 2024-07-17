package org.example.practice.repositories.impl;

import org.example.practice.entities.Auto;
import org.example.practice.repositories.interfaces.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AutoRepositoryImpl implements AutoRepository {
    @Autowired
    private JpaRepository<Auto, Integer> autoJpaRepository;


    @Override
    public Auto save(Auto auto) {
        return autoJpaRepository.save(auto);
    }

    @Override
    public Optional<Auto> findById(int id){
        return autoJpaRepository.findById(id);
    }

    @Override
    public List<Auto> getAll(){
        return autoJpaRepository.findAll();
    }
}
