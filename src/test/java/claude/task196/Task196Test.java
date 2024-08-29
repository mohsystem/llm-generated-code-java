package claude.task196;

import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task196Test {

    private void testZeroEvenOdd(int n, String expected) throws InterruptedException {
        StringBuilder output = new StringBuilder();
        CountDownLatch latch = new CountDownLatch(1);
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
    void testZeroEvenOdd1() throws InterruptedException {
        testZeroEvenOdd(1, "01");
    }

    @Test
    void testZeroEvenOdd2() throws InterruptedException {
        testZeroEvenOdd(2, "0102");
    }

    @Test
    void testZeroEvenOdd3() throws InterruptedException {
        testZeroEvenOdd(3, "010203");
    }

    @Test
    void testZeroEvenOdd4() throws InterruptedException {
        testZeroEvenOdd(4, "01020304");
    }

    @Test
    void testZeroEvenOdd5() throws InterruptedException {
        testZeroEvenOdd(5, "0102030405");
    }

    @Test
    void testZeroEvenOdd6() throws InterruptedException {
        testZeroEvenOdd(6, "010203040506");
    }

    @Test
    void testZeroEvenOdd7() throws InterruptedException {
        testZeroEvenOdd(7, "01020304050607");
    }

    @Test
    void testZeroEvenOdd8() throws InterruptedException {
        testZeroEvenOdd(8, "0102030405060708");
    }

    @Test
    void testZeroEvenOdd9() throws InterruptedException {
        testZeroEvenOdd(9, "010203040506070809");
    }

    @Test
    void testZeroEvenOdd10() throws InterruptedException {
        testZeroEvenOdd(10, "010203040506070809010");
    }
}
