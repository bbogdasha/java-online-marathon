import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Circle("Circle1", 2.00));
        shapes.add(new Rectangle("Rectangle1", 2.00, 3.00));
        shapes.add(new Circle("Circle2", 1.00));
        shapes.add(new Rectangle("Rectangle2", 3.00, 2.00));
        shapes.add(new Circle("Circle3", 0.50));
        shapes.add(new Rectangle("Rectangle3", 1.00, 2.00));

        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.maxAreas(shapes));
    }
}
