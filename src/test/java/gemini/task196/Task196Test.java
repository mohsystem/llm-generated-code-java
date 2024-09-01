package gemini.task196;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.function.IntConsumer;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task196Test {
    private void testZeroEvenOdd(int n, String expected) throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        StringBuilder result = new StringBuilder();
        CountDownLatch latch = new CountDownLatch(1);

        IntConsumer printNumber = num -> {
            result.append(num);
            if (result.length() == 2 * n) {
                latch.countDown();
            }
        };

        Thread zeroThread = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread evenThread = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread oddThread = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        zeroThread.start();
        evenThread.start();
        oddThread.start();

        latch.await();

        assertEquals(expected, result.toString());
    }
    @Test
    void testCase1() throws InterruptedException {
        testZeroEvenOdd(2, "0102");
    }

    @Test
    void testCase2() throws InterruptedException {
        testZeroEvenOdd(5, "0102030405");
    }

    @Test
    void testCase3() throws InterruptedException {
        testZeroEvenOdd(10, "010203040506070809010");
    }

    @Test
    void testCase4() throws InterruptedException {
        testZeroEvenOdd(1, "01");
    }

    @Test
    void testCase5() throws InterruptedException {
        testZeroEvenOdd(3, "010203");
    }

    @Test
    void testCase6() throws InterruptedException {
        testZeroEvenOdd(4, "01020304");
    }

    @Test
    void testCase7() throws InterruptedException {
        testZeroEvenOdd(6, "010203040506");
    }

    @Test
    void testCase8() throws InterruptedException {
        testZeroEvenOdd(7, "01020304050607");
    }

    @Test
    void testCase9() throws InterruptedException {
        testZeroEvenOdd(8, "0102030405060708");
    }

    @Test
    void testCase10() throws InterruptedException {
        testZeroEvenOdd(9, "010203040506070809");
    }
}
