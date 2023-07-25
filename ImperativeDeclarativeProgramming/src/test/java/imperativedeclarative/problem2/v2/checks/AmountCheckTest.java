package imperativedeclarative.problem2.v2.checks;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class AmountCheckTest {

    private static final int MIN_AMOUNT = 10;
    private static final int MAX_AMOUNT = 100;

    private final AmountCheck underTest = new AmountCheck(MIN_AMOUNT, MAX_AMOUNT);

    @ParameterizedTest
    @CsvSource({"9,false", "10,true", "100,true", "101,false"})
    void isEligible(int amount, boolean isEligible) {
        ProductDto input = new ProductDto();
        input.setAmount(amount);

        var actual = underTest.isEligible(input);

        assertThat(actual).isEqualTo(isEligible);
    }

    @Test
    void getPriority() {
        assertThat(underTest.getPriority()).isEqualTo(EligibilityCriterion.AMOUNT.getPriority());
    }

    @Test
    void getNotEligible() {
        assertThat(underTest.getNotEligible()).isEqualTo(ProductEligibility.NOT_ELIGIBLE);
    }
}
