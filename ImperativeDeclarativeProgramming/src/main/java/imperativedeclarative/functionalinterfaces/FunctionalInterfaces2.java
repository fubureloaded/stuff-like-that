package imperativedeclarative.functionalinterfaces;

import lombok.Builder;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

public class FunctionalInterfaces2 {

    private static final Comparator<Employee> BY_FIRSTNAME = Comparator.comparing(Employee::getFirstName);
    private static final Comparator<Employee> BY_LASTNAME = Comparator.comparing(Employee::getLastName);
    private static final Comparator<Employee> BY_AGE = Comparator.comparing(Employee::getAge);

    public List<Employee> sortEmployees(List<Employee> employees) {
        employees.sort(BY_FIRSTNAME.thenComparing(BY_LASTNAME).thenComparing(BY_AGE));
        return employees;
    }

}

@Data
@Builder
class Employee {
    private String firstName;
    private String lastName;
    private Integer age;
}