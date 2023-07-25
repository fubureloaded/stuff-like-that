package imperativedeclarative.problem1.operation;

import imperativedeclarative.problem1.CardType;
import imperativedeclarative.problem1.components.CardDto;
import imperativedeclarative.problem1.components.CardEntity;

import java.util.Optional;

public interface CardOperation {
    CardType cardType();

    Optional<CardEntity> findById(Integer cardId);

    CardDto toDto(CardEntity cardEntity);
}
