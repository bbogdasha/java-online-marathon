import java.util.List;
import java.util.function.Predicate;

public class MyUtils {

    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        return numbers.stream()
                .filter(pr)
                .reduce(Integer.MIN_VALUE, Integer::max);
    }
}
