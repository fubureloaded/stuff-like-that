package imperativedeclarative.problem1.operation;

import imperativedeclarative.problem1.CardType;
import imperativedeclarative.problem1.components.VisaMapper;
import imperativedeclarative.problem1.components.VisaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static imperativedeclarative.problem1.util.CardDtoMother.visaCardDto;
import static imperativedeclarative.problem1.util.CardEntityMother.visaCardEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisaCardOperationTest {

    @Mock
    private VisaRepository visaRepository;

    @Mock
    private VisaMapper visaMapper;

    @InjectMocks
    private VisaCardOperation underTest;

    @Test
    void cardType() {
        assertThat(underTest.cardType()).isEqualTo(CardType.VISA);
    }

    @Test
    void findById() {
        var cardEntityOptional = Optional.of(visaCardEntity());
        when(visaRepository.findById(1)).thenReturn(cardEntityOptional);

        var actual = underTest.findById(1);

        assertThat(actual).isEqualTo(cardEntityOptional);
    }

    @Test
    void toDto() {
        var cardEntity = visaCardEntity();
        var cardDto = visaCardDto();
        when(visaMapper.toDto(cardEntity)).thenReturn(cardDto);

        var actual = underTest.toDto(cardEntity);

        assertThat(actual).isEqualTo(cardDto);
    }
}
