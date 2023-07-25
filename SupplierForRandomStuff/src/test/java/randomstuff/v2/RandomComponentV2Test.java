package randomstuff.v2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import randomstuff.v1.RandomDto;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RandomComponentV2Test {

    @Mock
    private Supplier<LocalDate> localDateProvider;

    @Mock
    private Supplier<UUID> uuidProvider;

    private RandomComponentV2 underTest;

    @BeforeEach
    void setUp() {
        underTest = new RandomComponentV2(localDateProvider, uuidProvider); //due to type erasure
    }

    @Test
    void createRandomDto() {
        LocalDate localDateNow = LocalDate.now();
        UUID uuid = UUID.randomUUID();
        when(localDateProvider.get()).thenReturn(localDateNow);
        when(uuidProvider.get()).thenReturn(uuid);
        var expected = RandomDto.builder().id(uuid).created(localDateNow).field("some field").build();

        var actual = underTest.createRandomDto("some field");

        assertThat(actual).isEqualTo(expected);
    }
}
