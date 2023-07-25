package testing.util;

import testing.database.PersonEntity;

public class PersonEntityMother {

    public static PersonEntity personEntity1() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(1L);
        personEntity.setName("Name 1");
        return personEntity;
    }

    public static PersonEntity personEntity2() {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(2L);
        personEntity.setName("Name 2");
        return personEntity;
    }
}
