package beans.transactional;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestDto {

    private Integer id;
    private String name;

    private String address;
}
