import java.util.Comparator;

public class DeveloperComparator implements Comparator<Object> {

    private PersonComparator p = new PersonComparator();
    private EmployeeComparator e = new EmployeeComparator();

    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;

        int byAge = p.compare(o1, o2);
        if (byAge != 0) { return byAge; }

        int bySalary = e.compare(o1, o2);
        if (bySalary != 0) { return bySalary; }

        if (o1 instanceof Developer && o2 instanceof Developer) {
            result = ((Developer) o1).getLevel().compareTo(((Developer) o2).getLevel());
        }
        return result;
    }
}