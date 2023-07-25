package imperativedeclarative.problem2.v2;

import imperativedeclarative.problem2.ProductDto;
import imperativedeclarative.problem2.ProductEligibility;
import imperativedeclarative.problem2.v2.checks.EligibilityCheck;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static imperativedeclarative.problem2.ProductEligibility.ELIGIBLE;
import static imperativedeclarative.problem2.ProductEligibility.PARTIALLY_ELIGIBLE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductServiceV2Test {

    private static final ProductDto INPUT_DTO = new ProductDto();

    @Mock
    private EligibilityCheck dummyEligibilityCheck1;

    @Mock
    private EligibilityCheck dummyEligibilityCheck2;

    private ProductServiceV2 underTest;

    @BeforeEach
    void setup() {
        when(dummyEligibilityCheck1.getPriority()).thenReturn(1);
        when(dummyEligibilityCheck2.getPriority()).thenReturn(2);
        underTest = new ProductServiceV2(List.of(dummyEligibilityCheck1, dummyEligibilityCheck2));
    }

    @Test
    void checkProductEligibility_eligible() {
        when(dummyEligibilityCheck1.isEligible(any())).thenReturn(true);
        when(dummyEligibilityCheck2.isEligible(any())).thenReturn(true);

        var actual = underTest.checkProductEligibility(INPUT_DTO);

        assertThat(actual).isEqualTo(ELIGIBLE);
    }

    @Test
    void checkProductEligibility_notEligible() {
        when(dummyEligibilityCheck1.isEligible(any())).thenReturn(false);
        when(dummyEligibilityCheck1.getNotEligible()).thenReturn(ProductEligibility.PARTIALLY_ELIGIBLE);
        //when(dummyEligibilityCheck2.isEligible(any())).thenReturn(true);

        var actual = underTest.checkProductEligibility(INPUT_DTO);

        assertThat(actual).isEqualTo(PARTIALLY_ELIGIBLE);
    }
}
