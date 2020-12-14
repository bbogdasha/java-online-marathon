import java.util.Comparator;

class PersonComparator<T extends Person> implements Comparator<T> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName()) == 0
                ? Integer.compare(o1.getAge(), o2.getAge())
                : o1.getName().compareTo(o2.getName());
    }
}
