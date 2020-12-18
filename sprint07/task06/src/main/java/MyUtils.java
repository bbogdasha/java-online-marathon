import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        return list.stream()
                .flatMap(s -> s)
                .filter(s -> (s != null) && (!s.isEmpty()))
                .map(s -> s.replaceAll("[^\\d]", ""))
                .map(s -> s.length() == 7 ? "loc" .concat(s) : s.length() < 7 ? "err" .concat(s) : s)
                .distinct()
                .collect(Collectors.groupingBy(s -> s.substring(0, 3)))
                .entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().stream().map(s -> s.substring(3))
                        .sorted()));

        //Second Solution

//        return list.stream()
//                .flatMap(s -> s)
//                .filter(s -> (s != null) && (!s.isEmpty()))
//                .map(s -> s.replaceAll("[^\\d]", ""))
//                .map(s -> s.length() == 7 ? "loc" .concat(s) : s.length() < 7 ? "err" .concat(s) : s)
//                .distinct()
//                .sorted()
//                .collect(Collectors.toMap(
//                        s -> s.substring(0, 3),
//                        s -> Stream.of(s.substring(3)),
//                        Stream::concat));
    }
}