package ru.kolvah.service;

import ru.kolvah.entity.BaseEntity;

import java.util.List;

/**
 * Created by dmitriik on 20.05.2016.
 */
public interface BaseService<E extends BaseEntity> {

    void insert(E entity);

    void update(E entity);

    void delete(E entity);

    void delete(Long id);

    List<E> getAll();

    E getById(Long id);

    void beginWork();

    void endWork();
}
