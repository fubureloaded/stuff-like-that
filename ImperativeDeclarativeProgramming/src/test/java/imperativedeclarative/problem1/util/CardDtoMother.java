package imperativedeclarative.problem1.util;

import imperativedeclarative.problem1.CardType;
import imperativedeclarative.problem1.components.CardDto;

public class CardDtoMother {

    public static CardDto visaCardDto() {
        return CardDto.builder()
                .id(1)
                .cardType(CardType.VISA)
                .amount(666)
                .build();
    }

    public static CardDto masterCardDto() {
        return CardDto.builder()
                .id(1)
                .cardType(CardType.MASTERCARD)
                .amount(666)
                .build();
    }

    public static CardDto defaultCardDto(CardType cardType) {
        return CardDto.builder()
                .id(1)
                .cardType(cardType)
                .amount(666)
                .build();
    }
}
