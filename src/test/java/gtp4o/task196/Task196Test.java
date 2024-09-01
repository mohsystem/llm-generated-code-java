package gtp4o.task196;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task196Test {

    @Test
    void testZeroEvenOdd1() throws InterruptedException {
        runTest(1, "01");
    }

    @Test
    void testZeroEvenOdd2() throws InterruptedException {
        runTest(2, "0102");
    }

    @Test
    void testZeroEvenOdd3() throws InterruptedException {
        runTest(5, "0102030405");
    }

    @Test
    void testZeroEvenOdd4() throws InterruptedException {
        runTest(10, "010203040506070809010");
    }

    @Test
    void testZeroEvenOdd5() throws InterruptedException {
        runTest(3, "010203");
    }

    @Test
    void testZeroEvenOdd6() throws InterruptedException {
        runTest(4, "01020304");
    }

    @Test
    void testZeroEvenOdd7() throws InterruptedException {
        runTest(6, "010203040506");
    }

    @Test
    void testZeroEvenOdd8() throws InterruptedException {
        runTest(7, "01020304050607");
    }

    @Test
    void testZeroEvenOdd9() throws InterruptedException {
        runTest(8, "0102030405060708");
    }

    @Test
    void testZeroEvenOdd10() throws InterruptedException {
        runTest(9, "010203040506070809");
    }

    private void runTest(int n, String expected) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        StringBuilder result = new StringBuilder();
        CountDownLatch latch = new CountDownLatch(1);

        Runnable zeroTask = () -> {
            try {
                zeroEvenOdd.zero(result::append);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable evenTask = () -> {
            try {
                zeroEvenOdd.even(result::append);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Runnable oddTask = () -> {
            try {
                zeroEvenOdd.odd(result::append);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        Thread zeroThread = new Thread(zeroTask);
        Thread evenThread = new Thread(evenTask);
        Thread oddThread = new Thread(oddTask);

        zeroThread.start();
        evenThread.start();
        oddThread.start();

        zeroThread.join();
        evenThread.join();
        oddThread.join();

        assertEquals(expected, result.toString());
    }
}
