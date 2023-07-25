package testing.service;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Persons {

    private List<PersonDto> persons;
}
