import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {

    public Stream<String> nameList(Map<String, Stream<String>> map) {

        List<String> result = new ArrayList<>();
        for(Map.Entry<String, Stream<String>> entry : map.entrySet()){
            if (entry.getValue() != null) result.addAll(entry.getValue().collect(Collectors.toList()));
        }

        return result.stream()
                .filter(el -> el != null && !el.trim().isEmpty() && !el.equals(""))
                .map(str -> str.replaceAll(" ", ""))
                .map(String::toLowerCase)
                .map(x -> x.substring(0, 1).toUpperCase() + x.substring(1))
                .distinct()
                .sorted();
    }
}