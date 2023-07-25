package imperativedeclarative.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfacesTest {

    private final FunctionalInterfaces underTest = new FunctionalInterfaces();

    @Test
    void getSomething() {
        List<Integer> input = List.of(90, 1, 2, 3, -4000, -1234, -58);
        List<Integer> expected = List.of(3, 2);

        var actual = underTest.getSomething(input);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getSomethingWithFunctionalInterfaces() {
        List<Integer> input = List.of(90, 1, 2, 3, -4000, -1234, -58);
        List<Integer> expected = List.of(3, 2);

        var actual = underTest.getSomethingWithFunctionalInterfaces(input);

        assertThat(actual).isEqualTo(expected);
    }

}
