package dontdoit.example2;

import dontdoit.dto.InputDto;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class ValidInServiceLayer {
    /*
    Also valid for @Component
     */

    public String getFirstName(@Valid InputDto input) {
        return input.getFirstName();
    }
}
