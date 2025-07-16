package gemini.task189;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Task189Test {

    static class ZeroEvenOdd {
        private final int n;
        private int count = 0;
        private Semaphore z = new Semaphore(1);
        private Semaphore e = new Semaphore(0);
        private Semaphore o = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                z.acquire();
                printNumber.accept(0);
                count++;
                if (count % 2 == 0) {
                    e.release();
                } else {
                    o.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                e.acquire();
                printNumber.accept(i);
                z.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                o.acquire();
                printNumber.accept(i);
                z.release();
            }
        }
    }

    // Thread-safe output collector
    static class OutputCollector {
        private final StringBuilder sb = new StringBuilder();

        public synchronized void print(int x) {
            sb.append(x);
        }

        public synchronized String getOutput() {
            return sb.toString();
        }
    }

    public void test_n_5() throws InterruptedException {
        int n = 5;
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
        OutputCollector outputCollector = new OutputCollector();

        IntConsumer printNumber = outputCollector::print;

        Thread tZero = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tEven = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tOdd = new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tZero.start();
        tEven.start();
        tOdd.start();

        tZero.join();
        tEven.join();
        tOdd.join();

        String output = outputCollector.getOutput();
        if ("0102030405".equals(output)) {
            System.out.println("test_n_5: PASS");
        } else {
            System.out.println("test_n_5: FAIL");
            System.out.println("Output: " + output);
        }
    }

    public void test_n_2() throws InterruptedException {
        int n = 2;
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
        OutputCollector outputCollector = new OutputCollector();

        IntConsumer printNumber = outputCollector::print;

        Thread tZero = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tEven = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread tOdd = new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        tZero.start();
        tEven.start();
        tOdd.start();

        tZero.join();
        tEven.join();
        tOdd.join();

        String output = outputCollector.getOutput();
        if ("0102".equals(output)) {
            System.out.println("test_n_2: PASS");
        } else {
            System.out.println("test_n_2: FAIL");
            System.out.println("Output: " + output);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task189Test test = new Task189Test();
        test.test_n_5();
        test.test_n_2();
    }
}
