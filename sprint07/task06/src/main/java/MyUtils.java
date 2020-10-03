import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {

        List<String> listNumbers = new ArrayList<>();
        List<String> cleanNumbers;
        Map<String, Stream<String>> map = new HashMap<>();


        if (!list.contains(null)) list.forEach(i -> listNumbers.addAll(i.collect(Collectors.toList())));
        cleanNumbers = listNumbers.stream()
                .filter(el -> el != null && !el.trim().isEmpty())
                .map(str -> str.replaceAll("[ \\-()]", ""))
                .collect(Collectors.toList());

        for (String s : cleanNumbers) {
            if (s.length() == 10) {
                map.put(s.substring(0, 3), getNumber(s.substring(0, 3), cleanNumbers));
            } else if (s.length() == 7) {
                map.put("loc", cleanNumbers.stream()
                        .filter(i -> i.length() == 7));
            } else if (s.length() < 7)
                map.put("err", cleanNumbers.stream()
                        .filter(i -> i.length() < 7));
        }
        return map;
    }

    public Stream<String> getNumber(String code, List<String> list) {
        return list.stream()
                .filter(i -> i.substring(0, 3).contains(code))
                .map(s -> s.substring(3, 10))
                .sorted()
                .distinct();
    }
}