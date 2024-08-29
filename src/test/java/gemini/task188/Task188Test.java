package gemini.task188;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Task188Test {
    private FooBar fooBar;
    private StringBuilder output;

    @BeforeEach
    void setUp() {
        output = new StringBuilder();
    }

    @Test
    void testFooBarWithNEquals1() throws InterruptedException {
        fooBar = new FooBar(1);
        executeFooBarTest(fooBar, "foobar");
    }

    @Test
    void testFooBarWithNEquals2() throws InterruptedException {
        fooBar = new FooBar(2);
        executeFooBarTest(fooBar, "foobarfoobar");
    }

    @Test
    void testFooBarWithNEquals3() throws InterruptedException {
        fooBar = new FooBar(3);
        executeFooBarTest(fooBar, "foobarfoobarfoobar");
    }

    @Test
    void testFooBarWithNEquals4() throws InterruptedException {
        fooBar = new FooBar(4);
        executeFooBarTest(fooBar, "foobarfoobarfoobarfoobar");
    }

    @Test
    void testFooBarWithNEquals5() throws InterruptedException {
        fooBar = new FooBar(5);
        executeFooBarTest(fooBar, "foobarfoobarfoobarfoobarfoobar");
    }

    @Test
    void testFooBarWithNEquals10() throws InterruptedException {
        fooBar = new FooBar(10);
        executeFooBarTest(fooBar, "foobar".repeat(10));
    }

    @Test
    void testFooBarWithNEquals100() throws InterruptedException {
        fooBar = new FooBar(100);
        executeFooBarTest(fooBar, "foobar".repeat(100));
    }

    @Test
    void testFooBarWithNEquals500() throws InterruptedException {
        fooBar = new FooBar(500);
        executeFooBarTest(fooBar, "foobar".repeat(500));
    }

    @Test
    void testFooBarWithNEquals750() throws InterruptedException {
        fooBar = new FooBar(750);
        executeFooBarTest(fooBar, "foobar".repeat(750));
    }

    @Test
    void testFooBarWithNEquals1000() throws InterruptedException {
        fooBar = new FooBar(1000);
        executeFooBarTest(fooBar, "foobar".repeat(1000));
    }

    private void executeFooBarTest(FooBar fooBar, String expectedOutput) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(() -> {
            fooBar.foo();
            output.append("foo");
        });

        executorService.submit(() -> {
            fooBar.bar();
            output.append("bar");
        });

        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(10); // wait for all tasks to finish
        }

        assertEquals(expectedOutput, output.toString());
    }
}
