import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyUtils {

    public List<Employee> largestEmployees(List<Employee> workers) {

        if (workers.isEmpty()) {
            return workers;
        }
        if (workers.size() == 1) {
            return workers;
        }
        for (Employee employee : workers) {
            if(employee == null){
                return workers;
            }
        }

        List<Employee> result = new ArrayList<>();

        List<Employee> employees = new ArrayList<>(workers);
        List<Manager> managers = new ArrayList<>();
        Manager manager;

        for (Employee e : workers) {
             if (e instanceof Manager) {
                manager = (Manager) e;
                managers.add(manager);
                employees.remove(e);
            }
        }

        Manager managerMaxPayment = Collections.max(managers, Comparator.comparing(Manager::getPayment));
        Manager managerMaxExp = Collections.max(managers, Comparator.comparing(Manager::getExperience));

        Employee employeeMaxPayment = Collections.max(employees, Comparator.comparing(Employee::getPayment));
        Employee employeeMaxExp = Collections.max(employees, Comparator.comparing(Employee::getExperience));

        result.add(managerMaxExp);
        result.add(employeeMaxExp);

        for (Manager m : managers) {
            if (managerMaxExp.getExperience() == m.getExperience() && m != managerMaxExp) {
                result.add(m);
            }
            if (managerMaxPayment.getPayment() == (m.getPayment()) && m != managerMaxPayment) {
                result.add(m);
            }
        }
        for (Employee e : employees) {
            if (employeeMaxExp.getExperience() == e.getExperience() && e != employeeMaxExp) {
                result.add(e);
            }
            if (employeeMaxPayment.getPayment() == (e.getPayment()) && e != employeeMaxPayment) {
                result.add(e);
            }
        }

        if (!managerMaxExp.equals(managerMaxPayment)) {
            result.add(managerMaxPayment);
        }
        if (!employeeMaxExp.equals(employeeMaxPayment)) {
            result.add(employeeMaxPayment);
        }

        return result;
    }
}
