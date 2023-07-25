package imperativedeclarative.problem1.operation;

import imperativedeclarative.problem1.CardType;
import imperativedeclarative.problem1.components.CardDto;
import imperativedeclarative.problem1.components.CardEntity;
import imperativedeclarative.problem1.components.MasterCardMapper;
import imperativedeclarative.problem1.components.MasterCardRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MastercardOperation implements CardOperation {

    private final MasterCardRepository cardRepository;
    private final MasterCardMapper cardMapper;

    public MastercardOperation(MasterCardRepository cardRepository, MasterCardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public CardType cardType() {
        return CardType.MASTERCARD;
    }

    @Override
    public Optional<CardEntity> findById(Integer cardId) {
        return cardRepository.findById(cardId);
    }

    @Override
    public CardDto toDto(CardEntity cardEntity) {
        return cardMapper.toDto(cardEntity);
    }
}
