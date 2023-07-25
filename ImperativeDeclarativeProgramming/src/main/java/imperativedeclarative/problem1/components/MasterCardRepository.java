package imperativedeclarative.problem1.components;

import imperativedeclarative.problem1.CardType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MasterCardRepository {

    public Optional<CardEntity> findById(Integer id) {
        return Optional.of(CardEntity.builder()
                .id(id)
                .amount(666)
                .cardType(CardType.MASTERCARD)
                .build());
    }
}
