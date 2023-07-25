package pokemonpattern.util;

import pokemonpattern.example.components.PhoneNumber;

public class PhoneNumberMother {

    public static PhoneNumber phoneNumber1() {
        return PhoneNumber.builder()
                .phoneNumber("07xx123456")
                .build();
    }

    public static PhoneNumber phoneNumber2() {
        return PhoneNumber.builder()
                .phoneNumber("07yy000000")
                .build();
    }
}
