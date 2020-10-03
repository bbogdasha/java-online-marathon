import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Map<String, Stream<String>> map = new HashMap<>();
        map.put("Desktop", Stream.of(" iVan", "PeTro ", " Ira "));
        map.put("Web", Stream.of("STepan", "ira ", " Andriy ", "an na"));
        map.put("Spring", Stream.of("Ivan", "Anna"));
//        map.put("Desktop", null);

        MyUtils myUtils = new MyUtils();
        myUtils.nameList(map).forEach(System.out::println);
    }
}
