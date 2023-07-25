package testing.util;

import testing.service.Persons;

import java.util.List;

import static testing.util.PersonDtoMother.person1;
import static testing.util.PersonDtoMother.person2;

public class PersonsMother {

    public static Persons persons() {
        return Persons.builder()
                .persons(List.of(person1(), person2()))
                .build();
    }
}
