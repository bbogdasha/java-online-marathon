import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestSuitHandler {

    static void run(Class<?> clazz) {
        for (Annotation annotation : clazz.getAnnotations()) {
            if (annotation instanceof TestSuite) {
                TestSuite testSuite = (TestSuite) annotation;
                for (String string : testSuite.value()) {
                    if (checkSameMethods(string, clazz.getDeclaredMethods())) {
                        try {
                            System.out.println("\t -- Method " + clazz.getName() + "." + clazz.getDeclaredMethod(string).getName() + " started --");
                            clazz.getDeclaredMethod(string).invoke(clazz.getDeclaredConstructor().newInstance());
                            System.out.println("\t -- Method " + clazz.getName() + "." + clazz.getDeclaredMethod(string).getName() + " finished --");
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    } else System.out.println("Method with name " + string + " doesn't exists or not public in class " + clazz.getName());
                }
            }
        }
        if (clazz.getAnnotations().length == 0) System.out.println("Class " + clazz.getName() + " isn't annotated");
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

