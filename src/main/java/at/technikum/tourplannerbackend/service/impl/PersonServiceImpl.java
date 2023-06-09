package at.technikum.tourplannerbackend.service.impl;

import at.technikum.tourplannerbackend.model.Person;
import at.technikum.tourplannerbackend.persistance.entities.PersonEntity;
import at.technikum.tourplannerbackend.persistance.repositories.PersonRepository;
import at.technikum.tourplannerbackend.service.PersonService;
import at.technikum.tourplannerbackend.service.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonMapper personMapper;

    @Override
    public List<Person> getPersonList() {
        return personMapper.fromEntity(personRepository.findAll());
    }

    @Override
    public Person addNew(Person person) {
        if (person == null){
            return null;
        }
        PersonEntity entity = personRepository.save(personMapper.toEntity(person));
        return personMapper.fromEntity(entity);
    }

    @Override
    public Person findByName(String name) {
        return personMapper.fromEntity(personRepository.findByName(name));
    }
}
