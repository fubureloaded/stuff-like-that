package duplicatecode.components;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRepository {

    public List<MyPojo> findAll() {
        return List.of();
    }
}
