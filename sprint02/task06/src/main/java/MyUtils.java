import java.util.*;

public class MyUtils {

    public List<Shape> maxAreas(List<Shape> shapes) {

        if (shapes.isEmpty()) {
            return shapes;
        }

        Map<String, Integer> map = new HashMap<>();
        for (Shape s : shapes) {
            Integer i = map.get(s.getClass().getName());
            map.put(s.getClass().getName(), (i == null) ? 1 : i + 1);
        }
        for (Map.Entry<String, Integer> val : map.entrySet()) {
            if (val.getKey().equals("Circle") && val.getValue() == 1) {
                return shapes;
            } else if (val.getKey().equals("Rectangle") && val.getValue() == 1) {
                return shapes;
            }
        }

        List<Shape> result = new ArrayList<>();

        List<Circle> circles = new ArrayList<>();
        Circle circle;
        List<Rectangle> rectangles = new ArrayList<>();
        Rectangle rectangle;

        for (Shape s : shapes) {
            if (s instanceof Circle) {
                circle = (Circle) s;
                circles.add(circle);
            } else if (s instanceof Rectangle) {
                rectangle = (Rectangle) s;
                rectangles.add(rectangle);
            }
        }
        Circle circleMax = Collections.max(circles, Comparator.comparing(Circle::getArea));
        Rectangle rectangle1Max = Collections.max(rectangles, Comparator.comparing(Rectangle::getArea));

        result.add(circleMax);
        result.add(rectangle1Max);

        for (Shape s : shapes) {
            if (rectangle1Max.getArea() == s.getArea() && s != rectangle1Max) {
                result.add(s);
            } else if (circleMax.getArea() == s.getArea() && s != circleMax) {
                result.add(s);
            }
        }
        return result;
    }
}
