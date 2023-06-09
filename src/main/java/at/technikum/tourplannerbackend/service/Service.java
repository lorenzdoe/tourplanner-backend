package at.technikum.tourplannerbackend.service;

import java.util.List;

public interface Service<T> {
    List<T> getList();
    T addNew(T t);
    T findById(Long id);
    void delete(T t);
    T update(T t);
}
