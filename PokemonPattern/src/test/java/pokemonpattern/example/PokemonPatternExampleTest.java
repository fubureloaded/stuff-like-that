package pokemonpattern.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pokemonpattern.example.components.Component1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static pokemonpattern.util.PersonMother.defaultPerson;

@ExtendWith(MockitoExtension.class)
class PokemonPatternExampleTest {

    private static final String MY_STREET = "MY STREET";

    @Mock
    private Component1 component1;

    @InjectMocks
    private PokemonPatternExample underTest;

    @Test
    void beautifyStreetName() {
        when(component1.doSomeStuff("My Street")).thenReturn(MY_STREET);

        var actual = underTest.beautifyStreetName(defaultPerson());

        assertEquals(MY_STREET, actual);
    }
}
