package ru.kolvah.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import ru.kolvah.entity.BaseEntity;

import java.util.List;

/**
 * Created by dmitriik on 18.05.2016.
 */
public interface BaseDao<E extends BaseEntity> {

    void insert(E entity);

    void update(E entity);

    void delete(E entity);

    void delete(Long id);

    List<E> getAll();

    E getById(Long id);

    Criteria createBaseCriteria();

    SessionFactory getSessionFactory();

    void beginWork();

    void endWork();
}
