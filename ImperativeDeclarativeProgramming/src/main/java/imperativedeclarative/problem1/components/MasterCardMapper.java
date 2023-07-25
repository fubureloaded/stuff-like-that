package imperativedeclarative.problem1.components;

import org.springframework.stereotype.Component;

@Component
public class MasterCardMapper {
    public CardDto toDto(CardEntity entity) {
        return CardDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .cardType(entity.getCardType())
                .build();
    }
}
