package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;

public interface EligibilityCheck {

    boolean isEligible(ProductDto product);

    int getPriority();

    ProductEligibility getNotEligible();

}