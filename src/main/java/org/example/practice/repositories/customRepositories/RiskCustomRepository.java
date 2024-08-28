package org.example.practice.repositories.customRepositories;

import org.example.practice.entities.Risk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface RiskCustomRepository extends JpaRepository<Risk, Integer> {

    @Query(value = "select r from Risk r where r.id in :ids")
    Set<Risk> getAllByIds(@Param(value = "ids") List<Integer> ids);

}
