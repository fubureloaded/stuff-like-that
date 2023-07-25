package dontdoit.example1;

import dontdoit.dto.InputDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Slf4j
public class PrimitivesInDto {
    /*
    Also valid for Spring Data Jpa/Hibernate
     */

    @PostMapping("primitives-in-dto")
    public void create(@Valid @RequestBody InputDto inputDto) {
        log.info("======================> " + inputDto.getAge());
    }
}
