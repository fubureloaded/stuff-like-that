package imperativedeclarative.stream;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Component
public class StreamExample {
    /*
    We have an object with three dates. Any date can be null.
    We need a method that returns the most recent date from those three dates.
    If all three dates are null, then return current date
     */

    public LocalDate getRecentDateV1(DatesObject input) {
        LocalDate date1 = input.getDate1();
        LocalDate date2 = input.getDate2();
        LocalDate date3 = input.getDate3();

        if (date1 == null && date2 == null && date3 == null) {
            return LocalDate.now();
        }

        List<LocalDate> notNullDates = new ArrayList<>();
        if (date1 != null) {
            notNullDates.add(date1);
        }
        if (date2 != null) {
            notNullDates.add(date2);
        }
        if (date3 != null) {
            notNullDates.add(date3);
        }
        notNullDates.sort(Comparator.reverseOrder());

        return notNullDates.get(0);

    }

    public LocalDate getRecentDateV2(DatesObject input) {
        return Stream.of(input.getDate1(), input.getDate2(), input.getDate3())
                .filter(Objects::nonNull)

                .max(Comparator.naturalOrder())
                //.sorted(Comparator.reverseOrder())
                //.findFirst()

                .orElseGet(LocalDate::now);
    }

}

@Data
@Builder
class DatesObject {
    private LocalDate date1;
    private LocalDate date2;
    private LocalDate date3;
}
