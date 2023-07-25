package randomstuff.v1;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class RandomDto {

    private UUID id;
    private LocalDate created;
    private String field;
}
