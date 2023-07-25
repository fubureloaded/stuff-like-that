package testing.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import testing.database.PersonEntity;
import testing.database.PersonRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static testing.util.PersonEntityMother.personEntity1;
import static testing.util.PersonEntityMother.personEntity2;
import static testing.util.PersonsMother.persons;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonMapper personMapper;

    @InjectMocks
    private PersonService underTest;

    @Test
    void getPersons() {
        List<PersonEntity> personEntities = List.of(personEntity1(), personEntity2());
        when(personRepository.findAll()).thenReturn(personEntities);
        Persons expected = persons();
        when(personMapper.toDtoList(personEntities)).thenReturn(expected.getPersons());

        var actual = underTest.getPersons();

        assertThat(actual).isEqualTo(expected);
    }
}
