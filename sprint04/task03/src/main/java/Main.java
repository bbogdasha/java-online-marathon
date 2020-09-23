import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("aa");
        list.add("cc");

        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "cc");
        map.put("2", "bb");
        map.put("3", "cc");
        map.put("4", "aa");
        map.put("5", "cc");

        MyUtils myUtils = new MyUtils();
        myUtils.listMapCompare(list, map);
    }
}
