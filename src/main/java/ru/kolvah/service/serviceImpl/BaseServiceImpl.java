package ru.kolvah.service.serviceImpl;

import ru.kolvah.dao.BaseDao;
import ru.kolvah.dao.daoimpl.BaseDaoImpl;
import ru.kolvah.entity.BaseEntity;
import ru.kolvah.service.BaseService;

import java.util.List;

/**
 * Created by dmitriik on 20.05.2016.
 */
public class BaseServiceImpl<E extends BaseEntity> implements BaseService<E> {
    //    @Autowired
    BaseDao<E> baseDao;

    public BaseServiceImpl(Class<E> entityClass) {
        baseDao = new BaseDaoImpl<E>(entityClass);
    }

//    @Transactional
    public void insert(E entity) {
        baseDao.beginWork();
        baseDao.insert(entity);
        baseDao.endWork();
    }

//    @Transactional
    public void update(E entity) {
        baseDao.beginWork();
        baseDao.update(entity);
        baseDao.endWork();
    }

//    @Transactional
    public void delete(E entity) {
        baseDao.beginWork();
        baseDao.delete(entity);
        baseDao.endWork();
    }

//    @Transactional
    public void delete(Long id) {
        baseDao.beginWork();
        baseDao.delete(id);
        baseDao.endWork();
    }

//    @Transactional
    public List<E> getAll() {
        baseDao.beginWork();
        List<E> list = baseDao.getAll();
        baseDao.endWork();
        return list;
    }

//    @Transactional
    public E getById(Long id) {
        baseDao.beginWork();
        E e = baseDao.getById(id);
        baseDao.endWork();
        return e;
    }
}
