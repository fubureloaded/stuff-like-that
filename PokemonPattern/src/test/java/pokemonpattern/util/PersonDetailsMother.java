package pokemonpattern.util;

import pokemonpattern.example.components.PersonDetails;

import java.util.List;

import static pokemonpattern.util.AddressMother.defaultAddress;
import static pokemonpattern.util.PhoneNumberMother.phoneNumber1;
import static pokemonpattern.util.PhoneNumberMother.phoneNumber2;

public class PersonDetailsMother {

    public static PersonDetails defaultPersonDetails() {
        return PersonDetails.builder()
                .address(defaultAddress())
                .phoneNumbers(List.of(phoneNumber1(), phoneNumber2()))
                .build();
    }
}
