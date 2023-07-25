package imperativedeclarative.problem1;

import imperativedeclarative.problem1.operation.CardOperation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static imperativedeclarative.problem1.util.CardDtoMother.defaultCardDto;
import static imperativedeclarative.problem1.util.CardEntityMother.defaultCardEntity;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardOperationV2Test {
    private static final Set<CardType> VALID_CARD_TYPES = Set.of(CardType.VISA, CardType.MASTERCARD);

    @Mock
    private CardOperation cardOperation;

    @ParameterizedTest
    @EnumSource(value = CardType.class)
    void getDeposit(CardType cardType) {
        when(cardOperation.cardType()).thenReturn(cardType);
        CardsOperationV2 underTest = new CardsOperationV2(List.of(cardOperation));
        var cardEntity = defaultCardEntity(cardType);
        when(cardOperation.findById(1)).thenReturn(Optional.of(cardEntity));
        var cardDto = defaultCardDto(cardType);
        when(cardOperation.toDto(cardEntity)).thenReturn(cardDto);

        var actual = underTest.getAmount(cardDto);

        assertThat(actual).isEqualTo(666);
    }

    @ParameterizedTest
    @EnumSource(value = CardType.class)
    void getDeposit_implementedTypes(CardType cardType) {
        assertThat(VALID_CARD_TYPES).contains(cardType);
    }
}
