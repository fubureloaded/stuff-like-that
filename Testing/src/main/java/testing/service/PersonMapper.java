package testing.service;

import org.springframework.stereotype.Component;
import testing.database.PersonEntity;

import java.util.List;

@Component
public class PersonMapper {

    public PersonDto toDto(PersonEntity personEntity) {
        return PersonDto.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .build();
    }

    public List<PersonDto> toDtoList(List<PersonEntity> personEntities) {
        return personEntities.stream()
                .map(this::toDto)
                .toList();
    }
}
