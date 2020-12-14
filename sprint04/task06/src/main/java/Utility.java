import java.util.Arrays;
import java.util.Comparator;

public class Utility {

    public static<T extends Person> void sortPeople(T[] person, Comparator<? super T> comparator) {

        Arrays.sort(person, comparator);
    }
}
