import java.util.Comparator;

public class PersonComparator implements Comparator<Object> {

    @Override
    public int compare(Object o1, Object o2) {
        int result = 0;
        if (o1 instanceof Person && o2 instanceof Person) {
            int byName = ((Person) o1).name.compareTo(((Person) o2).name);
            if (byName != 0) { return byName; }

            Integer byAge1 = ((Person) o1).age;
            Integer byAge2 = ((Person) o2).age;
            result = byAge1.compareTo(byAge2);
        }
        return result;
    }
}
