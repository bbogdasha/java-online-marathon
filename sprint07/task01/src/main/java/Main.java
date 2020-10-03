import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        System.out.println(isLeapYear(2020));
    }

    public static boolean isLeapYear(int year) {
        LocalDate localDate = LocalDate.of(year, 1, 1);
        return localDate.isLeapYear();
    }
}
