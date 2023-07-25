package randomstuff.v2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.UUID;
import java.util.function.Supplier;

@Configuration
public class RandomConfig {

    @Bean
    public Supplier<LocalDate> localDateProvider() {
        return LocalDate::now;
    }

    @Bean
    public Supplier<UUID> uuidProvider() {
        return UUID::randomUUID;
    }
}
