package com.example;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.*;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@JdbcRepository(dialect = Dialect.POSTGRES)
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Override
    @Join(value = "personInformation", type = Join.Type.LEFT_FETCH)
    Optional<Person> findById(@Id @NonNull Long id);
}
