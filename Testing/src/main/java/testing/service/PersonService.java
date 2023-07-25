package testing.service;

import org.springframework.stereotype.Service;
import testing.database.PersonRepository;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    public PersonService(PersonRepository personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    public Persons getPersons() {
        List<PersonDto> personDtos = personMapper.toDtoList(personRepository.findAll());

        return Persons.builder()
                .persons(personDtos)
                .build();
    }
}
