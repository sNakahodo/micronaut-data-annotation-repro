package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Id;

@Introspected
public abstract class IDEntity {
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
