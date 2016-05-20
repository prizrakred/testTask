package ru.kolvah.entity;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.List;

/**
 * Created by dmitriik on 18.05.2016.
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Equipment extends BaseEntity {

    @Column
    private String shortName;

    @Column
    private String fullName;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<Measurement> measurements;

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String name) {
        this.shortName = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    public void addMeasurement(Measurement measurement) {
        measurement.setEquipment(this);
        measurements.add(measurement);
    }
}
