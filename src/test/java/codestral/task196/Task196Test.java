package codestral.task196;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task196Test {

    private void testZeroEvenOdd(int n, String expected) throws InterruptedException {
        StringBuilder output = new StringBuilder();
        CountDownLatch latch = new CountDownLatch(n * 2); // Change latch count to match total expected output length
        Semaphore zeroSem = new Semaphore(1);
        Semaphore evenSem = new Semaphore(0);
        Semaphore oddSem = new Semaphore(0);

        IntConsumer printNumber = num -> {
            output.append(num);
            latch.countDown();
        };

        ZeroEvenOdd zeo = new ZeroEvenOdd(n);

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

        latch.await(); // Wait for all threads to finish

        threadA.join();
        threadB.join();
        threadC.join();

        assertEquals(expected, output.toString());
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
