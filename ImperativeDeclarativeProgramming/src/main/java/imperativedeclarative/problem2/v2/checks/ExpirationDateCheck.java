package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ExpirationDateCheck implements EligibilityCheck {

    @Override
    public boolean isEligible(ProductDto product) {
        return product.getExpirationDate().isAfter(LocalDate.now());
    }

    @Override
    public int getPriority() {
        return EligibilityCriterion.EXPIRATION_DATE.getPriority();
    }

    @Override
    public ProductEligibility getNotEligible() {
        return ProductEligibility.NOT_ELIGIBLE;
    }
}