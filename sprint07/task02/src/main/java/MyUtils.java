import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtils {

    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate dateNow = LocalDate.now();
        dateNow = dateNow.plusYears(years);
        dateNow = dateNow.plusMonths(months);
        dateNow = dateNow.plusDays(days);
        return dateNow.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
