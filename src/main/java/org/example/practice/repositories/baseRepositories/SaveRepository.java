package org.example.practice.repositories.CRUDRepositories;

public interface SaveRepository<T>{
    public T save(T entity);
}
