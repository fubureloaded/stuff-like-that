package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnExpression(value = "${feature.amount.enabled:false}")
public class AmountCheck implements EligibilityCheck {

    private final int minAmount;
    private final int maxAmount;

    public AmountCheck(@Value("${product-eligibility.minAmount}") int minAmount,
                       @Value("${product-eligibility.maxAmount}") int maxAmount) {
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    @Override
    public boolean isEligible(ProductDto product) {
        var productAmount = product.getAmount();
        return productAmount >= minAmount && productAmount <= maxAmount;
    }

    @Override
    public int getPriority() {
        return EligibilityCriterion.AMOUNT.getPriority();
    }

    @Override
    public ProductEligibility getNotEligible() {
        return ProductEligibility.NOT_ELIGIBLE;
    }
}