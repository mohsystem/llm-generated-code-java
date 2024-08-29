package codestral.task187;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task187Test {

    private H2O h2o;

    @BeforeEach
    void setUp() {
        h2o = new H2O();
    }

    private void runTest(int numHydrogen, int numOxygen, String expectedResult) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(numHydrogen + numOxygen);
        StringBuilder result = new StringBuilder();

        Runnable releaseHydrogen = () -> {
            result.append("H");
            latch.countDown();
        };
        Runnable releaseOxygen = () -> {
            result.append("O");
            latch.countDown();
        };

        // Create and start hydrogen threads
        for (int i = 0; i < numHydrogen; i++) {
            new Thread(() -> {
                try {
                    h2o.hydrogen(releaseHydrogen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Create and start oxygen threads
        for (int i = 0; i < numOxygen; i++) {
            new Thread(() -> {
                try {
                    h2o.oxygen(releaseOxygen);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        latch.await();
        assertEquals(expectedResult, result.toString());
    }

    @Test
    void testCase1() throws InterruptedException {
        runTest(2, 1, "HHO");
    }

    @Test
    void testCase2() throws InterruptedException {
        runTest(2, 1, "HHO");
    }

    @Test
    void testCase3() throws InterruptedException {
        runTest(2, 1, "HHO");
    }

    @Test
    void testCase4() throws InterruptedException {
        runTest(4, 2, "HHOHHOH");
    }

    @Test
    void testCase5() throws InterruptedException {
        runTest(4, 2, "HHOHHOH");
    }

    @Test
    void testCase6() throws InterruptedException {
        runTest(5, 4, "HHOHHOHHOH");
    }

    @Test
    void testCase7() throws InterruptedException {
        runTest(4, 2, "HHOHHO");
    }

    @Test
    void testCase8() throws InterruptedException {
        runTest(4, 2, "HHOHHO");
    }

    @Test
    void testCase9() throws InterruptedException {
        runTest(4, 2, "HHOHHO");
    }

    @Test
    void testCase10() throws InterruptedException {
        runTest(3, 3, "HHOHHOH");
    }
}
