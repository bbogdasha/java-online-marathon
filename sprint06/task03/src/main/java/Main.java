import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Bob", "Bobish"));
        people.add(new Person("Carl", "Carlitto"));
        people.add(new Person("Emmy", "Emmyla"));

        System.out.println(App.createGreetings(people, App.greetingOperator));
    }
}
