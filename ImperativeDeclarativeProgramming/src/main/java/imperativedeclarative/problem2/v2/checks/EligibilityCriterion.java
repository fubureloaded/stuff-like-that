package imperativedeclarative.problem2.v2.checks;

import lombok.Getter;

@Getter
public enum EligibilityCriterion {

    PRODUCT_ID(10),
    CATEGORY(20),
    AMOUNT(30),
    AVAILABILITY(40),
    EXPIRATION_DATE(50),
    DELIVERY_DATE(60),
    TAX_PERCENTAGE(70);

    private final int priority;

    EligibilityCriterion(int priority) {
        this.priority = priority;
    }
}