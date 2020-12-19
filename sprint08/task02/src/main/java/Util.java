import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    private final static LocalDate localDate = LocalDate.parse(LocalDate.now().format(dateTimeFormatter));

    public static void review(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Review.class)) {
                Review review = clazz.getAnnotation(Review.class);
                if (review.date().equals(localDate.toString()) || review.date().equals("today")) {
                    System.out.println("Class " + className + " was reviewed " + localDate + " by " + review.reviewer());
                } else System.out.println("Class " + className + " was reviewed " + review.date() + " by " + review.reviewer() + ".");
            } else {
                System.out.println("Class " + className + " isn't marked as Reviewed");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }
}