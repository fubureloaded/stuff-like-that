package imperativedeclarative.problem2.v2;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import imperativedeclarative.problem2.v2.checks.EligibilityCheck;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductServiceV2 {

    private final List<EligibilityCheck> eligibilityCriteria;

    public ProductServiceV2(List<EligibilityCheck> eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria.stream()
                .sorted(Comparator.comparingInt(EligibilityCheck::getPriority))
                .toList();
    }

    public ProductEligibility checkProductEligibility(ProductDto product) {
        return eligibilityCriteria.stream()
                .filter(check -> !check.isEligible(product))
                .findFirst()
                .map(EligibilityCheck::getNotEligible)
                .orElse(ProductEligibility.ELIGIBLE);
    }
}
