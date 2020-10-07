import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class CheckCamelCase {

    public static final String CAMELCASE_PATTERN = "[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?";

    public static String checkAndPrint(Class clazz) {

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(CamelCase.class)){
                String name = method.getName();
                if (!name.matches(CAMELCASE_PATTERN)) {
                    System.out.println("method " + clazz.getName() + "." + name + " doesn't satisfy camelCase naming convention");
                }
            }
        }
        return "true";
    }
}
