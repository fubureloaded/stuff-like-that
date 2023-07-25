package pokemonpattern.example.components;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Person {

    private String firstName;
    private String lastName;

    private PersonDetails personDetails;
}
