package com.example;

import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;

@MappedEntity(alias = "m2_")
public class MyEntity2 extends SoftDeletableEntity {
    @Relation(
            value = Relation.Kind.ONE_TO_ONE,
            mappedBy = "myEntity2",
            cascade = {Relation.Cascade.PERSIST})
    private MyJoinedEntity2 myJoinedEntity2;

    public MyJoinedEntity2 getMyJoinedEntity2() {
        return myJoinedEntity2;
    }

    public void setMyJoinedEntity2(MyJoinedEntity2 myJoinedEntity2) {
        this.myJoinedEntity2 = myJoinedEntity2;
    }
}
