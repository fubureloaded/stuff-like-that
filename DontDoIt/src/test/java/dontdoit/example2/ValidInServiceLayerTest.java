package dontdoit.example2;

import dontdoit.dto.InputDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNull;


@SpringBootTest
class ValidInServiceLayerTest {

    @Autowired
    private ValidInServiceLayer underTest;

    @Test
    void getFirstName() {
        var input = InputDto.builder().build(); //.firstName("fname")

        var actual = underTest.getFirstName(input);

        assertNull(actual);
    }
}
