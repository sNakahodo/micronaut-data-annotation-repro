package com.example;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.annotation.Relation;

import javax.validation.constraints.NotNull;

@MappedEntity
public class MyJoinedEntity2 extends IDEntity {
    @NotNull
    @MappedProperty(value = "myentity1_id")
    @Relation(value = Relation.Kind.ONE_TO_ONE)
    private MyEntity2 myEntity2;
}
