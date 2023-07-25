package beans.statelessbean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatelessBeanDto {

    private Boolean isActive;
    private String data;
}
