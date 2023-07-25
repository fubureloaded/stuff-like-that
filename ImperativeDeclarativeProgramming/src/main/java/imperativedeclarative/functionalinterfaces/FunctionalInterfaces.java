package imperativedeclarative.functionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FunctionalInterfaces {

    /*
    Input param: a list of integers
    - retain only even numbers
    - add 10 to remaining numbers
    - retain only those that are greater than zero
    - convert the remaining numbers to string
    - return a list with string lengths
     */


    public List<Integer> getSomething(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % 2 == 0) {
                number = number + 10;
                if (number > 0) {
                    String nrStr = number.toString();
                    result.add(nrStr.length());
                }
            }
        }

        return result;
    }


    private static final Predicate<Integer> IS_EVEN_NUMBER = nr -> nr % 2 == 0;
    private static final UnaryOperator<Integer> PLUS_TEN = nr -> nr + 10;
    private static final Predicate<Integer> IS_GREATER_THAN_ZERO = nr -> nr > 0;


    public List<Integer> getSomethingWithFunctionalInterfaces(List<Integer> numbers) {
        return numbers.stream()
                .filter(IS_EVEN_NUMBER)
                .map(PLUS_TEN)
                .filter(IS_GREATER_THAN_ZERO)
                .map(Object::toString)
                .map(String::length)
                .toList();
    }

}
