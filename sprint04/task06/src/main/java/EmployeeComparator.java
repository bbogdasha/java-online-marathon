import java.util.Comparator;

public class EmployeeComparator implements Comparator<Object> {

    private PersonComparator p = new PersonComparator();

    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;

        int byAge = p.compare(o1, o2);
        if (byAge != 0) { return byAge; }

        if (o1 instanceof Employee && o2 instanceof Employee) {
            Double bySalary1 = ((Employee) o1).getSalary();
            Double bySalary2 = ((Employee) o2).getSalary();
            result = bySalary1.compareTo(bySalary2);
        }

        return result;
    }
}
