import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class App {

    static BinaryOperator<String> greetingOperator = (parameter1, parameter2) ->
            "Hello " + parameter1 + " " + parameter2 + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator) {

        List<String> result = new ArrayList<>();
        for (Person p : people) {
            result.add(binaryOperator.apply(p.name, p.surname));
        }
        return result;
    }
}