class Accountant {
    public static int sum(int x, int y) {
        ParallelCalculator calculator = new ParallelCalculator(Integer::sum, x, y);
        Thread t = new Thread(calculator);
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return calculator.result;
    }
}
