package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.springframework.stereotype.Component;

@Component
public class DeliveryDateCheck implements EligibilityCheck {

    @Override
    public boolean isEligible(ProductDto product) {
        return product.getDeliveryDate().isBefore(product.getExpirationDate());
    }

    @Override
    public int getPriority() {
        return EligibilityCriterion.DELIVERY_DATE.getPriority();
    }

    @Override
    public ProductEligibility getNotEligible() {
        return ProductEligibility.NOT_ELIGIBLE;
    }
}
