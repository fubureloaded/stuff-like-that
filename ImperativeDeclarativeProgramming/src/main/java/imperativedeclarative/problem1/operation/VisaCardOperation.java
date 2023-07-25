package imperativedeclarative.problem1.operation;

import imperativedeclarative.problem1.CardType;
import imperativedeclarative.problem1.components.CardDto;
import imperativedeclarative.problem1.components.CardEntity;
import imperativedeclarative.problem1.components.VisaMapper;
import imperativedeclarative.problem1.components.VisaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VisaCardOperation implements CardOperation {

    private final VisaRepository cardRepository;
    private final VisaMapper cardMapper;

    public VisaCardOperation(VisaRepository cardRepository, VisaMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public CardType cardType() {
        return CardType.VISA;
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