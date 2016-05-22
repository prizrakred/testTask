package ru.kolvah.dao.daoimpl;

import ru.kolvah.dao.MeasurementDao;
import ru.kolvah.entity.Measurement;

/**
 * Created by dmitriik on 18.05.2016.
 */
public class MeasurementDaoImpl extends BaseDaoImpl<Measurement> implements MeasurementDao {
    public MeasurementDaoImpl() {
        super(Measurement.class);
    }
}
