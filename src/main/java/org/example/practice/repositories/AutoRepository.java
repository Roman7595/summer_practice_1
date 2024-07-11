package org.example.practice.repositories;

import org.example.practice.entities.Auto;
import org.example.practice.entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {
    @Query(value = "select a from Auto a where a.id in :ids")
    Set<Auto> getAllByIds(@Param(value = "ids") Set<Integer> ids);
}
