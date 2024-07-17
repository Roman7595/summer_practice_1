package org.example.practice.repositories;

import org.example.practice.entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RiskRepositoryJPA extends JpaRepository<Risk, Integer> {

    @Query(value = "select r from Risk r where r.id in :ids")
    Set<Risk> getAllByIds(@Param(value = "ids") List<Integer> ids);

}
