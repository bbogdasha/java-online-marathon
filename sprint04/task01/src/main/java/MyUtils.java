import java.util.*;

public class MyUtils {

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map<String, List<String>> notebook = new HashMap<String, List<String>>();
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            List<String> list = notebook.get(entry.getValue());
            if (list == null) {
                list = new ArrayList<String>();
            }
            list.add(entry.getKey());
            notebook.put(entry.getValue(), list);
        }
        return notebook;
    }
}