class ArrayUtil {

    static <N extends Number> double averageValue(Array<N> array) {
        N n;
        double sum = 0.0;
        for (int i = 0; i < array.length(); i++) {
            n = array.get(i);
            sum += n.doubleValue();
        }
        return sum / array.length();
    }
}