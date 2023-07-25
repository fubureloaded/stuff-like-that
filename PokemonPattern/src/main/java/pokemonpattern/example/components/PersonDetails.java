package pokemonpattern.example.components;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PersonDetails {

    private Address address;
    private List<PhoneNumber> phoneNumbers;
}
