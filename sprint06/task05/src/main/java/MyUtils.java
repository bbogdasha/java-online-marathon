import java.util.function.Predicate;
import java.util.Set;

public class MyUtils {

    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        return predicates.stream().reduce(Predicate::and).orElse(p -> false);
    }
}
