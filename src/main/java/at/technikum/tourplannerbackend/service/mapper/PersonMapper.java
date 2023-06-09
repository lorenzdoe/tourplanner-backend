package at.technikum.tourplannerbackend.service.mapper;


import at.technikum.tourplannerbackend.model.Person;
import at.technikum.tourplannerbackend.persistance.entities.PersonEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper extends AbstractMapper<PersonEntity, Person> {

    @Override
    public Person fromEntity(PersonEntity entity) {
        return Person.builder()
                .id(entity.getId())
                .name(entity.getName())
                .isEmployed(entity.isEmployed())
                .build();
    }

    @Override
    public PersonEntity toEntity(Person person) {
        return PersonEntity.builder()
                .id(person.getId())
                .name(person.getName())
                .isEmployed(person.getIsEmployed())
                .build();
    }

}
