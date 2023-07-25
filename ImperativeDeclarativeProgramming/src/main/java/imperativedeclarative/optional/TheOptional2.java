package imperativedeclarative.optional;

import java.util.Optional;

public class TheOptional2 {

    public String withOrElse(String param) {
        return Optional.ofNullable(param)
                .map(String::toLowerCase)
                .orElse(method());
    }

    public String withOrElseGet(String param) {
        return Optional.ofNullable(param)
                .map(String::toLowerCase)
                .orElseGet(this::method);
    }

    private String method() {
        System.out.println("=============================HELLO from private method==============================");
        return "EMPTY";
    }


}
