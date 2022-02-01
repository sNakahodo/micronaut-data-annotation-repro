package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import jakarta.inject.Inject;

// TLDR: if we have a table join, the @Where("@.deleted = false") is not generated in the query.
// Person represents the setup with an @Join
// Car represents one without.
@MicronautTest
class DataDemoTest {
    @Inject
    private PersonRepository personRepository;
    @Inject
    private PersonInformationRepository personInformationRepository;
    @Inject
    private CarRepository carRepository;
    @Inject private CarInformationRepository carInformationRepository;

    @Test
    void shouldRetrieveNonDeletedPerson() {
        Person person = new Person();
        person.setId(4476L);
        person.setDeleted(false);
        Person savedPerson = personRepository.save(person);
        Assertions.assertTrue(personRepository.findById(savedPerson.getId()).isPresent());
    }

    // @HERE: This should not return a present value as we have @where deleted false.
    @Test
    void shouldNotRetrieveDeletedPerson() {
        Person person = new Person();
        person.setId(5727L);
        person.setDeleted(true);
        Person savedPerson = personRepository.save(person);
        Assertions.assertFalse(personRepository.findById(savedPerson.getId()).isPresent());
    }

    /*
     * Take the example of the Car repository where CarRepository has no join definition.
     */
    @Test
    void shouldRetrieveNonDeletedCar() {
        Car car = new Car();
        car.setId(8765L);
        car.setDeleted(false);
        Car savedCar = carRepository.save(car);
        Assertions.assertTrue(carRepository.findById(car.getId()).isPresent());
    }

    // @HERE: Notice how this correctly does not return a value.
    @Test
    void shouldNotRetrieveDeletedCar() {
        Car car = new Car();
        car.setId(4163L);
        car.setDeleted(true);
        Car savedCar = carRepository.save(car);
        Assertions.assertFalse(carRepository.findById(car.getId()).isPresent());
    }
}
