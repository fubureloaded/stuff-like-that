package pokemonpattern.util;

import pokemonpattern.example.components.Person;

import static pokemonpattern.util.PersonDetailsMother.defaultPersonDetails;

public class PersonMother {

    public static Person defaultPerson() {
        return Person.builder()
                .firstName("First Name")
                .lastName("Last Name")
                .personDetails(defaultPersonDetails())
                .build();
    }
}
