import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyUtils {

    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        Set<String> listToSet = new HashSet<>(map.values());
        Set<String> mapToSet = new HashSet<>(list);
        return listToSet.equals(mapToSet);
    }
}
