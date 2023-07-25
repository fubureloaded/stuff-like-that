package duplicatecode.components;

import lombok.Data;

import java.util.Optional;

@Data
public class MyPojo {
    private Integer field;
    private String field1;
    private Optional<String> field2;
}
