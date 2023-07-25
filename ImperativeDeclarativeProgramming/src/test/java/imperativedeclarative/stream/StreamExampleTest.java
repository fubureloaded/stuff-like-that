package imperativedeclarative.stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

class StreamExampleTest {

    StreamExample underTest = new StreamExample();

    @ParameterizedTest
    @CsvSource({" , , , TODAY",
            "2023-10-10, 2023-11-11, 2023-12-12, 2023-12-12",
            "2023-10-10, 2023-11-11, , 2023-11-11",
            ", 2023-05-05, , 2023-05-05"})
    void getRecentDateV1(LocalDate date1, LocalDate date2, LocalDate date3, String strExpected) {
        DatesObject input = DatesObject.builder()
                .date1(date1)
                .date2(date2)
                .date3(date3)
                .build();
        LocalDate expected = !"TODAY".equals(strExpected) ? LocalDate.parse(strExpected) : LocalDate.now();

        LocalDate actual = underTest.getRecentDateV1(input);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({" , , , TODAY",
            "2023-10-10, 2023-11-11, 2023-12-12, 2023-12-12",
            "2023-10-10, 2023-11-11, , 2023-11-11",
            ", 2023-05-05, , 2023-05-05"})
    void getRecentDateV2(LocalDate date1, LocalDate date2, LocalDate date3, String strExpected) {
        DatesObject input = DatesObject.builder()
                .date1(date1)
                .date2(date2)
                .date3(date3)
                .build();
        LocalDate expected = !"TODAY".equals(strExpected) ? LocalDate.parse(strExpected) : LocalDate.now();

        LocalDate actual = underTest.getRecentDateV2(input);

        assertThat(actual).isEqualTo(expected);
    }
}
