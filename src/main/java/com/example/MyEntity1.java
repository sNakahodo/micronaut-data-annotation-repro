package com.example;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

@MappedEntity(alias = "m1_")
public class MyEntity1 extends SoftDeletableEntity {
    @Relation(
            value = Relation.Kind.ONE_TO_ONE,
            mappedBy = "myEntity1",
            cascade = {Relation.Cascade.PERSIST})
    private MyJoinedEntity1 myJoinedEntity1;

    public MyJoinedEntity1 getMyJoinedEntity1() {
        return myJoinedEntity1;
    }

    public void setMyJoinedEntity1(MyJoinedEntity1 myJoinedEntity1) {
        this.myJoinedEntity1 = myJoinedEntity1;
    }
}
