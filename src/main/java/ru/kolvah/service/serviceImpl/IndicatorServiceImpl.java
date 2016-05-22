package ru.kolvah.service.serviceImpl;

import ru.kolvah.entity.Indicator;
import ru.kolvah.service.IndicatorService;

/**
 * Created by dmitriik on 20.05.2016.
 */
public class IndicatorServiceImpl extends BaseServiceImpl<Indicator> implements IndicatorService {
    public IndicatorServiceImpl() {
        super(Indicator.class);
    }
}
