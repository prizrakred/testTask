package ru.kolvah.service.serviceImpl;

import ru.kolvah.entity.Equipment;
import ru.kolvah.entity.Measurement;
import ru.kolvah.service.EquipmentService;

/**
 * Created by dmitriik on 20.05.2016.
 */
public class EquipmentServiceImpl extends BaseServiceImpl<Equipment> implements EquipmentService {
    public EquipmentServiceImpl() {
        super(Equipment.class);
    }

    @Override
    public void insert(Equipment entity) {
        for (Measurement measurement : entity.getMeasurements()) {
            measurement.setEquipment(entity);
        }
        super.insert(entity);
    }

    @Override
    public void update(Equipment entity) {
        for (Measurement measurement : entity.getMeasurements()) {
            measurement.setEquipment(entity);
        }
        super.update(entity);
    }
}
