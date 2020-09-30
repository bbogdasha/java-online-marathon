import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class User {

    public final List<Integer> values = new ArrayList<>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction, Predicate<Integer> predicate){
        return biFunction.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
    }
}
