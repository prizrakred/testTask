package ru.kolvah.dao.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.kolvah.dao.BaseDao;
import ru.kolvah.entity.BaseEntity;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by dmitriik on 18.05.2016.
 */
public abstract class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {

    private Class<T> type;

    @Autowired
    private SessionFactory sessionFactory;

    public BaseDaoImpl() {
        type = (Class<T>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    public void save(T entity) {
        getSession().save(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public List<T> getAll() {
        return createBaseCriteria().list();
    }

    public T getById(Long id) {
        return getSession().load(type, id);
    }

    public Criteria createBaseCriteria() {
        return getSession().createCriteria(type);
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public Class<T> getType() {
        return type;
    }
}
