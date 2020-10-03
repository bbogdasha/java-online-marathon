import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        MyUtils myUtils = new MyUtils();
        Stream<Integer> test = myUtils.duplicateElements(
                Stream.of(3, 2, 1, 1, 12, 3, 8, 2, 4, 2, -2, -1, 0, 0,13 , 13, -13, -13, -13, -13, null, null));
        test.forEach(System.out::println);
    }
}
