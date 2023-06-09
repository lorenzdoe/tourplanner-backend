package at.technikum.tourplannerbackend.persistence;

import at.technikum.tourplannerbackend.persistance.entities.PersonEntity;
import at.technikum.tourplannerbackend.persistance.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonPersistenceTests {

	@Autowired
	private PersonRepository personRepository;

	@Test
	void helloWorldTest() {
		System.out.println("Hello World");
	}

	@Test
	void testPersonRepository() {
		PersonEntity maxi = PersonEntity.builder()
				.name("Maxi")
				.email("maxi@email.com")
				.build();
		personRepository.save(maxi);
		personRepository.findAll().forEach(System.out::println);
	}
}
