package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConditionalOnExpression(value = "${feature.taxPercentage.enabled:false}")
public class TaxPercentageCheck implements EligibilityCheck {

    private final BigDecimal taxPercentage;

    public TaxPercentageCheck(@Value("${product-eligibility.taxPercentage}") BigDecimal taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    @Override
    public boolean isEligible(ProductDto product) {
        return product.getTaxPercentage().compareTo(taxPercentage) != 0;
    }

    @Override
    public int getPriority() {
        return EligibilityCriterion.TAX_PERCENTAGE.getPriority();
    }

    @Override
    public ProductEligibility getNotEligible() {
        return ProductEligibility.PARTIALLY_ELIGIBLE;
    }
}
