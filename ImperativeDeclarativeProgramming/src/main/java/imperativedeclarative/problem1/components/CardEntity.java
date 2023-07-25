package imperativedeclarative.problem1.components;

import imperativedeclarative.problem1.CardType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardEntity {
    private Integer id;
    private Integer amount;
    private CardType cardType;
}
