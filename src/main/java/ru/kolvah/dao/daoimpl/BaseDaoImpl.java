package ru.kolvah.dao.daoimpl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.kolvah.SpringContext;
import ru.kolvah.dao.BaseDao;
import ru.kolvah.entity.BaseEntity;

import java.lang.reflect.Constructor;
import java.util.List;

/**
 * Created by dmitriik on 18.05.2016.
 */
public class BaseDaoImpl<E extends BaseEntity> implements BaseDao<E> {

    private Class<E> entityClass;

//    @Autowired
    private SessionFactory sessionFactory;


    public BaseDaoImpl(Class<E> entityClass) {
        init(entityClass);
    }

    protected final void init(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    private Session session;
    private Transaction transaction;


    public void insert(E entity) {
        getSession().save(entity);
    }

    public void update(E entity) {
        getSession().update(entity);
        try {
            Constructor constructor = entity.getClass().getConstructor();
            constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(E entity) {
        getSession().delete(entity);
    }

    public void delete(Long id) {
        getSession().delete(getById(id));
    }

    public List<E> getAll() {
        return createBaseCriteria().list();
    }

    public E getById(Long id) {
        return getSession().get(entityClass, id);
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = (SessionFactory)SpringContext.getContext().getBean("sessionFactory");
        }
        return sessionFactory;
    }

    public void beginWork() {
        if (session != null && session.isOpen()) {
            session.close();
        }
        if (session == null || !session.isOpen()) {
            session = getSessionFactory().openSession();
        }
        transaction = session.beginTransaction();
    }

    public void endWork() {
        transaction.commit();
    }



    public Criteria createBaseCriteria() {
        return session.createCriteria(entityClass);
    }

    protected Session getSession() {
        return session;
    }
}
