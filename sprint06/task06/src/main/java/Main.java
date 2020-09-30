import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 8, 12, 16, 9, 4);
        Predicate<Integer> predicate = integer -> integer < 15;
        System.out.println(MyUtils.findMaxByCondition(list, predicate));

        User user = new User();
        user.values.add(3);
        user.values.add(7);
        user.values.add(9);
        user.values.add(1);
        user.values.add(4);

        BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction = MyUtils::findMaxByCondition;
        Predicate<Integer> predicate2 = integer -> integer < 8;
        System.out.println(user.getFilterdValue(biFunction, predicate2));

        Predicate<Integer> predicate3 = integer -> integer < 5;
        System.out.println(user.getMaxValueByCondition(predicate3));
    }
}
