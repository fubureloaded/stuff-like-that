package imperativedeclarative.optional;

import org.junit.jupiter.api.Test;

class TheOptional2Test {

    private final TheOptional2 underTest = new TheOptional2();

    @Test
    void withOrElse() {
        underTest.withOrElse("x");
    }

    @Test
    void withOrElseGet() {
        underTest.withOrElseGet("x");
    }
}
