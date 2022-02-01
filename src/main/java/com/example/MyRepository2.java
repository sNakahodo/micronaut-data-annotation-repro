package com.example;

import io.micronaut.context.annotation.Executable;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Join;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface MyRepository2 extends CrudRepository<MyEntity2, Long> {

    @Override
    @Join(value = "myJoinedEntity2", type = Join.Type.LEFT_FETCH, alias = "j2_")
    Optional<MyEntity2> findById(Long id);

}
