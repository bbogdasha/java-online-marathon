public class Main {

    public static void main(String[] args) {


    }

    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperation(a, b);
        System.out.println(result);
    }

    public static void addAtoB(int a, int b) {
        execute(a, b, new Strategy() {
            public double doOperation(int a, int b) {
                return a + b;
            }
        });
    }

    public static void subtractBfromA(int a, int b) {
        execute(a, b, new Strategy() {
            public double doOperation(int a, int b) {
                return a - b;
            }
        });
    }

    public static void multiplyAbyB(int a, int b) {
        execute(a, b, new Strategy() {
            public double doOperation(int a, int b) {
                return a * b;
            }
        });
    }

    public static void divideAbyB(int a, int b) {
        execute(a, b, new Strategy() {
            public double doOperation(int a, int b) {
                return a / b;
            }
        });
    }
}
