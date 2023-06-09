package at.technikum.tourplannerbackend.service;

import at.technikum.tourplannerbackend.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersonList();

    Person addNew(Person person);

    // erweitern mit parameter create new service
    Person findByName(String name);
}
