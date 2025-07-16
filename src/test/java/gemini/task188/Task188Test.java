package gemini.task188;

public class Task188Test {

    static class FooBar {
        private int n;
        private final Object fooLock = new Object();
        private final Object barLock = new Object();
        private boolean fooTurn = true;

        public FooBar(int n) {
            this.n = n;
        }

        public void foo() {
            for (int i = 0; i < n; i++) {
                synchronized (fooLock) {
                    while (!fooTurn) {
                        try {
                            fooLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("foo");
                    fooTurn = false;
                    synchronized (barLock) {
                        barLock.notify();
                    }
                }
            }
        }

        public void bar() {
            for (int i = 0; i < n; i++) {
                synchronized (barLock) {
                    while (fooTurn) {
                        try {
                            barLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.print("bar");
                    fooTurn = true;
                    synchronized (fooLock) {
                        fooLock.notify();
                    }
                }
            }
        }
    }

    // To capture output safely for tests
    static class OutputCollector {
        private final StringBuilder sb = new StringBuilder();

        public synchronized void print(String s) {
            sb.append(s);
        }

        public synchronized String getOutput() {
            return sb.toString();
        }
    }

    public void test_n_1() throws InterruptedException {
        int n = 1;
        FooBar fooBar = new FooBar(n);
        OutputCollector outputCollector = new OutputCollector();

        Thread threadFoo = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                synchronized (fooBar.fooLock) {
                    while (!fooBar.fooTurn) {
                        try {
                            fooBar.fooLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    outputCollector.print("foo");
                    fooBar.fooTurn = false;
                    synchronized (fooBar.barLock) {
                        fooBar.barLock.notify();
                    }
                }
            }
        });

        Thread threadBar = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                synchronized (fooBar.barLock) {
                    while (fooBar.fooTurn) {
                        try {
                            fooBar.barLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    outputCollector.print("bar");
                    fooBar.fooTurn = true;
                    synchronized (fooBar.fooLock) {
                        fooBar.fooLock.notify();
                    }
                }
            }
        });

        threadFoo.start();
        threadBar.start();

        threadFoo.join();
        threadBar.join();

        String expected = "foobar";
        String actual = outputCollector.getOutput();
        if (expected.equals(actual)) {
            System.out.println("test_n_1: PASS");
        } else {
            System.out.println("test_n_1: FAIL");
            System.out.println("Output: " + actual);
        }
    }

    public void test_n_2() throws InterruptedException {
        int n = 2;
        FooBar fooBar = new FooBar(n);
        OutputCollector outputCollector = new OutputCollector();

        Thread threadFoo = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                synchronized (fooBar.fooLock) {
                    while (!fooBar.fooTurn) {
                        try {
                            fooBar.fooLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    outputCollector.print("foo");
                    fooBar.fooTurn = false;
                    synchronized (fooBar.barLock) {
                        fooBar.barLock.notify();
                    }
                }
            }
        });

        Thread threadBar = new Thread(() -> {
            for (int i = 0; i < n; i++) {
                synchronized (fooBar.barLock) {
                    while (fooBar.fooTurn) {
                        try {
                            fooBar.barLock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    outputCollector.print("bar");
                    fooBar.fooTurn = true;
                    synchronized (fooBar.fooLock) {
                        fooBar.fooLock.notify();
                    }
                }
            }
        });

        threadFoo.start();
        threadBar.start();

        threadFoo.join();
        threadBar.join();

        String expected = "foobarfoobar";
        String actual = outputCollector.getOutput();
        if (expected.equals(actual)) {
            System.out.println("test_n_2: PASS");
        } else {
            System.out.println("test_n_2: FAIL");
            System.out.println("Output: " + actual);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Task188Test test = new Task188Test();
        test.test_n_1();
        test.test_n_2();
    }
}
