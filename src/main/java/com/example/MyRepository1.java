package com.example;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.context.annotation.Executable;
import io.micronaut.data.annotation.*;

import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface MyRepository1 extends CrudRepository<MyEntity1, Long> {

    @Override
    @Join(value = "myJoinedEntity1", type = Join.Type.LEFT_FETCH, alias = "j1_")
    Optional<MyEntity1> findById(@NotNull @NonNull Long id);

}
