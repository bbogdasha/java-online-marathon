import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyUtils {

    public static String getDateAfterToday(int years, int months, int days) {
        return LocalDate.now()
                .plusYears(years)
                .plusMonths(months)
                .plusDays(days)
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
