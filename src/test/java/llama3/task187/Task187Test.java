package llama3.task187;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Task187Test {

    static class H2O {
        private int hydrogenCount = 0;
        private int oxygenCount = 0;
        private final Lock hydrogenLock = new ReentrantLock();
        private final Lock oxygenLock = new ReentrantLock();
        private final Condition hydrogenCond = hydrogenLock.newCondition();
        private final Condition oxygenCond = oxygenLock.newCondition();

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hydrogenLock.lock();
            try {
                hydrogenCount++;
                while (hydrogenCount < 2 || oxygenCount < 1) {
                    hydrogenCond.await();
                }
                releaseHydrogen.run();
                hydrogenCount--;
                if (hydrogenCount == 0) {
                    oxygenCond.signalAll();
                }
            } finally {
                hydrogenLock.unlock();
            }
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oxygenLock.lock();
            try {
                oxygenCount++;
                while (oxygenCount < 1 || hydrogenCount < 2) {
                    oxygenCond.await();
                }
                releaseOxygen.run();
                oxygenCount--;
                if (oxygenCount == 0) {
                    hydrogenCond.signalAll();
                }
            } finally {
                oxygenLock.unlock();
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
