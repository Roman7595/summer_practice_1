package org.example.practice.repositories.baseRepositories;

public interface SaveRepository<T>{
    public T save(T entity);
}
