package randomstuff.v2;

import randomstuff.v1.RandomDto;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

public class RandomComponentV2 {

    private final Supplier<LocalDate> localDateProvider;
    private final Supplier<UUID> uuidProvider;

    public RandomComponentV2(Supplier<LocalDate> localDateProvider, Supplier<UUID> uuidProvider) {
        this.localDateProvider = localDateProvider;
        this.uuidProvider = uuidProvider;
    }

    public RandomDto createRandomDto(String field) {
        return RandomDto.builder()
                .id(uuidProvider.get())
                .created(localDateProvider.get()) //.plusDays(1L)
                .field(field)
                .build();
    }
}
