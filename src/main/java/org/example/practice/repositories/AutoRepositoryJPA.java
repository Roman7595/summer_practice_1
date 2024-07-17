package org.example.practice.repositories;

import org.example.practice.entities.Auto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoRepositoryJPA extends JpaRepository<Auto, Integer> {
}
