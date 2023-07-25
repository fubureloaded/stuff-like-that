package pokemonpattern.util;

import pokemonpattern.example.components.Address;

public class AddressMother {

    public static Address defaultAddress() {
        return Address.builder()
                .streetName("My Street")
                .streetNumber(666)
                .building("18c")
                .suitNumber(3)
                .build();
    }
}
