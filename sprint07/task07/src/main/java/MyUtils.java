import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<Integer> duplicateElements(Stream<Integer> stream) {
        Set<Integer> items = new HashSet<>();
        return stream.filter(n -> !items.add(n) && n != null)
                .collect(Collectors.toSet())
                .stream()
                .sorted();
    }
}