import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<Employee>();

        employees.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
        employees.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
        employees.add(new Employee("Stepan", 8, new BigDecimal(4000.00)));
        employees.add(new Employee("Andriy", 7, new BigDecimal(3500.00)));
        employees.add(new Employee("Ihor", 10, new BigDecimal(3500.00)));
        employees.add(new Manager("Vasyl", 8, new BigDecimal(2000.00), 2.0));

        MyUtils myUtils = new MyUtils();
        for (Employee m : myUtils.largestEmployees(employees)) {
            System.out.println(m.getName() + " : " + m.getExperience());
        }
    }
}
