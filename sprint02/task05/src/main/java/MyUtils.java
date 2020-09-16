import java.util.List;

public class MyUtils {

    public double sumPerimeter(List<?> firures) {

        double result = 0;
        for (Object o : firures) {
            if (o instanceof Rectang) {
                result = result + ((Rectang) o).getPerimeter();
            } else if (o instanceof Square) {
                result = result + ((Square) o).getPerimeter();
            }
        }
        return result;
    }
}
