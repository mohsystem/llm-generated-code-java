package llama3.task196;

import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task196Test {

    @Test
    void testZeroEvenOdd1() throws InterruptedException {
        runTest(1, "010");
    }

    @Test
    void testZeroEvenOdd2() throws InterruptedException {
        runTest(2, "0102");
    } ////Expected: True

    @Test
    void testZeroEvenOdd3() throws InterruptedException {
        runTest(3, "010203");
    } ////Expected: True

    @Test
    void testZeroEvenOdd4() throws InterruptedException {
        runTest(4, "010204");
    }

    @Test
    void testZeroEvenOdd5() throws InterruptedException {
        runTest(5, "010205");
    }

    @Test
    void testZeroEvenOdd6() throws InterruptedException {
        runTest(6, "010206");
    }

    @Test
    void testZeroEvenOdd7() throws InterruptedException {
        runTest(7, "010207");
    }

    @Test
    void testZeroEvenOdd8() throws InterruptedException {
        runTest(8, "010208");
    }

    @Test
    void testZeroEvenOdd9() throws InterruptedException {
        runTest(9, "010209");
    }

    @Test
    void testZeroEvenOdd10() throws InterruptedException {
        runTest(10, "0102010");
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
