package llama3.task189;

public class Task189Test {

    interface printNumber {
        void print(int i);
    }

    static class ZeroEvenOdd {
        private int n;
        private int state;
        private final Object lock = new Object();

        public ZeroEvenOdd(int n) {
            this.n = n;
            this.state = 0;
        }

        public void zero(printNumber printNumber) {
            for (int i = 0; i < n * 2; i++) {
                synchronized (lock) {
                    while (state % 3 != 0) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    printNumber.print(0);
                    state++;
                    lock.notifyAll();
                }
            }
        }

        public void even(printNumber printNumber) {
            for (int i = 2; i <= n * 2; i += 2) {
                synchronized (lock) {
                    while (state % 3 != 1) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    printNumber.print(i);
                    state++;
                    lock.notifyAll();
                }
            }
        }

        public void odd(printNumber printNumber) {
            for (int i = 1; i <= n * 2; i += 2) {
                synchronized (lock) {
                    while (state % 3 != 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    printNumber.print(i);
                    state++;
                    lock.notifyAll();
                }
            }
        }
    }

    static class OutputCollector implements printNumber {
        private final StringBuilder sb = new StringBuilder();

        @Override
        public synchronized void print(int i) {
            sb.append(i);
        }

        public synchronized String getOutput() {
            return sb.toString();
        }
    }

    public void test_n_5() throws InterruptedException {
        int n = 5;
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
        OutputCollector collector = new OutputCollector();

        Thread tZero = new Thread(() -> zeo.zero(collector));
        Thread tEven = new Thread(() -> zeo.even(collector));
        Thread tOdd = new Thread(() -> zeo.odd(collector));

        tZero.start();
        tEven.start();
        tOdd.start();

        tZero.join();
        tEven.join();
        tOdd.join();

        String result = collector.getOutput();
        if ("0102030405".equals(result)) {
            System.out.println("test_n_5: PASS");
        } else {
            System.out.println("test_n_5: FAIL");
            System.out.println("Output: " + result);
        }
    }

    public void test_n_2() throws InterruptedException {
        int n = 2;
        ZeroEvenOdd zeo = new ZeroEvenOdd(n);
        OutputCollector collector = new OutputCollector();

        Thread tZero = new Thread(() -> zeo.zero(collector));
        Thread tEven = new Thread(() -> zeo.even(collector));
        Thread tOdd = new Thread(() -> zeo.odd(collector));

        tZero.start();
        tEven.start();
        tOdd.start();

        tZero.join();
        tEven.join();
        tOdd.join();

        String result = collector.getOutput();
        if ("0102".equals(result)) {
            System.out.println("test_n_2: PASS");
        } else {
            System.out.println("test_n_2: FAIL");
            System.out.println("Output: " + result);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task189Test test = new Task189Test();
        test.test_n_5();
        test.test_n_2();
    }
}
