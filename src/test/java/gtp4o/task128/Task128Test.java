package gtp4o.task128;

import org.junit.jupiter.api.RepeatedTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task128Test {

    @RepeatedTest(100)
    public void testRandomNumberInRange() {
        Random rand = new Random();
        int number = rand.nextInt(100) + 1;
        assertTrue(number >= 1 && number <= 100, "Number out of range: " + number);
    }
}
