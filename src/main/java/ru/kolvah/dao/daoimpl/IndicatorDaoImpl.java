package ru.kolvah.dao.daoimpl;

import ru.kolvah.dao.IndicatorDao;
import ru.kolvah.entity.Indicator;

/**
 * Created by dmitriik on 18.05.2016.
 */
public class IndicatorDaoImpl extends BaseDaoImpl<Indicator> implements IndicatorDao {
    public IndicatorDaoImpl() {
        super(Indicator.class);
    }
}
