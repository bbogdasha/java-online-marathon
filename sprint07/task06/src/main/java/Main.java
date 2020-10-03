import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Stream<String>> list = new ArrayList<>();
        list.add(Stream.of("093 987 65 43", "(050)1234567", "12-345"));
        list.add(Stream.of("067-21-436-57", "050-2345678", "0939182736", "224-19-28"));
        list.add(Stream.of("(093)-11-22-334", "044 435-62-18", "721-73-45"));
        //list.add(null);

        MyUtils myUtils = new MyUtils();
        String result = myUtils.phoneNumbers(list).entrySet()
                .stream()
                .map(entry -> entry.getKey() + " - " + entry.getValue().collect(Collectors.joining(", ")))
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
