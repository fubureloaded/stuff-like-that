package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@ConditionalOnExpression(value = "${feature.category.enabled:false}")
public class CategoryCheck implements EligibilityCheck {

    private final Set<String> eligibleCategories;

    public CategoryCheck(@Value("${product-eligibility.eligibleCategories}") Set<String> eligibleCategories) {
        this.eligibleCategories = eligibleCategories;
    }

    @Override
    public boolean isEligible(ProductDto product) {
        return eligibleCategories.contains(product.getCategory());
    }

    @Override
    public int getPriority() {
        return EligibilityCriterion.CATEGORY.getPriority();
    }

    @Override
    public ProductEligibility getNotEligible() {
        return ProductEligibility.PARTIALLY_ELIGIBLE;
    }
}