package ru.kolvah.dao.daoimpl;

import ru.kolvah.dao.EquipmentDao;
import ru.kolvah.entity.Equipment;

/**
 * Created by dmitriik on 18.05.2016.
 */

public class EquipmentDaoImpl extends BaseDaoImpl<Equipment> implements EquipmentDao {
    public EquipmentDaoImpl() {
        super(Equipment.class);
    }
}