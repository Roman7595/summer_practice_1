package org.example.practice.repositories.CRUDRepositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GetRepositoryImpl<T> implements GetRepository<T>{

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    public Optional<T> findById(int id, String entityClass){
        return Optional.of((T) entityManager.createQuery("Select t from " + entityClass + " t where t.id = ?1").setParameter(1, id).getSingleResult());
    }

    @Transactional
    public List<T> findAll(String entityClass){
        return entityManager.createQuery("Select t from " + entityClass + " t").getResultList();

    }

}
