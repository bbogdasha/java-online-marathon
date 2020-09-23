import java.util.*;

public class MyUtils {

    public Map<String, List<String>> createNotebook(Map<String, String> phones) {

        Map<String, List<String>> result = new HashMap<String, List<String>>();
        Set<String> listPerson = new HashSet<String>();

        for (Iterator i = phones.entrySet().iterator(); i.hasNext();) {
            Map.Entry entry = (Map.Entry) i.next();
            listPerson.add((String) entry.getValue());
        }

        Iterator iterator = listPerson.iterator();
        while (iterator.hasNext()) {
            Object tmp = iterator.next();
            List<String> listPhones = new ArrayList<String>();
            for (Iterator i = phones.entrySet().iterator(); i.hasNext();) {
                Map.Entry entry = (Map.Entry) i.next();
                if (tmp == entry.getValue()) {
                    listPhones.add((String) entry.getKey());
                }
            }
            result.put((String) tmp, listPhones);
        }
        return result;
    }
}