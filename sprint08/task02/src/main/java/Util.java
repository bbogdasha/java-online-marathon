import java.lang.annotation.Annotation;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    public static void review(String className) {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
        LocalDate localDate = LocalDate.parse(LocalDate.now().format(dateTimeFormatter));

        try {
            Class<?> clazz = Class.forName(className);
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                if (a instanceof Review) {
                    Review review = (Review) a;
                    if (review.date().equals(localDate.toString()) || review.date().equals("today")) {
                        System.out.println("Class " + className + " was reviewed " + localDate + " by " + review.reviewer());
                    } else System.out.println("Class " + className + " was reviewed " + review.date() + " by " + review.reviewer() + ".");
                }
            }
            if (annotations.length == 0) System.out.println("Class " + className + " isn't marked as Reviewed");
        } catch (ClassNotFoundException e) {
            System.out.println("Class " + className + " was not found");
        }
    }
}
