import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Nick", 27, 2850.55);
        Employee employee2 = new Employee("Sara", 24, 2950.35);
        Employee employee3 = new Employee("Bart", 38, 3165.75);
        Employee employee4 = new Employee("Nick", 21, 1940.25);
        Employee employee5 = new Employee("Sara", 24, 2260.65);
        Employee employee6 = new Employee("Bart", 38, 3165.75);

        Developer developer1 = new Developer("Nick", 27, 2850.55, Level.MIDDLE);
        Developer developer2 = new Developer("Sara", 24, 2950.35, Level.SENIOR);
        Developer developer3 = new Developer("Bart", 38, 3165.75, Level.MIDDLE);
        Developer developer4 = new Developer("Nick", 21, 1940.25, Level.JUNIOR);
        Developer developer5 = new Developer("Sara", 24, 2260.65, Level.MIDDLE);
        Developer developer6 = new Developer("Bart", 38, 3165.75, Level.JUNIOR);

        Person[] people = new Person[6];
//        people[0] = employee1;
//        people[1] = employee2;
//        people[2] = employee3;
//        people[3] = employee4;
//        people[4] = employee5;
//        people[5] = employee6;
        people[0] = developer1;
        people[1] = developer2;
        people[2] = developer3;
        people[3] = developer4;
        people[4] = developer5;
        people[5] = developer6;

//        System.out.println(Arrays.toString(people));
//
//        Utility.sortPeople(people, new PersonComparator());
//
//        System.out.println(Arrays.toString(people));
//
//        Utility.sortPeople(people, new EmployeeComparator());

        System.out.println(Arrays.toString(people));

        Utility.sortPeople(people, new DeveloperComparator());

        System.out.println(Arrays.toString(people));
    }
}
