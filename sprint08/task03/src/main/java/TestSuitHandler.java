import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestSuitHandler {

    static void run(Class<?> clazz) {
        if (clazz.isAnnotationPresent(TestSuite.class)) {
            TestSuite testSuite = clazz.getDeclaredAnnotation(TestSuite.class);
            for (String string : testSuite.value()) {
                if (checkSameMethods(string, clazz.getDeclaredMethods())) {
                    try {
                        System.out.println("\t -- Method " + clazz.getName() + "." + clazz.getDeclaredMethod(string).getName() + " started --");
                        clazz.getDeclaredMethod(string).invoke(clazz.getDeclaredConstructor().newInstance());
                        System.out.println("\t -- Method " + clazz.getName() + "." + clazz.getDeclaredMethod(string).getName() + " finished --");
                    } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } else System.out.println("Method with name " + string + " doesn't exists or not public in class " + clazz.getName());
            }
        } else {
            System.out.println("Class " + clazz.getName() + " isn't annotated");
        }
    }

    public static boolean checkSameMethods(String value, Method[] methods) {
        for (Method m : methods) {
            if (value.equals(m.getName()) && (m.getModifiers() & Modifier.PUBLIC) != 0) {
                return true;
            }
        }
        return false;
    }
}