package imperativedeclarative.problem2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class ProductServiceV1 {
    private static final int MIN_PRODUCT_ID = 1234;
    private static final String ELIGIBLE_CATEGORY = "A";
    private static final int MIN_AMOUNT = 200;
    private static final int MAX_AMOUNT = 300;

    private final boolean isFeatureCategoryEnabled;
    private final boolean isFeatureAmountEnabled;
    private final boolean isFeatureTaxPercentageEnabled;

    public ProductServiceV1(@Value("${feature.category.enabled}") boolean isFeatureCategoryEnabled,
                            @Value("${feature.amount.enabled}") boolean isFeatureAmountEnabled,
                            @Value("${feature.taxPercentage.enabled}") boolean isFeatureTaxPercentageEnabled) {
        this.isFeatureCategoryEnabled = isFeatureCategoryEnabled;
        this.isFeatureAmountEnabled = isFeatureAmountEnabled;
        this.isFeatureTaxPercentageEnabled = isFeatureTaxPercentageEnabled;
    }

    public ProductEligibility calculateProductEligibility(ProductDto product) {

        if (product.getProductId() <= MIN_PRODUCT_ID) {
            return ProductEligibility.NOT_ELIGIBLE;
        }

        if (isFeatureCategoryEnabled && !ELIGIBLE_CATEGORY.equals(product.getCategory())) {
            return ProductEligibility.PARTIALLY_ELIGIBLE;
        }

        if (isFeatureAmountEnabled && (product.getAmount() < MIN_AMOUNT || product.getAmount() > MAX_AMOUNT)) {
            return ProductEligibility.NOT_ELIGIBLE;
        }

        if (!product.isAvailable()) {
            return ProductEligibility.PARTIALLY_ELIGIBLE;
        }

        if (!product.getExpirationDate().isAfter(LocalDate.now())) {
            return ProductEligibility.NOT_ELIGIBLE;
        }

        if (!product.getDeliveryDate().isBefore(product.getExpirationDate())) {
            return ProductEligibility.NOT_ELIGIBLE;
        }

        if (isFeatureTaxPercentageEnabled && product.getTaxPercentage().compareTo(BigDecimal.ZERO) == 0) {
            return ProductEligibility.PARTIALLY_ELIGIBLE;
        }

        return ProductEligibility.ELIGIBLE;
    }
}
