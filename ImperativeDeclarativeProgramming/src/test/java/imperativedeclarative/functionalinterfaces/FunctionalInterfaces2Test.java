package imperativedeclarative.functionalinterfaces;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FunctionalInterfaces2Test {

    private final FunctionalInterfaces2 underTest = new FunctionalInterfaces2();

    @Test
    void sortEmployees() {
        Employee employee1 = Employee.builder().firstName("B").lastName("X").age(10).build();
        Employee employee2 = Employee.builder().firstName("B").lastName("X").age(100).build();
        Employee employee3 = Employee.builder().firstName("A").lastName("Y").age(200).build();
        Employee employee4 = Employee.builder().firstName("A").lastName("Y").age(20).build();
        List<Employee> input = new ArrayList<>();
        input.add(employee1);
        input.add(employee2);
        input.add(employee3);
        input.add(employee4);
        List<Employee> expected = List.of(employee4, employee3, employee1, employee2);

        var actual = underTest.sortEmployees(input);

        assertThat(actual).isEqualTo(expected);
    }

}
