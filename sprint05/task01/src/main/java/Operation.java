class Operation{

    private final static String EXCEPTION = "both arguments should be more than zero";

    public static  int squareRectangle (int length, int width) {
        if (length <= 0 || width <= 0)
            throw new IllegalArgumentException(EXCEPTION);
        return length * width;
    }

    public static int trySquareRectangle(int length, int width) {
        try {
            return squareRectangle(length, width);
        } catch (IllegalArgumentException e) {
            return -1;
        }
    }
}