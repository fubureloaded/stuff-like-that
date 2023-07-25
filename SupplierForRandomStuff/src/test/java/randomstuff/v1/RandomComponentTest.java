package randomstuff.v1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomComponentTest {

    private final RandomComponent underTest = new RandomComponent();

    @Test
    void createRandomDto() {
        var expected = RandomDto.builder().field("some field").build();

        var actual = underTest.createRandomDto("some field");

        assertThat(actual).usingRecursiveComparison().ignoringFields("id", "created").isEqualTo(expected);
        assertThat(actual.getCreated()).isNotNull();
        assertThat(actual.getId()).isNotNull();
    }

    @Test
    void createRandomDto_2() {
        var expected = RandomDto.builder().field("some field").build();

        var actual = underTest.createRandomDto("some field");

        assertThat(actual).usingRecursiveComparison().ignoringFields("id", "created").isEqualTo(expected);
    }
}
