package imperativedeclarative.problem1;

import imperativedeclarative.problem1.components.CardDto;
import imperativedeclarative.problem1.operation.CardOperation;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CardsOperationV2 {
    private final Map<CardType, CardOperation> cardOperationMap;

    public CardsOperationV2(List<CardOperation> cardOperations) {
        cardOperationMap = cardOperations.stream().collect(Collectors.toMap(CardOperation::cardType, Function.identity()));
    }

    public Integer getAmount(CardDto input) {
        var cardOperation = cardOperationMap.get(input.getCardType());

        if (cardOperation == null) {
            throw new RuntimeException("Not implemented");
        }

        var cardEntity = cardOperation.findById(input.getId()).orElseThrow(() -> new RuntimeException("Card not found"));
        return cardOperation.toDto(cardEntity).getAmount();
    }
}
