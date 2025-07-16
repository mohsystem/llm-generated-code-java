package gtp4o.task189;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Task189Test {

    static class Task189_OPENAI_gpt_4o {
        private int n;
        private Semaphore zeroSemaphore = new Semaphore(1);
        private Semaphore evenSemaphore = new Semaphore(0);
        private Semaphore oddSemaphore = new Semaphore(0);

        public Task189_OPENAI_gpt_4o(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                zeroSemaphore.acquire();
                printNumber.accept(0);
                if (i % 2 == 1) {
                    oddSemaphore.release();
                } else {
                    evenSemaphore.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                evenSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                oddSemaphore.acquire();
                printNumber.accept(i);
                zeroSemaphore.release();
            }
        }
    }

    // Thread-safe output collector to capture output
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
        Task189_OPENAI_gpt_4o zeo = new Task189_OPENAI_gpt_4o(n);
        OutputCollector outputCollector = new OutputCollector();

        IntConsumer printNumber = outputCollector::print;

        Thread threadZero = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadEven = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadOdd = new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadZero.start();
        threadEven.start();
        threadOdd.start();

        threadZero.join();
        threadEven.join();
        threadOdd.join();

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
        Task189_OPENAI_gpt_4o zeo = new Task189_OPENAI_gpt_4o(n);
        OutputCollector outputCollector = new OutputCollector();

        IntConsumer printNumber = outputCollector::print;

        Thread threadZero = new Thread(() -> {
            try {
                zeo.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadEven = new Thread(() -> {
            try {
                zeo.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadOdd = new Thread(() -> {
            try {
                zeo.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadZero.start();
        threadEven.start();
        threadOdd.start();

        threadZero.join();
        threadEven.join();
        threadOdd.join();

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
