import java.util.function.Predicate;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<Predicate<Integer>> set = new HashSet<>();
        Predicate<Integer> isPositive1 = x -> x > 0;
        Predicate<Integer> isPositive2 = x -> x != 5;
        Predicate<Integer> isPositive3 = x -> x < 8;
        set.add(isPositive1);
        set.add(isPositive2);
        set.add(isPositive3);
        System.out.println(MyUtils.getPredicateFromSet(set).test(5));
    }
}
