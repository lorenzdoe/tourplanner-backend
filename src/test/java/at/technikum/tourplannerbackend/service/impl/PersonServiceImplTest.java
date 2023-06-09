package at.technikum.tourplannerbackend.service.impl;

import at.technikum.tourplannerbackend.model.Person;
import at.technikum.tourplannerbackend.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class PersonServiceImplTest {

    @Autowired
    PersonService personService;

    @Test
    public void findByNameTest(){
        // Arrange
        Person person = Person.builder()
                .name("Hans")
                .isEmployed(true)
                .build();
        personService.addNew(person);
        String name = "Hans";

        // Act
        Person person1 = personService.findByName(name);

        // Assert
        assertNotNull(person1);
        assertEquals(name, person1.getName());
    }

}