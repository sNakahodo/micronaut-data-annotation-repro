package com.example;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.annotation.Relation;

import javax.validation.constraints.NotNull;

@MappedEntity(value = "car_information")
public class CarInformation extends IDEntity{
    @NotNull
    @MappedProperty(value = "car_id")
    @Relation(value = Relation.Kind.ONE_TO_ONE)
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
