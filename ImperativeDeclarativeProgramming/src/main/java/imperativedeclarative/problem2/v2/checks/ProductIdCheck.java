package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductIdCheck implements EligibilityCheck {

    private final int minProductId;

    public ProductIdCheck(@Value("${product-eligibility.productId}") int minProductId) {
        this.minProductId = minProductId;
    }

    @Override
    public boolean isEligible(ProductDto product) {
        return product.getProductId() > minProductId;
    }

    @Override
    public int getPriority() {
        return EligibilityCriterion.PRODUCT_ID.getPriority();
    }

    @Override
    public ProductEligibility getNotEligible() {
        return ProductEligibility.NOT_ELIGIBLE;
    }
}