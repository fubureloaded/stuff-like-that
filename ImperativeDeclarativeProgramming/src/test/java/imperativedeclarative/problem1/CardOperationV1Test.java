package imperativedeclarative.problem1;

import imperativedeclarative.problem1.components.CardDto;
import imperativedeclarative.problem1.components.CardEntity;
import imperativedeclarative.problem1.components.MasterCardMapper;
import imperativedeclarative.problem1.components.MasterCardRepository;
import imperativedeclarative.problem1.components.VisaMapper;
import imperativedeclarative.problem1.components.VisaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static imperativedeclarative.problem1.util.CardDtoMother.masterCardDto;
import static imperativedeclarative.problem1.util.CardDtoMother.visaCardDto;
import static imperativedeclarative.problem1.util.CardEntityMother.masterCardEntity;
import static imperativedeclarative.problem1.util.CardEntityMother.visaCardEntity;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardOperationV1Test {

    @Mock
    private VisaRepository visaRepository;

    @Mock
    private MasterCardRepository masterCardRepository;

    @Mock
    private VisaMapper visaMapper;

    @Mock
    private MasterCardMapper masterCardMapper;

    @InjectMocks
    private CardsOperationV1 underTest;

    @Test
    void getAmount_visa() {
        CardEntity cardEntity = visaCardEntity();
        CardDto cardDto = visaCardDto();
        when(visaRepository.findById(1)).thenReturn(Optional.of(cardEntity));
        when(visaMapper.toDto(cardEntity)).thenReturn(cardDto);

        var actual = underTest.getAmount(cardDto);

        assertThat(actual).isEqualTo(666);
        //optional
        verifyNoInteractions(masterCardMapper);
        verifyNoInteractions(masterCardRepository);
    }

    @Test
    void getAmount_mastercard() {
        CardEntity cardEntity = masterCardEntity();
        CardDto cardDto = masterCardDto();
        when(masterCardRepository.findById(1)).thenReturn(Optional.of(cardEntity));
        when(masterCardMapper.toDto(cardEntity)).thenReturn(cardDto);

        var actual = underTest.getAmount(cardDto);

        assertThat(actual).isEqualTo(666);
        //optional
        verifyNoInteractions(visaMapper);
        verifyNoInteractions(visaRepository);
    }
}
