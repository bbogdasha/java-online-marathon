import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {

    public static int getCount(int[] array, Predicate<Integer> predicate) {

        int count = 0;
        for (int i : array) {
            if (predicate.test(i))
                count += 1;
        }
        return count;
    }

    //The shortest solutions
    public static int getCountStream(int[] array, Predicate<Integer> predicate) {
        return (int) Arrays.stream(array).filter(predicate::test).count();
    }
}