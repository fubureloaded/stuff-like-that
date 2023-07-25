package pokemonpattern.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pokemonpattern.example.components.Address;
import pokemonpattern.example.components.Component1;
import pokemonpattern.example.components.Person;
import pokemonpattern.example.components.PersonDetails;

import java.util.Optional;

@Component
@Slf4j
public class PokemonPatternExample {

    private static final String NO_STREET_NAME = "No street name";

    private final Component1 component1;

    public PokemonPatternExample(Component1 component1) {
        this.component1 = component1;
    }

    public String beautifyStreetName(Person person) {
        try {
            return Optional.ofNullable(person)
                    .map(Person::getPersonDetails)
                    .map(PersonDetails::getAddress)
                    .map(Address::getStreetName)
                    .map(component1::doSomeStuff)
                    .orElse(NO_STREET_NAME);
        } catch (Exception ex) {
            log.error("error occurred: ", ex);
        }
        return NO_STREET_NAME;
    }
}
