package testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import testing.service.PersonService;
import testing.service.Persons;

@RestController
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("persons")
    public Persons getPersons() {
        return personService.getPersons();
    }
}
