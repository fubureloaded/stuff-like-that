package testing.util;

import testing.service.PersonDto;

public class PersonDtoMother {

    public static PersonDto person1() {
        return PersonDto.builder()
                .id(666L)
                .name("Bula")
                .build();
    }

    public static PersonDto person2() {
        return PersonDto.builder()
                .id(777L)
                .name("Gigi")
                .build();
    }
}
