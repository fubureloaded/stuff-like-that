package pokemonpattern.example.components;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {

    private String streetName;
    private Integer streetNumber;
    private String building;
    private Integer suitNumber;
}
