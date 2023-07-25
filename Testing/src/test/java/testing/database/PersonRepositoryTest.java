package testing.database;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static testing.util.PersonEntityMother.personEntity1;
import static testing.util.PersonEntityMother.personEntity2;

@DataJpaTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository underTest;

    @Test
    void findAll() {
        List<PersonEntity> expected = List.of(personEntity1(), personEntity2());

        List<PersonEntity> actual = underTest.findAll();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}
