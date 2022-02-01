package com.example;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.Where;

import javax.validation.constraints.NotNull;

@Introspected
@Where("@.deleted = false")
public abstract class SoftDeletableEntity extends IDEntity {
    @NotNull
    private Boolean deleted = false;
}
