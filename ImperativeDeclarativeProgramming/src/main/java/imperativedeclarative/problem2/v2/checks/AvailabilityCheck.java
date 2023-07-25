package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityCheck implements EligibilityCheck {

    @Override
    public boolean isEligible(ProductDto product) {
        return product.isAvailable();
    }

    @Override
    public int getPriority() {
        return EligibilityCriterion.AVAILABILITY.getPriority();
    }

    @Override
    public ProductEligibility getNotEligible() {
        return ProductEligibility.PARTIALLY_ELIGIBLE;
    }
}