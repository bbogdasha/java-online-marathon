import java.util.function.Consumer;

public class App {

    static Consumer<double[]> cons = doubles -> {
        for (int i = 0; i < doubles.length; i++) {
            if (doubles[i] > 2)
                doubles[i] *= 0.8;
            else doubles[i] *= 0.9;
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {

        double[] array = new double[initialArray.length];
        System.arraycopy(initialArray, 0, array, 0, array.length);
        consumer.accept(array);
        return array;
    }
}