import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Ivan"));
        people.add(new Student("Petro", "University", 3));
        people.add(new Worker("Andriy", "Developer", 12));
        people.add(new Student("Stepan", "College", 4));
        people.add(new Worker("Ira", "Manager", 8));
        people.add(new Student("Ihor", "University", 4));

        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.maxDuration(people));
    }
}
