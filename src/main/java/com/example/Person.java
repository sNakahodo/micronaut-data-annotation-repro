package com.example;

import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

@MappedEntity(value = "person")
public class Person extends SoftDeletableEntity {
    @Relation(
            value = Relation.Kind.ONE_TO_ONE,
            mappedBy = "person")
    private PersonInformation personInformation;

    public PersonInformation getPersonInformation() {
        return personInformation;
    }

    public void setPersonInformation(PersonInformation personInformation) {
        this.personInformation = personInformation;
    }
}
