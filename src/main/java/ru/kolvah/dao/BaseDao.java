package ru.kolvah.dao;

import org.hibernate.Criteria;
import ru.kolvah.entity.BaseEntity;

import java.util.List;

/**
 * Created by dmitriik on 18.05.2016.
 */
public interface BaseDao<T extends BaseEntity> {

    void save(T entity);

    void update(T entity);

    void delete(T entity);

    List getAll();

    T getById(Long id);

    Criteria createBaseCriteria();
}
