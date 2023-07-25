package testing.any;

import org.springframework.stereotype.Component;

@Component
public class TestingForMockitoAny {

    private final DummyComponent dummyComponent;

    public TestingForMockitoAny(DummyComponent dummyComponent) {
        this.dummyComponent = dummyComponent;
    }

    public String calculate(String myString) {
        String newValue = myString; //+"something"
        return dummyComponent.dummyMethod(newValue);
    }
}
