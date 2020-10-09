class Accountant {
    public static int sum(int x, int y) {
        Runnable r = new ParallelCalculator((Integer::sum), x, y);
        Thread t = new Thread(r);
        try {
            t.start();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return x + y;
    }
}
