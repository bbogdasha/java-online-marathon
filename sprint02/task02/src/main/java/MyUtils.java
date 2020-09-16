import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyUtils {
    public Map<String, Double> averageRating(List<Caffee> coffees) {

        Map<String, List<Integer>> groups = new HashMap<>();

        groups = coffees.stream().collect(
                Collectors.groupingBy(Caffee::getName, Collectors.mapping(Caffee::getRating, Collectors.toList())));

        Map<String, Double> average = new HashMap<>();

        for (Map.Entry<String, List<Integer>> entry : groups.entrySet()) {
            Integer sum = 0;
            if(!entry.getValue().isEmpty()) {
                for (Integer i : entry.getValue()) {
                    sum += i;
                }
            }
            average.put(entry.getKey(), sum.doubleValue() / entry.getValue().size());
        }
        return average;
    }
}
