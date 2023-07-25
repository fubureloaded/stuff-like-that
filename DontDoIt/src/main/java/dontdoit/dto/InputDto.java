package dontdoit.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
@Builder
public class InputDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private int age;
}
