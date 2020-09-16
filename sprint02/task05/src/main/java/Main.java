import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Square square1 = new Square(4.00);
        Square square2 = new Square(5.00);
        Rectang rectang = new Rectang(2.00, 3.00);

        List<Object> figures = new ArrayList<>();
        figures.add(square1);
        figures.add(square2);
        figures.add(rectang);

        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.sumPerimeter(figures));
    }
}
