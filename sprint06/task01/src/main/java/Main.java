import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Predicate<Integer> predicate = x -> x > 0;

        int[] array = {3, 5, 6, -4, -2, -1, 7};

        System.out.println(MyUtils.getCount(array, predicate));
    }
}
