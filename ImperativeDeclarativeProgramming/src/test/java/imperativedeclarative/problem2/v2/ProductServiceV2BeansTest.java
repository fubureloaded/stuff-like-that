package imperativedeclarative.problem2.v2;

import imperativedeclarative.problem2.v2.checks.AmountCheck;
import imperativedeclarative.problem2.v2.checks.AvailabilityCheck;
import imperativedeclarative.problem2.v2.checks.CategoryCheck;
import imperativedeclarative.problem2.v2.checks.DeliveryDateCheck;
import imperativedeclarative.problem2.v2.checks.EligibilityCheck;
import imperativedeclarative.problem2.v2.checks.ExpirationDateCheck;
import imperativedeclarative.problem2.v2.checks.ProductIdCheck;
import imperativedeclarative.problem2.v2.checks.TaxPercentageCheck;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {AmountCheck.class, AvailabilityCheck.class, CategoryCheck.class, DeliveryDateCheck.class,
        ExpirationDateCheck.class, ProductIdCheck.class, TaxPercentageCheck.class})
class ProductServiceV2BeansTest {

    @Autowired
    private List<EligibilityCheck> eligibilityChecks;


    @Test
    void checkBeans() {
        assertThat(eligibilityChecks).hasSize(7);
    }

}

