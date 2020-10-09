import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        BinaryOperator<Integer> multiply = (x, y) -> x * y;
        Runnable r = new ParallelCalculator(multiply, 6, 6);
        Thread t = new Thread(r);
        t.start();

        System.out.println(Accountant.sum(5, 7));
    }
}