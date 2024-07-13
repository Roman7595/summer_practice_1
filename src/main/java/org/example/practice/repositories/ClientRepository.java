package org.example.practice.repositories;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;


@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = "select c from Client c join c.autos a where a in :autos")
    Set<Client> getWhereAutos(@Param(value = "autos") Set<Auto> autos);
}
