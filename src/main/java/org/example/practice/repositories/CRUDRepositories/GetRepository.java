package org.example.practice.repositories.CRUDRepositories;

import java.util.List;
import java.util.Optional;

public interface GetRepository<T>{
    public Optional<T> findById(int id, String type);
    public List<T> findAll(String type);
}
