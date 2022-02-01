package com.example;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

@MappedEntity(value = "car")
public class Car extends SoftDeletableEntity  {

    @Relation(
            value = Relation.Kind.ONE_TO_ONE,
            mappedBy = "car")
    private CarInformation carInformation;

    public CarInformation getCarInformation() {
        return carInformation;
    }

    public void setCarInformation(CarInformation carInformation) {
        this.carInformation = carInformation;
    }
}
