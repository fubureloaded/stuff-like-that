package imperativedeclarative.optional;

import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReturningOptional {

    private static final String UNKNOWN_YEAR = "Unknown";

    public String getFavoriteSong() {
        String songName = getSongName();
        String artist = getArtist();

        String year = getYear();
        if (year == null) {
            year = UNKNOWN_YEAR;
        }
        //String yearV2 = getYearV2().orElse(UNKNOWN_YEAR);

        return songName + " by " + artist + " (" + year + ")";
    }

    private String getSongName() {
        return "Of viata mea";
    }

    private String getArtist() {
        return "Adrian Puradelul Minune feat. Costi Ionita";
    }

    private String getYear() {
        return "2000";
    }

    private Optional<String> getYearV2() {
        return Optional.of("2000");
    }
}
