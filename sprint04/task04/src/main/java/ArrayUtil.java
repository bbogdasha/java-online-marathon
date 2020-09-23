public class ArrayUtil {

    public static <T> T setAndReturn(T[] a, T b, int index) {
        return a[index] = b;
    }
}
