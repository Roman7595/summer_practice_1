package org.example.practice.repositories;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface ClientRepositoryJPA extends JpaRepository<Client, Integer> {
    @Query(value = "select c from Client c join c.autos a where a = :auto")
    Client getWhereAutos(@Param(value = "auto") Auto auto);
}
