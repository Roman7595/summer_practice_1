package org.example.practice.repositories.interfaces;

import org.example.practice.entities.Risk;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RiskRepository {
    Optional<Risk> getById(int id);
    List<Risk> getAll();
    Set<Risk> getAllByIds(List<Integer> ids);


}
