import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, String> person = new HashMap<String, String>();
        person.put("0967654321", "Petro");
        person.put("0677654321", "Petro");
        person.put("0501234567", "Ivan");
        person.put("0970011223", "Stepan");
        person.put("0631234567", "Ivan");

        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.createNotebook(person));
    }
}
