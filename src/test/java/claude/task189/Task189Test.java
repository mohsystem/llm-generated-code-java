package claude.task189;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Task189Test {

    static class ZeroEvenOdd {
        private int n;
        private Semaphore zeroSem, evenSem, oddSem;
        private int current;

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.zeroSem = new Semaphore(1);
            this.evenSem = new Semaphore(0);
            this.oddSem = new Semaphore(0);
            this.current = 1;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                zeroSem.acquire();
                printNumber.accept(0);
                if (current % 2 == 0) {
                    evenSem.release();
                } else {
                    oddSem.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n / 2; i++) {
                evenSem.acquire();
                printNumber.accept(current);
                current++;
                zeroSem.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < (n + 1) / 2; i++) {
                oddSem.acquire();
                printNumber.accept(current);
                current++;
                zeroSem.release();
            }
        }
    }

    // Helper class to capture printed output thread-safely
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

        Thread threadA = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        String result = outputCollector.getOutput();
        if ("0102030405".equals(result)) {
            System.out.println("test_n_5: PASS");
        } else {
            System.out.println("test_n_5: FAIL");
            System.out.println("Output was: " + result);
        }
    }

    public void test_n_2() throws InterruptedException {
        int n = 2;
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
        OutputCollector outputCollector = new OutputCollector();

        IntConsumer printNumber = outputCollector::print;

        Thread threadA = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();

        threadA.join();
        threadB.join();
        threadC.join();

        String result = outputCollector.getOutput();
        if ("0102".equals(result)) {
            System.out.println("test_n_2: PASS");
        } else {
            System.out.println("test_n_2: FAIL");
            System.out.println("Output was: " + result);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task189Test test = new Task189Test();
        test.test_n_5();
        test.test_n_2();
    }
}
