package com.example;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;
import io.micronaut.data.annotation.Relation;

import javax.validation.constraints.NotNull;

@MappedEntity(value = "person_information")
public class PersonInformation extends IDEntity {
    @NotNull
    @MappedProperty(value = "person_id")
    @Relation(value = Relation.Kind.ONE_TO_ONE)
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
