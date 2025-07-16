package codestral.task187;

import java.util.concurrent.Semaphore;

public class Task187Test {

    static class H2O {
        private Semaphore hSem;
        private Semaphore oSem;

        public H2O() {
            hSem = new Semaphore(2);
            oSem = new Semaphore(0);
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hSem.acquire();
            releaseHydrogen.run();
            oSem.release();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oSem.acquire(2);
            releaseOxygen.run();
            hSem.release(2);
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

    public void test_example1() throws InterruptedException {
        String water = "HOH";
        OutputCollector outputCollector = new OutputCollector();
        H2O h2o = new H2O();

        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.hydrogen(() -> outputCollector.print('H'));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.oxygen(() -> outputCollector.print('O'));
                    } catch (InterruptedException e) {
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

    public void test_example2() throws InterruptedException {
        String water = "OOHHHH";
        OutputCollector outputCollector = new OutputCollector();
        H2O h2o = new H2O();

        Thread[] threads = new Thread[water.length()];

        for (int i = 0; i < water.length(); i++) {
            if (water.charAt(i) == 'H') {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.hydrogen(() -> outputCollector.print('H'));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } else {
                threads[i] = new Thread(() -> {
                    try {
                        h2o.oxygen(() -> outputCollector.print('O'));
                    } catch (InterruptedException e) {
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

    public static void main(String[] args) throws InterruptedException {
        Task187Test test = new Task187Test();
        test.test_example1();
        test.test_example2();
    }
}
