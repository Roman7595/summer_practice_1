package org.example.practice.repositories;

import org.example.practice.entities.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AutoRepository extends JpaRepository<Auto, Integer> {
}
