package imperativedeclarative.problem1;

import imperativedeclarative.problem1.components.CardDto;
import imperativedeclarative.problem1.components.MasterCardMapper;
import imperativedeclarative.problem1.components.MasterCardRepository;
import imperativedeclarative.problem1.components.VisaMapper;
import imperativedeclarative.problem1.components.VisaRepository;
import org.springframework.stereotype.Component;

import static imperativedeclarative.problem1.CardType.MASTERCARD;
import static imperativedeclarative.problem1.CardType.VISA;

@Component
public class CardsOperationV1 {

    private final VisaRepository visaRepository;
    private final MasterCardRepository masterCardRepository;
    private final VisaMapper visaMapper;
    private final MasterCardMapper masterCardMapper;

    public CardsOperationV1(VisaRepository visaRepository, MasterCardRepository masterCardRepository,
                            VisaMapper visaMapper, MasterCardMapper masterCardMapper) {
        this.visaRepository = visaRepository;
        this.masterCardRepository = masterCardRepository;
        this.visaMapper = visaMapper;
        this.masterCardMapper = masterCardMapper;
    }

    public Integer getAmount(CardDto input) {
        var cardType = input.getCardType();
        if (VISA.equals(cardType)) {
            var visaEntity = visaRepository.findById(input.getId()).orElseThrow(() -> new RuntimeException("Visa not found"));
            return visaMapper.toDto(visaEntity).getAmount();
        } else if (MASTERCARD.equals(cardType)) {
            var masterCardEntity = masterCardRepository.findById(input.getId()).orElseThrow(() -> new RuntimeException("MasterCard not found"));
            return masterCardMapper.toDto(masterCardEntity).getAmount();
        } else {
            throw new RuntimeException("Not Implemented");
        }
    }
}
