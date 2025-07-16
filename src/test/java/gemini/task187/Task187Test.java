package gemini.task187;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Task187Test {

    static class H2O {
        private Semaphore hSemaphore = new Semaphore(2);
        private Semaphore oSemaphore = new Semaphore(1);
        private CyclicBarrier barrier = new CyclicBarrier(3);

        public H2O() {}

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException, BrokenBarrierException {
            hSemaphore.acquire();
            try {
                barrier.await();
                releaseHydrogen.run();
            } finally {
                hSemaphore.release();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException, BrokenBarrierException {
            oSemaphore.acquire();
            try {
                barrier.await();
                releaseOxygen.run();
            } finally {
                oSemaphore.release();
            }
        }
    }

    // Thread-safe output collector for 'H' and 'O'
    static class OutputCollector {
        private final StringBuilder sb = new StringBuilder();

        public synchronized void print(char c) {
            sb.append(c);
        }

        public synchronized String getOutput() {
            return sb.toString();
        }
    }

    public void test_example1() throws InterruptedException, BrokenBarrierException {
        String water = "HOH";
        OutputCollector outputCollector = new OutputCollector();
        H2O h2o = new H2O();

        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.hydrogen(() -> outputCollector.print('H'));
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.oxygen(() -> outputCollector.print('O'));
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        String result = outputCollector.getOutput();
        boolean valid = (result.length() == 3) &&
                result.chars().filter(ch -> ch == 'H').count() == 2 &&
                result.chars().filter(ch -> ch == 'O').count() == 1;
        if (valid) {
            System.out.println("test_example1: PASS");
        } else {
            System.out.println("test_example1: FAIL");
            System.out.println("Output: " + result);
        }
    }

    public void test_example2() throws InterruptedException, BrokenBarrierException {
        String water = "OOHHHH";
        OutputCollector outputCollector = new OutputCollector();
        H2O h2o = new H2O();

        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.hydrogen(() -> outputCollector.print('H'));
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.oxygen(() -> outputCollector.print('O'));
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        String result = outputCollector.getOutput();
        boolean valid = (result.length() == 6) &&
                result.chars().filter(ch -> ch == 'H').count() == 4 &&
                result.chars().filter(ch -> ch == 'O').count() == 2;
        if (valid) {
            System.out.println("test_example2: PASS");
        } else {
            System.out.println("test_example2: FAIL");
            System.out.println("Output: " + result);
        }
    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Task187Test test = new Task187Test();
        test.test_example1();
        test.test_example2();
    }
}
