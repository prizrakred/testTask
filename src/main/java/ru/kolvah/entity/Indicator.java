package ru.kolvah.entity;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.kolvah.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by dmitriik on 18.05.2016.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Indicator extends BaseEntity {

    @Column
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
