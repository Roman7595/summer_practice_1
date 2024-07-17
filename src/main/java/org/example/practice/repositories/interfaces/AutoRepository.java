package org.example.practice.repositories.interfaces;

import org.example.practice.entities.Auto;

import java.util.List;
import java.util.Optional;

public interface AutoRepository {
    Auto save(Auto auto);
    Optional<Auto> findById(int id);

    List<Auto> getAll();
}
