package imperativedeclarative.problem1.util;

import imperativedeclarative.problem1.CardType;
import imperativedeclarative.problem1.components.CardEntity;

public class CardEntityMother {

    public static CardEntity visaCardEntity() {
        return CardEntity.builder()
                .id(1)
                .cardType(CardType.VISA)
                .amount(666)
                .build();
    }

    public static CardEntity masterCardEntity() {
        return CardEntity.builder()
                .id(1)
                .cardType(CardType.MASTERCARD)
                .amount(666)
                .build();
    }

    public static CardEntity defaultCardEntity(CardType cardType) {
        return CardEntity.builder()
                .id(1)
                .cardType(cardType)
                .amount(666)
                .build();
    }
}
