package imperativedeclarative.problem2;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ProductDto {

    private Integer productId;
    private String category;
    private Integer amount;
    private boolean isAvailable;
    private LocalDate expirationDate;
    private LocalDate deliveryDate;
    private BigDecimal taxPercentage;
}
