import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Emily", 24);
        Person person2 = new Person("Billy", 21);
        Person person3 = new Person("Den", 25);
        Person person4 = new Person("Emily", 28);
        Person person5 = new Person("Den", 25);
        Person person6 = new Person("Den", 21);

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

        Person[] persons = new Person[6];
        persons[0] = person1;
        persons[1] = person2;
        persons[2] = person3;
        persons[3] = person4;
        persons[4] = person5;
        persons[5] = person6;
        Person[] employees = new Person[6];
        employees[0] = employee1;
        employees[1] = employee2;
        employees[2] = employee3;
        employees[3] = employee4;
        employees[4] = employee5;
        employees[5] = employee6;
        Person[] developers = new Person[6];
        developers[0] = developer1;
        developers[1] = developer2;
        developers[2] = developer3;
        developers[3] = developer4;
        developers[4] = developer5;
        developers[5] = developer6;

        System.out.println("=========PERSONS===========");

        System.out.println(Arrays.toString(persons));

        Utility.sortPeople(persons, new PersonComparator<>());

        System.out.println(Arrays.toString(persons));

        System.out.println("=========EMPLOYEES===========");

        System.out.println(Arrays.toString(employees));

        Utility.sortPeople(employees, new EmployeeComparator());

        System.out.println(Arrays.toString(employees));

        System.out.println("=========DEVELOPERS===========");

        System.out.println(Arrays.toString(developers));

        Utility.sortPeople(developers, new DeveloperComparator());

        System.out.println(Arrays.toString(developers));
    }
}
