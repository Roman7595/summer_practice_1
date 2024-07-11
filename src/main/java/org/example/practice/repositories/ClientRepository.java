package org.example.practice.repositories;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    @Query(value = "select c from Client join c.autos a where a in :autos")
    List<Client> getWhereAutos(@Param(value = "autos") Set<Auto> autos);
}
