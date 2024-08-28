package org.example.practice.repositories.baseRepositories;

public interface UpdateRepository<T> {
    public T update(T entity);
}
