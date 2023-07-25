package testing.any;

import org.springframework.stereotype.Component;

@Component
public class DummyComponent {

    public String dummyMethod(String param) {
        return param.toUpperCase();
    }
}
