package randomstuff.v1;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.UUID;

@Component
public class RandomComponent {

    public RandomDto createRandomDto(String field) {
        return RandomDto.builder()
                .id(UUID.randomUUID())
                .created(LocalDate.now()) //.plusDays(1L)
                .field(field)
                .build();
    }
}
