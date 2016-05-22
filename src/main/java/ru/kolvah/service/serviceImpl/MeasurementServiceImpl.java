package ru.kolvah.service.serviceImpl;

import ru.kolvah.entity.Measurement;
import ru.kolvah.service.MeasurementService;

/**
 * Created by dmitriik on 20.05.2016.
 */
public class MeasurementServiceImpl extends BaseServiceImpl<Measurement> implements MeasurementService {
    public MeasurementServiceImpl() {
        super(Measurement.class);
    }
}
