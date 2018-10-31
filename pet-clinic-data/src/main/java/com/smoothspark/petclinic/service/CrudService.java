package com.smoothspark.petclinic.service;

import java.util.Set;

/**
 * Created by SmoothSpark in 2018. 10. 17.
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T t);

    void delete(T t);

    void deleteById(ID id);
}
