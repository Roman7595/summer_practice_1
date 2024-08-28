package org.example.practice.repositories.customRepositories;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClientCustomRepository extends org.springframework.data.repository.Repository<Client, Integer> {
    @Query(value = "select c from Client c join c.autos a where a = :auto")
    Client getWhereAutos(@Param(value = "auto") Auto auto);
}
